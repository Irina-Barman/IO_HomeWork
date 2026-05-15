package org.example;


import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File directories = new File("dir1/dir2/dir3");
        File aFile = new File("dir1/dir2/dir3/aFile.txt");
        File bFile = new File("dir1/dir2/dir3/bFile.txt");
        File cFile = new File("dir1/dir2/dir3/cFile.txt");

        try {
            directories.mkdirs();
            aFile.createNewFile();
            bFile.createNewFile();
            cFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File[] files = directories.listFiles((dir, name) -> name.toLowerCase().charAt(0) == 'a');

        if (files == null || files.length == 0) {
            System.out.println("The list is empty or directory does not exist");
        } else
            for (File f : files) System.out.println("name: " + f.getName() + "\nAbsolute path: " + f.getAbsolutePath());

    }
}
