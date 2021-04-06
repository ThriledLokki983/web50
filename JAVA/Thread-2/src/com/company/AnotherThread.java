package com.company;

import static com.company.ThreadColor.ANSI_BLUE;

/**
 * Name: Gideon Nimoh
 * Date: 4/6/21
 * Time: 4:02 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

        try {
            Thread.sleep(300);
        }catch (InterruptedException e){
            System.out.println(ANSI_BLUE + "Another Thread woke mw up");
            return;
        }
        System.out.println(ANSI_BLUE + "3secs passed and I'm awake now");
    }
}
