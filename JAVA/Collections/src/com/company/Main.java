package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	 Theater theater = new Theater("Kinepolis", 26, 50);
	 List<Theater.Seat> seatCopy = new LinkedList<>(theater.seats);
	 printList(seatCopy);
	 seatCopy.get(2).reserved();
	 if (theater.bookSeat("A03")){
         System.out.println("Please pay for A03");
     }else{
         System.out.println("Seat is already reserved");
     }
	 //theater.getSeats();

//	 if (theater.bookSeat("A15")){
//         System.out.println("Please pay");
//     }else{
//         System.out.println("Sorry, seat is taken");
//     }
//
//        if (theater.bookSeat("Z20")){
//            System.out.println("Please pay");
//        }else{
//            System.out.println("Sorry, seat is taken");
//        }
//
//        System.out.println(26*20);
        Collections.shuffle(seatCopy);
        Collections.reverse(seatCopy);
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

    }


    public static void printList(List<Theater.Seat> list){
        for (Theater.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("=========================================================");
    }

    public static void sortList(List<? extends Theater.Seat> list){
        for(int i = 0; i < list.size(); i++){
            for (int j = i+1; j <list.size(); j++){
                if (list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }


}
