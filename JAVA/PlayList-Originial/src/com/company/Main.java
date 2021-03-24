package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Album album = new Album("Bondem");

    public static void main(String[] args) {
	// write your code here

        boolean quit = false;
        startPlaylist();
        while (!quit){
            System.out.print("Select Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printActions();
                    break;
                case 1:
                    addSongs();
                    break;
                case 2:
                    printAllSongs();
                    break;
                case 3:
                    System.out.println("Stopping Playlist ........................");
                    quit = true;
                    break;
            }
        }
    }

    private static void startPlaylist(){
        System.out.println("Starting Playlist..................");
    }

    private static void printActions(){
        System.out.println("\nPress");
        System.out.println("0 - Close App.\n" +
                "1 - Add New Song.\n" +
                "2 - Show All Songs.\n" +
                "3 - Show Instructions.\n");
        System.out.println("=================================================");
        //System.out.println("Select an Option: ");
    }

    private static void addSongs(){
        double min = 1.89; double max = 4.65;
        System.out.print("Song Name: ");
        String songName = scanner.nextLine();
        double songDuration = (double) (Math.random() * (max - min + 1) + min);
        album.addSongs(songName, songDuration);

    }

    private static void printAllSongs(){

    }




















}
