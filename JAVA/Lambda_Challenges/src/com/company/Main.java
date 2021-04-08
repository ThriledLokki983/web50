package com.company;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = (() -> { String myString  = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String s : parts){
                System.out.println(s);
            }
        });
        new Thread(runnable).start();
    }

}
