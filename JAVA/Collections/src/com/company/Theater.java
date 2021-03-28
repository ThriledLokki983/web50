package com.company;

import java.util.*;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 7:17 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Theater {
    private final String theatreName;
    private final List<Seat> seats = new LinkedList<>();


    public Theater(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++){
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat (String seatNumber){
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0){
            return seats.get(foundSeat).reserved();
        }else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
//        for (Seat seat: seats){
//            if (seat.getSeatNumber().equals(seatNumber)){
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if (requestedSeat == null){
//            System.out.println(seatNumber + " is not available");
//            return false;
//        }
//        return requestedSeat.reserved();
    }

    public boolean bookSeat(String seatNumber){
        int low = 0;
        int high = seats.size()-1;
        while(low <= high){
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0){
                low = mid + 1;
            }else if (cmp > 0){
                high = mid - 1;
            }else{
                return seats.get(mid).reserved();
            }
        }
        System.out.println(seatNumber + " does not exist");
        return false;
    }

    // for testing
    public void getSeats(){
        for (Seat seat : seats){
            System.out.println(seat.getSeatNumber());
        }
    }





    private class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public String getSeatNumber() {
            return seatNumber;
        }


        public boolean reserved(){
            if (!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " is already reserved");
                return true;
            }else{
                return false;
            }
        }
        public boolean cancel(){
            if (this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " is canceled");
                return true;
            }else{
                return false;
            }
        }


    }






}
