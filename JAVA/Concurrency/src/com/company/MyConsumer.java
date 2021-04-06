package com.company;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;


/**
 * Name: Gideon Nimoh
 * Date: 4/6/21
 * Time: 6:33 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock lock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = lock;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true){
                if (bufferLock.tryLock()){
                    try {
                        if (buffer.isEmpty()){
                            continue;
                        }
                        System.out.println(color + "The counter = " + counter);
                        counter = 0;
                        if (buffer.get(0).equals(EOF)){
                            System.out.println(color + "Exiting");
                            break;
                        }else{
                            System.out.println(color + "Removed " + buffer.remove(0));
                        }
                    }finally {
                        bufferLock.unlock();
                    }
                }else {
                    counter++;
                }
        }
    }
}
