package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Playlist playlist = new Playlist("The Playlist App:");
    private static Album album = new Album("Osokoo");

    public static void main(String[] args) {
	// write your code here

        boolean quit = false;
        startPlaylist();
        printActions();
        while (!quit){
            System.out.print("Select Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Stopping Playlist ........................");
                    System.out.println("=================================================");
                    quit = true;
                    break;
                case 1:
                    addSongs();
                    break;
                case 2:
                    addAlbumSongs();
                    break;
                case 3:
                    printSongs();
                    break;
                case 4:
                    printAllAlbumSongs();
                    break;
                case 5:
                    playlist.printAllAlbums();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void startPlaylist(){
        System.out.println("Starting Playlist..................");
    }

    private static void printActions(){
        System.out.println("\nPress");
        System.out.println(
                "0 - Close App.\n" +
                "1 - Add New Song.\n" +
                "2 - Add New Album & Songs\n" +
                "3 - Show All Songs.\n" +
                "4 - Show All Album & Songs\n" +
                        "5 - Show all Albums\n" +
                "6 - Show Instructions.\n");
        System.out.println("=================================================");
    }

    private static void addSongs(){
        double min = 1.90; double max = 5.50;
        System.out.print("Song Name: ");
        String songName = scanner.nextLine();
        double songDuration = (double) (Math.random() * (max - min + 1) + min);
        album.addSongs(songName, songDuration);
        System.out.println("Song Added.");
        System.out.println("=================================================");

    }

    private static void addAlbumSongs(){
        double min = 1.90; double max = 5.50;
        System.out.print("Album Name: ");
        String albumName = scanner.nextLine();
        System.out.print("Song Name: ");
        String songName = scanner.nextLine();
        double songDuration = (double) (Math.random() * (max - min + 1) + min);
        playlist.createNewAlbumSongs(albumName, songName, songDuration);
        System.out.println("Album & Song Added.");
        System.out.println("=================================================");

    }

    //Album.aadSongs(songName, songDuration);
//    private static createPlaylist(){
//
//    }
    private static void printSongs(){
        System.out.println("======================= All Songs =========================");
        album.printAllSongs();
        System.out.println("===========================================================");
    }

    private static void printAllAlbumSongs(){
        System.out.println("======================= All Songs =========================");
        String albumName = scanner.nextLine();
        playlist.printAlbumSongs(albumName);
        System.out.println("===========================================================");
    }





















}
