package com.company;

public class Song {
    private String songTitle;
    private double songDuration;

    public Song(String songName, double songDuration) {
        this.songTitle = songName;
        this.songDuration = songDuration;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public double getSongDuration() {
        return songDuration;
    }

}
