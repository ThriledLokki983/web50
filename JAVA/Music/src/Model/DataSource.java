package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Name: Gideon Nimoh
 * Date: 4/11/21
 * Time: 7:35 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class DataSource {
    public static final String DB_NAME = "music.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/ogidi/dev/web50/JAVA/Music/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTIST = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    /* Querying Albums by Artist*/
    public static final String QUERY_ALBUMS_BY_ARTIST_START = "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME +
            " FROM " + TABLE_ALBUMS + " INNER JOIN " + TABLE_ARTIST + " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTIST + '.' + COLUMN_ARTIST_ID + " WHERE " + TABLE_ARTIST + '.' + COLUMN_ARTIST_NAME + " = \"";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT = " ORDER BY " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";
    /* End of Query -- but we can add const query anytime we want */

    /* Querying Artist constants */
    public static final String QUERY_ALL_ARTIST = "SELECT * FROM " + TABLE_ARTIST;

    public static final String QUERY_ALL_ARTIST_SORT = " ORDER BY " + TABLE_ARTIST + '.' + COLUMN_ARTIST_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_FOR_SONG_START = "SELECT " + TABLE_ARTIST + '.' + COLUMN_ARTIST_NAME + "," + TABLE_ALBUMS +
            '.' + COLUMN_ALBUM_NAME + "," + TABLE_SONGS + '.' + COLUMN_SONG_TRACK + " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS +
            " ON " + TABLE_SONGS + '.' + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTIST +
            " ON " + TABLE_ARTIST + '.' + COLUMN_ARTIST_ID + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " WHERE " + TABLE_SONGS + "."
            + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT = "ORDER BY " + TABLE_ARTIST + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + "."
            + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";
    /* End of that query but can add new ones anytime we want */


    /* VIEW Table */
    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_SONG_VIEW + " AS SELECT " +
            TABLE_ARTIST + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + '.' + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." +
            COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTIST + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTIST + "." +
            COLUMN_ARTIST_ID + " ORDER BY " +
            TABLE_ARTIST + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK;

    // SELECT Album_Name, Artist_Name, Song_Title FROM artist_list WHERE Song_Title = "title";
    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ARTIST_NAME + ", " + COLUMN_SONG_ALBUM + ", " +
            COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = \"";


    private Connection conn;

    public boolean open(){
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        }catch (SQLException e){
            System.out.println("Could not connect to database " + e.getMessage());
            return false;
        }
    }

    public void close(){
        try {
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e){
            System.out.println("Could not close database " + e.getMessage());
        }
    }

    public List<Artist> queryArtist(int sortOrder){
        StringBuilder sb = new StringBuilder(QUERY_ALL_ARTIST);
        if (sortOrder != ORDER_BY_NONE){
            sb.append(QUERY_ALL_ARTIST_SORT);
            if (sortOrder == ORDER_BY_ASC){
                sb.append("DESC");
            }else{
                sb.append("ASC");
            }
        }

        try (Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(sb.toString())){
            List<Artist> artists = new ArrayList<>();
            while (result.next()){
                Artist artist = new Artist();
                artist.setId(result.getInt(INDEX_ARTIST_ID));
                artist.setName(result.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;

        }catch (SQLException e){
            System.out.println("Could not query Artist: " + e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbums (String artistName, int sortOrder){
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE){
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if (sortOrder == ORDER_BY_DESC){
                sb.append(" DESC ");
            }else{
                sb.append(" ASC ");
            }
        }
        //System.out.println("SQL statement = " + sb.toString());

        try(Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sb.toString())) {

            List<String> albums = new ArrayList<>();
            while (result.next()){
                albums.add(result.getString(1));
            }
            return albums;

        }catch (SQLException e){
            System.out.println("Error Querying Album: " + e.getMessage());
            return null;
        }
    }

    public List<SongArtist> queryArtistsForSong(String songName, int sortOrder){
        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        sb.append(songName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE){
            sb.append(QUERY_ARTIST_FOR_SONG_SORT);
            if (sortOrder == ORDER_BY_DESC){
                sb.append(" DESC ");
            }else{
                sb.append(" ASC ");
            }
        }
        //System.out.println(sb.toString());
        try(Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sb.toString())) {

            List<SongArtist> songArtists = new ArrayList<>();

            while (result.next()){
                SongArtist songArtist = new SongArtist();
                songArtist.setArtisName(result.getString(1));
                songArtist.setAlbumName(result.getString(2));
                songArtist.setTrack(result.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        }catch (SQLException e){
            System.out.println("Error Querying artist for song: " + e.getMessage());
            return null;
        }
    }

    public void querySongsMetaData(){
        String sql = "SELECT * FROM " + TABLE_SONGS;
        try(Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql)) {

            ResultSetMetaData meta = result.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i <= numColumns; i++){
                System.out.format("Column %d in the songs table is names %s\n", i, meta.getColumnName(i));
            }
        }catch (SQLException e){
            System.out.println("ERROR " + e.getMessage());
        }
    }

    public int getCount(String table){
        String sql = "SELECT COUNT(*) AS count FROM " + table;
        try(Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql)) {
            int count = result.getInt("count");
            //System.out.format("Count: %d " + "\t" , count);
            return count;
        }catch (SQLException e){
            System.out.println("Error with count: " + e.getMessage());
            return -1;
        }
    }

    public boolean createViewSongsArtist(){
        try(Statement statement = conn.createStatement()) {
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;

        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // SELECT Album_Name, Artist_Name, Song_Title FROM artist_list WHERE Song_Title = "title";
    public List<SongArtist> querySongInfoView(String title){
        StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO);
        sb.append(title);
        sb.append("\"");

        System.out.println(sb.toString());

        try(Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sb.toString())) {

            List<SongArtist> songArtists = new ArrayList<>();
            while (result.next()){
                SongArtist songArtist = new SongArtist();

                songArtist.setArtisName(result.getString(1));
                songArtist.setAlbumName(result.getString(2));
                songArtist.setTrack(result.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }

}
