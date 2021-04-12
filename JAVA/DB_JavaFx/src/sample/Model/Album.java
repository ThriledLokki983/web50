package sample.Model;

/**
 * Name: Gideon Nimoh
 * Date: 4/11/21
 * Time: 7:57 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Album {
    private int id;
    private String name;
    private int artistId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
