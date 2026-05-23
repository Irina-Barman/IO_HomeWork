package org.example;


import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String FILE_NAME = "pages.txt";
        String FOLDER_NAME = "book";
        String PATH = FOLDER_NAME + File.separator + FILE_NAME;

        File folder = new File(FOLDER_NAME);
        folder.mkdir();

        ReadingAndPrintPages readingPages = new ReadingAndPrintPages();
        readingPages.printPages(PATH);

    }
}
