package Model;

/**
 * Name: Gideon Nimoh
 * Date: 4/11/21
 * Time: 7:58 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Song {
    private int id;
    private int track;
    private String name;
    private int albumId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
