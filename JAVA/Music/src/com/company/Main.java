package com.company;

import Model.Artist;
import Model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Cannot open database!");
            return;
        }else{
            System.out.println("Database is now ACTIVE!");
        }
        List<Artist> artists = dataSource.queryArtist(7);
        if (artists == null){
            System.out.println("No Artist found!");
            return;
        }
        for (Artist artist : artists){
            System.out.println("ID: " + artist.getId() + "\t" + "Name: " + artist.getName());
        }

        List<String> albumForArtist = dataSource.queryAlbums("Iron Maiden", dataSource.ORDER_BY_ASC);
        System.out.println("==========================================");
        for (String album : albumForArtist){
            System.out.println(album);
        }


        dataSource.close();
    }

}
