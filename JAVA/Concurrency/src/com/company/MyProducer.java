package com.company;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Name: Gideon Nimoh
 * Date: 4/6/21
 * Time: 6:28 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class MyProducer implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;
/*    private ReentrantLock bufferLock;*/

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1","2", "3", "4", "5"};

        for (String num : nums){
            try {
                System.out.println(color + "Adding --- " + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting....");
        try {
            buffer.put("EOF");
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
