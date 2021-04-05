package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String muNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.muNumber = myNumber;                           // Initializing myNumber
        this.myContacts = new ArrayList<Contact>();          // Instantiating myContact class
    }

    private int findContact(Contact contactInfo){
        // This should return the id of the contactInfo if it exist in the ArrayList
        return this.myContacts.indexOf(contactInfo);
    }

    private int findContact(String name){
        // Iterate through our Contact list and compare the name passed to the in the method to the names in the
        // names in the list to see if it already exist or not
        for (int i = 0; i < this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(name)){
                return i;
            }
        }
        return -404;
    }

    public boolean addNewContact(Contact contactInfo){
        // returns true if contact does not exist
        if (findContact(contactInfo.getName()) >= 0){
            // System.out.println("Contact already exist!");
            return false;
        }
        // returns false if contact already exist
        myContacts.add(contactInfo);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        // returns true if newContact does not exist / can update
        int position = findContact(oldContact);
        if (findContact(oldContact) < 0){
            return false;
        }else if (findContact(newContact.getName()) != -404){
            return false;
        }
        // returns false if newContact already exist / cannot update
        this.myContacts.set(position, newContact);
        return true;
    }

    public boolean removeContact(Contact contactInfo){
        int position = findContact(contactInfo);
        // return true if contactInfo exist and was successfully removed
        if (position >= 0){
            this.myContacts.remove(position);
            return true;
        }
        // returns false if contactInfo does not exist
        return false;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if (position > 0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContact(){
        for (int i = 0; i < this.myContacts.size(); i++){
            System.out.println(
                    (1+i) + "." + this.myContacts.get(i).getName() + ":     "
                            + this.myContacts.get(i).getPhoneNumber());
        }
    }

}
