package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pegeout pegeout = new Pegeout(36);
        pegeout.steer(45);
        pegeout.accelerate(45);
        pegeout.accelerate(20);
        pegeout.accelerate(-50);
    }
}
