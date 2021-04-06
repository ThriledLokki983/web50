package com.company;

import java.util.List;

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

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true){
            if (buffer.isEmpty()){
                continue;
            }
            if (buffer.get(0).equals(EOF)){
                System.out.println(color + "Exiting");
                break;
            }else{
                System.out.println(color + "Removed " + buffer.remove(0));
            }
        }
    }
}
