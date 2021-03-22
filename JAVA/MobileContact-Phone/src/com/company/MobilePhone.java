package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName()) >= 0){
            System.out.println("Contact already exist!");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0){
            System.out.println(oldContact.getName() + " is not found.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was updated to " + newContact.getName());
        return true;
    }

    // this should return the index of the contact if it exist
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    // This should loop through the contact list names and compare the name we have if it is already in the arraylist or not
    private int findContact(String name){
        for (int i = 0; i < this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}
