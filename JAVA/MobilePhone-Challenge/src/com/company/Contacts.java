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
        System.out.println("You have a total of " + contactName.size() + " Contacts.");

        System.out.println("=========================================================");
        for (int i = 0; i < contactName.size(); i++){
            System.out.print((i+1) + ". " + contactName.get(i));
            System.out.print( ": " + contactNumber.get(i));
            System.out.println();
        }
        System.out.println("=========================================================");
    }

    private void modifyContactName(int index, String newName){
        contactName.set(index, newName);
        System.out.println(newName + " is now Saved.");
    }

    private void modifyContactNumber(int index, String newNumber){
        contactNumber.set(index, newNumber);
        System.out.println(newNumber + " is now Saved.");
    }

    private int findContactName(String item){
        return contactName.indexOf(item);
    }

    private int findContactNumber(String item){
        return contactNumber.indexOf(item);
    }

    public void modifyContactName(String currentName, String newName){
        int position = findContactName(currentName);
        modifyContactName(position, newName);
    }

    public void modifyContactNumber(String currentNumber, String newNumber){
        int position = findContactNumber(currentNumber);
        modifyContactNumber(position, newNumber);
    }



}
