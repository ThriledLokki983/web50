package com.company;

<<<<<<< HEAD
import java.util.*;

public class Main {
    private static  ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 1.56);
        album.addSong("Soldier Fortune", 3.46);
        album.addSong("Hold on", 2.56);
        album.addSong("Holy man", 4.56);
        album.addSong("The gypsy", 4.3);
        album.addSong("You can't do it right", 4.3);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("Getting ready", 4.3);
        album.addSong("Ready to go", 3.53);
        album.addSong("I put the finger on you", 4.3);
        album.addSong("Evil walks", 4.3);
        album.addSong("Breaking the rules", 4.3);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("You can't do it right", playlist);
        albums.get(0).addToPlaylist("Holy man", playlist);
        albums.get(0).addToPlaylist("Not in there", playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(4, playlist);
        albums.get(1).addToPlaylist(1, playlist);
        albums.get(1).addToPlaylist(9, playlist);

        play(playlist);

    }

    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = false;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0){
            System.out.println("No songs in playlist");
            return;
        }else{
            System.out.println("Now Playing: " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("End of playlist");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("End of playlist!");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Playing: " + listIterator.previous().toString());
                    } else {
                        System.out.println("Start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Replaying: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("Start of playlist");
                        }
                        }else{
                            if (listIterator.hasNext()) {
                                System.out.println("Now Replaying " + listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("End of playlist!");
                            }
                        }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now Playing: " + listIterator.next().toString());
                        }else if (listIterator.hasPrevious()){
                            System.out.println("Now Playing: " + listIterator.previous().toString());
                        }
                    }else{
                        System.out.println("No songs in the playlist now.");
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("\nPress");
        System.out.println(
                "0 - Close App.\n" +
                        "1 - Next Song.\n" +
                        "2 - Previous Song.\n" +
                        "3 - Replay Song.\n" +
                        "4 - List All Songs\n" +
                        "5 - Show Instructions.\n"+
                        "6 - Delete Song\n");
        System.out.println("=================================================");
    }

    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("==================================================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("==================================================");
    }






















=======
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
>>>>>>> MobileExercise
}
