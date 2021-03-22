package com.company;

import java.util.ArrayList;
import java.util.Locale;

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
            System.out.println("=================================================\n");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0){
            System.out.println(oldContact.getName() + " is not found.");
            System.out.println("=================================================\n");
            return false;
        }else if (findContact(newContact.getName()) != -1){
            System.out.println("Contact Name: " + newContact.getName()
            + " already exist. Update not successful");
            System.out.println("=================================================\n");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName().toUpperCase(Locale.ROOT)
                + " was updated to " + newContact.getName().toUpperCase(Locale.ROOT));
        //System.out.println("=================================================\n");
        return true;
    }

    // this should return the index of the contact if it exist
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    // This should loop through the contact list names and compare the
    // name we have if it is already in the arraylist or not
    private int findContact(String name){
        for (int i = 0; i < this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    // returns the data as a string
    public String queryContact(Contact contact){
        if (findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if (position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public boolean removeContact(Contact contact){
        int findPosition = findContact(contact);
        if (findPosition < 0){
            System.out.println(contact.getName() + " was not found.");
            System.out.println("=================================================\n");
            return false;
        }
        this.myContacts.remove(findPosition);
        System.out.println(contact.getName() + " was deleted.");
        System.out.println("=================================================\n");
        return true;
    }

    public void printContacts(){
        System.out.println("================ All Contacts ===================");
        for (int i = 0; i < this.myContacts.size(); i++){
            System.out.println(
                    (1+i) + "." + this.myContacts.get(i).getName() + ":     " + this.myContacts.get(i).getNumber());
        }
        System.out.println("=================================================\n");
    }
}
