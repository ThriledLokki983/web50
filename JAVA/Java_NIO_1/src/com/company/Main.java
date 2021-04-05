package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            outputByte[0] = 'a';
            outputByte[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if (buffer.hasArray()){
                System.out.println("byte buffer = " + new String(buffer.array()));
            }
            //System.out.println("Output Bytes: " + new String(outputByte));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());

/*            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
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
*/
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
