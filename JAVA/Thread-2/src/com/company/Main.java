package com.company;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main Thread: ");

        /* You do not have to start a thread multiple times*/
        Thread anoThread = new AnotherThread();
        anoThread.setName("== Another Thread ==");
        anoThread.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello From the Anonymous Thread");
            }
        }.start();

        Thread myRunnable = new Thread(new MyRunnable()){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello form the Anonymous class's implementation of the runnable thread");
                try {
                    anoThread.join();
                    System.out.println(ANSI_RED + "Another Thread Terminated, So I am running again");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait after all, I was Interrupted: ");

                }
            }
        };

        myRunnable.start();
        System.out.println(ANSI_PURPLE + "Hello again from the main Thread ");


    }
}
