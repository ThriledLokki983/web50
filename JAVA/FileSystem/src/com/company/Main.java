package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        try{

            Path file = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path dest = FileSystems.getDefault().getPath("Examples", "file2.txt");
            Files.move(file, dest);


            /*Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "filecopy.txt");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);*/

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
/*
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFIle.txt");
        printFIle(path);

        //Path filePath = FileSystems.getDefault().getPath("files", "SubDirectoryFile.txt");
        Path filePath = Paths.get(".","files", "SubDirectoryFile.txt");
        printFIle(filePath);

        Path outFIle = Paths.get("/Users/ogidi/dev/web50/", "JAVA/", "OutThere.txt");
       // Path outFIle = Paths.get("/Users/ogidi/dev/web50/JAVA/OutThere.txt");
        printFIle(outFIle);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        Path path2 = FileSystems.getDefault().getPath(".", "files", "SubdirectoryFile.txt");
        printFIle(path2);
        System.out.println(path2.normalize().toAbsolutePath());

        Path path3 = FileSystems.getDefault().getPath("ThisisnotThere.txt");
        System.out.println(path3.normalize().toAbsolutePath());

        Path path4 = Paths.get("Users/Test/ING", "abcd", "example.txt");
        System.out.println(path4.normalize().toAbsolutePath());

        filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Exists: " + Files.exists(filePath));

        System.out.println("Exists: " + Files.exists(path4));
*/


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
