package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList mySongs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.mySongs = new SongList();
    }

//    private Song findSong(String title){
//        for (Song checkSong: this.mySongs){
//            if (checkSong.getTitle().equals(title)){
//                return checkSong;
//            }
//        }
//        return null;
//    }
    public boolean addSong(String title, double durations){
      return this.mySongs.addSong(new Song(title, durations));
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        Song checkedSong = mySongs.findSong(trackNumber);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("This Album does not have track: " + trackNumber);
        return false;
    }


    public boolean addToPlaylist(String trackTitle, LinkedList<Song> playlist){
      Song checkSong = mySongs.findSong(trackTitle);
      if (checkSong != null){
          playlist.add(checkSong);
          return true;
      }
        System.out.println("The song: " + trackTitle + " is not in this album.");
      return false;
    }


    private class SongList{
        private ArrayList<Song> mySongs;

        public SongList(){
            this.mySongs = new ArrayList<>();
        }

        public boolean addSong(Song songs){
            if (mySongs.contains(songs)){
                return false;
            }
            this.mySongs.add(songs);
            return true;
        }

        private Song findSong(String title){
            for (Song checkSong: this.mySongs){
                if (checkSong.getTitle().equals(title)){
                    return checkSong;
                }
            }
            return null;
        }

        private Song findSong(int songNumber){
            int index = songNumber - 1;
            if ((index >= 0) && (index < mySongs.size())){
                return mySongs.get(index);
            }
            return null;
        }
    }
}


