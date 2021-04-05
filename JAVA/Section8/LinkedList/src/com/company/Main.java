package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

        addInOrder(placesToVisit, "Kumasi");
        addInOrder(placesToVisit, "Accra");
        addInOrder(placesToVisit, "Hague");
        addInOrder(placesToVisit, "New York");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "London");
        addInOrder(placesToVisit, "Ahodwo");
        addInOrder(placesToVisit, "Adelaide");
        printList(placesToVisit);
//
//
//        placesToVisit.add("Kumasi");
//        placesToVisit.add("Accra");
//        placesToVisit.add("Hague");
//        placesToVisit.add("New York");
//        placesToVisit.add("Melbourne");
//        placesToVisit.add("London");

        placesToVisit.add("Perth");
        addInOrder(placesToVisit, "Dunkwa");
        addInOrder(placesToVisit, "Accra");
        printList(placesToVisit);
        visit(placesToVisit);


    }

    private static void printList(LinkedList<String> linked){
        Iterator<String> i = linked.iterator();
        while(i.hasNext()){
            System.out.println("Now Visiting: " + i.next());
        }
        System.out.println("========================");
    }

    private static boolean addInOrder(LinkedList<String> list, String city){

        // This can also be used for an ArrayList
        ListIterator<String> stringList = list.listIterator();
        while (stringList.hasNext()){
            // below is the actual instance we get to the first object
            int compare = stringList.next().compareTo(city);
            if (compare == 0){
                // do not add
                System.out.println(city + ": Already added");
                return false;
            }else if (compare > 0){
                // new city should appear this one
                stringList.previous();
                stringList.add(city);
                return true;
            }else if (compare < 0){
                // move to next city because we cannot add it here
            }
        }
        stringList.add(city);
        return true;
    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> linkedList = cities.listIterator();
        if (cities.isEmpty()){
            System.out.println("No cities in the itenerary: ");
            return;
        }else{
            System.out.println("Now visiting: " + linkedList.next());
            printMenu();
        }
        while (!quit){
            int choice  = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Vacation is over........");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward){
                        if (linkedList.hasNext()){
                            linkedList.next();
                        }
                    }
                    if (linkedList.hasNext()){
                        System.out.println("Now visiting: " + linkedList.next());
                    }else{
                        System.out.println("Reached the end of the list:");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward){
                        if (linkedList.hasPrevious()){
                            linkedList.previous();
                        }
                    }
                    if (linkedList.hasPrevious()){
                        System.out.println("Now visiting: " + linkedList.previous());
                    }else{
                        System.out.println("We are at the start of the list:");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options");
        System.out.println("0 - Quit\n" +
                "1 - Next City\n" +
                "2 - Previous City\n" +
                "3 - Print Menu");
    }
}
