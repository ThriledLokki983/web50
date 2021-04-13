package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.print("Enter a message: ");
                echoString = scanner.nextLine();
                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                socket.send(packet);
                /* You don't usually do this in real world application */
                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                socket.receive(packet);
                System.out.println("Text Received: " + new String(buffer2, 0, packet.getLength()));

            }while (!echoString.equals("exit"));

        }catch (SocketTimeoutException e){
            System.out.println("Socket timed out " + e.getMessage());
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
