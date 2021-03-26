package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ITelephone myPhone = new DeskPhone(12345);
        myPhone.powerOn();
        myPhone.callPhone(456987);
        myPhone.answer();

        myPhone = new MobilePhone(23456);
        myPhone.powerOn();
        myPhone.callPhone(459860);
        myPhone.answer();
        myPhone.dial(78965);
    }
}
