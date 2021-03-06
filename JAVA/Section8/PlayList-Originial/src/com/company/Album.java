package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Album {
    private String albumName;
    private ArrayList<Song> mySongs;

    public Album(String albumName) {
        this.albumName = albumName;
        this.mySongs = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getMySongs() {
        return mySongs;
    }

    private Song findSong(String songName){
        for (int i = 0; i < this.mySongs.size(); i++){
            Song theSong = mySongs.get(i);
            if (theSong.getSongTitle().equals(songName)){
                return theSong;
            }
        }
        return null;
    }

    public boolean addSongs(String songName, double songDuration){
        if (findSong(songName) == null){
            this.mySongs.add(new Song(songName, songDuration));
            return true;
        }
        return false;
    }

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public void printAllSongs(){
        for (int i = 0; i < mySongs.size(); i++){
            System.out.println("Song title: " +
                    mySongs.get(i).getSongTitle() +
                     "      Duration: " + df2.format(mySongs.get(i).getSongDuration()) + "-min");
        }
    }
}
