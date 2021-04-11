package Model;

import javax.swing.plaf.nimbus.State;
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
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTIST);
        if (sortOrder != ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
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



}
