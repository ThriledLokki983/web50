package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Kinepolis", 8, 12);

        if (theater.reserveSeat("B13")){
            System.out.println("Please pay for B13");
        }else{
            System.out.println("Seat is already reserved");
        }

        if (theater.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        }else{
            System.out.println("Seat is already reserved");
        }

        if (theater.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        }else{
            System.out.println("Seat is already reserved");
        }

        List<Theater.Seat> reverseSeat = new ArrayList<>(theater.getSeats());
        Collections.reverse(reverseSeat);
        printList(reverseSeat);

        List<Theater.Seat> priceSeat = new ArrayList<>(theater.getSeats());
        priceSeat.add(theater.new Seat("B00", 13.00));
        priceSeat.add(theater.new Seat("A00", 13.00));
        Collections.sort(priceSeat, Theater.PRICE_ORDER);
        printList(priceSeat);

    }


    public static void printList(List<Theater.Seat> list){
        // For each loop
        for (Theater.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("=========================================================");
    }
/**
    // If speed is not premium but memory is. Bubble Sort
    public static void sortList(List<? extends Theater.Seat> list){
        for(int i = 0; i < list.size(); i++){
            for (int j = i+1; j <list.size(); j++){
                if (list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }
 **/

    /**
     theater.getSeats();

     if (theater.bookSeat("A15")){
     System.out.println("Please pay");
     }else{
     System.out.println("Sorry, seat is taken");
     }

     if (theater.bookSeat("Z20")){
     System.out.println("Please pay");
     }else{
     System.out.println("Sorry, seat is taken");
     }

     System.out.println(26*20);
     System.out.println("Printing a shuffled seat copy");
     Collections.shuffle(seatCopy);
     //Collections.reverse(seatCopy);
     System.out.println("Printing SeatCopy");
     printList(seatCopy);
     System.out.println("Printing theater.seat");
     printList(theater.seats);

     Theater.Seat minSeat = Collections.min(seatCopy);
     Theater.Seat maxSeat = Collections.max(seatCopy);
     System.out.println("Min seat number: " + minSeat.getSeatNumber());
     System.out.println("Max seat number: " + maxSeat.getSeatNumber());

     sortList(seatCopy);
     System.out.println("Printing Sorted copy");
     printList(seatCopy);
     **/

    /**
     *  seatCopy.get(2).reserved();
     // A shallow copy. 2 separate lists but with the same reference
     List<Theater.Seat> seatCopy = new LinkedList<>(theater.seats);
     Collections.copy(seatCopy, theater.seats);
     printList(seatCopy);
     **/

}

