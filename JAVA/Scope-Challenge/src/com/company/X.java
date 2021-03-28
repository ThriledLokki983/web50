package com.company;

import java.util.Scanner;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 3:06 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class X {
    private int x;

    public X(Scanner x) {
        System.out.print("Enter value: ");
        this.x = x.nextInt();
    }

    public void x(){
        for (int x = 0; x <= 12; x++){
            System.out.println(x + " times " + this.x + " equals " + (x*this.x));
        }
    }

//    public static void x(int x){
//        for (int i = 1; i <= 12; i++){
//            System.out.println(x + " times " + i + " = " + (x*i));
//        }
//        System.out.println("==============================");
//    }

}
