package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFIle.txt");
        printFIle(path);

        Path filePath = FileSystems.getDefault().getPath("files", "SubDirectoryFile.txt");
        printFIle(filePath);

        Path outFIle = Paths.get("/Users/ogidi/dev/web50/JAVA/OutThere.txt");
        printFIle(outFIle);
    }


    private static void printFIle(Path path){
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
