package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        DirectoryStream.Filter<Path> filter = Files::isRegularFile;

       // Path directory = FileSystems.getDefault().getPath("FileTree/Dir2");
        Path directory = FileSystems.getDefault().getPath("FileTree"+ File.separator + "Dir2");

        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)){
                for (Path file : contents){
                    System.out.println(file.getFileName());
                }
        }catch (IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try{
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary File path: " + tempFile.toAbsolutePath());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores){
            System.out.println("Volume name/Drive Letter : " + store);
            System.out.println(store.name());
        }

        System.out.println("=============================");
        Iterable<Path> rootPath = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootPath){
            System.out.println(path);
        }

        System.out.println("================= Walking Tree for Dir2 ===================");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try{
            Files.walkFileTree(dir2Path, new PrintNames());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("================= Copy Dir2 -> Dir4/Dir2Copy ===================");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        // FileTree/Dir4/Dir2Copy
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        File file = new File("/Examples/file.txt");
        Path convertedPath = file.toPath();
        System.out.println("Converted Path: " + convertedPath);
    }
}
