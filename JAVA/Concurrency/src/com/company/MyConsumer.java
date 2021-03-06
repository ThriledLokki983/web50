package com.company;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;


/**
 * Name: Gideon Nimoh
 * Date: 4/6/21
 * Time: 6:33 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class MyConsumer implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;
   /* private ReentrantLock bufferLock;*/

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color/*, ReentrantLock lock*/) {
        this.buffer = buffer;
        this.color = color;
        /*this.bufferLock = lock;*/
    }

    @Override
    public void run() {
        while (true){
            synchronized (buffer){
                try {
                    if (buffer.isEmpty()){
                        continue;
                    }
                    if (buffer.peek().equals(EOF)){
                        System.out.println(color + "Exiting");
                        break;
                    }else{
                        System.out.println(color + "Removed " + buffer.take());
                    }
                }catch (InterruptedException e){

                }
            }
        }
    }
}
