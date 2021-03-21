package com.company;

import java.util.ArrayList;

public class Contacts {
    private ArrayList<String> contactName = new ArrayList<>();
    private ArrayList<String> contactNumber = new ArrayList<>();

    public ArrayList<String> getContactName() {
        return contactName;
    }

    public ArrayList<String> getContactNumber() {
        return contactNumber;
    }

    public void addName(String name){
        contactName.add(name);
    }

    public void addNumber(String number){
        contactNumber.add(number);
    }

    public void printAllContacts(){
        System.out.println("You have " + contactName.size() + " names in your contact list, and " + contactNumber.size() + " numbers");
        for (int i = 0; i < contactName.size(); i++){
            System.out.print((i+1) + ". " + contactName.get(i));
            System.out.print( " " + contactNumber.get(i));
            System.out.println();
        }
    }






}
