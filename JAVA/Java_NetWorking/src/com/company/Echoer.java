package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Name: Gideon Nimoh
 * Date: 4/13/21
 * Time: 4:32 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Echoer extends Thread{
    private Socket socket;

    public Echoer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            while (true){
                String echoString = input.readLine();
                System.out.println("Received client input: " + echoString);
                if (echoString.equals("exit")){
                    break;
                }
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                writer.println(echoString);
            }

        }catch (IOException e){
            System.out.println("Oops " + e.getMessage());
        }finally {
            try {
                socket.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
