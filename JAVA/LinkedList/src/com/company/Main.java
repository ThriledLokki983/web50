package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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

//        placesToVisit.remove(4);
//        printList(placesToVisit);

    }

    private static void printList(LinkedList<String> linked){
        Iterator<String> i = linked.iterator();
        while(i.hasNext()){
            System.out.println("Now Visiting: " + i.next());
        }
        System.out.println("========================");
    }

    private static boolean addInOrder(LinkedList<String> list, String city){
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
}
