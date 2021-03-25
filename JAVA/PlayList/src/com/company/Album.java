package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    private Song findSong(String title){
        for (Song checkSong: this.songs){
            if (checkSong.getTitle().equals(title)){
                return checkSong;
            }
        }
        return null;
    }

    private boolean addSong(String title, double durations){
        if (findSong(title) == null){
            this.songs.add(new Song(title, durations));
            return true;
        }
        return false;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This Album does not have track " + trackNumber);
        return false;
    }


    public boolean addToPlaylist(String trackTitle, LinkedList<Song> playlist){
      Song checkSong = findSong(trackTitle);
      if (checkSong != null){
          playlist.add(checkSong);
          return true;
      }
        System.out.println("The song " + trackTitle + " is not in this album.");
      return false;
    }
}
