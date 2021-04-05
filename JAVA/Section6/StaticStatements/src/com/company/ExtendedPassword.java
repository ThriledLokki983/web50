package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 4:31 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

//    @Override
//    public void storePassword() {
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }
}
