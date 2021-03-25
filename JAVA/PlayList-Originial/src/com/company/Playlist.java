package com.company;

import java.util.LinkedList;

public class Playlist {
    private String playListName;
    private LinkedList<Album> myAlbums;

    public Playlist(String playListName) {
        this.playListName = playListName;
        this.myAlbums = new LinkedList<>();
    }

    public String getPlayListName() {
        return playListName;
    }

    public LinkedList<Album> getMyAlbums() {
        return myAlbums;
    }

    private Album findAlbum(String albumName){
        for (int i = 0; i < this.myAlbums.size(); i++){
            Album theAlbum = myAlbums.get(i);
            if (theAlbum.getAlbumName().equals(albumName)){
                return theAlbum;
            }
        }
        return null;
    }

    public boolean createNewAlbumSongs(String albumName, String songName, double songDuration){
        if (findAlbum(albumName) == null){
          this.myAlbums.add(new Album(albumName));
        }
        return false;
    }

    public void printAlbumSongs(String albumName){
        Album theAlbum = findAlbum(albumName);
        if (theAlbum == null){
        }
        theAlbum.printAllSongs();
    }

    public void printAllAlbums(){
        for (int i = 0; i < this.myAlbums.size(); i++){
            Album theAlbum = this.myAlbums.get(i);
            System.out.println("Album Name: " + theAlbum.getAlbumName());
            for (int j = 0; j < theAlbum.getMySongs().size(); j++){
                System.out.println("Song Name: " +theAlbum.getMySongs().get(j) +
                        "Duration: " + theAlbum.getMySongs().get(j).getSongDuration());
            }
            System.out.println("===========================================================");
        }
    }



}
