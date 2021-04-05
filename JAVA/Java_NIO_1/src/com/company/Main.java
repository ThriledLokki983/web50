package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try{
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                        for (int i = 0; i<10; i++){
                            String currentTIme = "The time is: "+ System.currentTimeMillis();

                            buffer.put(currentTIme.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()){
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try{
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i =0; i<10;i++){
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " +  new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();

            new Thread(reader).start();

        }catch (IOException e){
            e.printStackTrace();
        }
/*        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()){
*//*
            byte[] outputByte = "Hello World!".getBytes();
*//*
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
//
//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputByte2 = "Nice to meet you".getBytes();
//            byteBuffer.put(outputBytes).putInt(245).putInt(-98756).put(outputByte2).putInt(1000);
//            byteBuffer.flip();

            byte[] outputBytes = "Hello World!".getBytes();
            byteBuffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            byteBuffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            byteBuffer.putInt(-978956);
            byte[] outputByte2 = "Nice to meet you".getBytes();
            byteBuffer.put(outputByte2);
            long int3Pos = int2Pos + Integer.BYTES + outputByte2.length;
            byteBuffer.putInt(1000);
            byteBuffer.flip();
            binChannel.write(byteBuffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();

            System.out.println("Int3 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();

            System.out.println("Int2 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();

            System.out.println("Int1 = " + readBuffer.getInt());

            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
//            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num Transferred: " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();*//*    byte[] outputString = "Hello, World!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));
*//*        ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("InputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputByte2.length];
            readBuffer.get(inputString2);
            System.out.println("InputString2 = " + new String(inputString2));
            System.out.println("Int3 = " + readBuffer.getInt());
            System.out.println((readBuffer.getLong((int)int1Pos)));
            *//*
        ByteBuffer buffer = ByteBuffer.allocate(outputByte.length);
            buffer.put(outputByte);
            buffer.flip();

            int numBytes = binChannel.write(buffer);
            System.out.println("Number of Bytes written " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("Number of Bytes: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-97835);
            intBuffer.flip(); *//* Always call the flip if you want to reset the position to zero
*//*
            numBytes = binChannel.write(intBuffer);
            System.out.println("Number of Bytes: " + numBytes);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            outputByte[0] = 'a';
            outputByte[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if (buffer.hasArray()){
                System.out.println("byte buffer = " + new String(buffer.array()));
//                System.out.println("byte buffer " + new String(outputByte));
            }
            //System.out.println("Output Bytes: " + new String(outputByte));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());*//*            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            byte[] b = new byte[outputByte.length];
            ra.read(b);
            System.out.println(new String(b));

            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1);
            System.out.println(int2);
*//* FileInputStream file = new FileInputStream("data.txt");
            FileChannel channel = file.getChannel();

            Path path = FileSystems.getDefault().getPath("data.txt");
            Files.write(path, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(path);
            for (String s : lines){
                System.out.println(s);
            }
*//*        }catch (IOException e){
            e.printStackTrace();
        }
    }*/

    }
}
