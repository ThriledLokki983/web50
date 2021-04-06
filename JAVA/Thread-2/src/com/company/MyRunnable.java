package com.company;

import static com.company.ThreadColor.ANSI_RED;

/**
 * Name: Gideon Nimoh
 * Date: 4/6/21
 * Time: 4:02 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from the Runnable Class");
    }
}
