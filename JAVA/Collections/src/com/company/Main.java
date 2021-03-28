package com.company;

public class Main {

    public static void main(String[] args) {
	 Theater theater = new Theater("Kinepolis", 50, 500);
	 theater.getSeats();

	 if (theater.bookSeat("A15")){
         System.out.println("Please pay");
     }else{
         System.out.println("Sorry, seat is taken");
     }

        if (theater.bookSeat("Z500")){
            System.out.println("Please pay");
        }else{
            System.out.println("Sorry, seat is taken");
        }

        System.out.println(50*500);
    }
}
