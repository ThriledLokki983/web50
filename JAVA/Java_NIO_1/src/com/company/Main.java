package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()){

            byte[] outputByte = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputByte);
            int numBytes = binChannel.write(buffer);
            System.out.println("Number of Bytes written " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("Number of Bytes: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-97835);
            intBuffer.flip(); /* Always call the flip if you want to reset the position to zero */
            numBytes = binChannel.write(intBuffer);
            System.out.println("Number of Bytes: " + numBytes);

           /* FileInputStream file = new FileInputStream("data.txt");
            FileChannel channel = file.getChannel();
            *//*
            Path path = FileSystems.getDefault().getPath("data.txt");
            Files.write(path, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(path);
            for (String s : lines){
                System.out.println(s);
            }
*/
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
