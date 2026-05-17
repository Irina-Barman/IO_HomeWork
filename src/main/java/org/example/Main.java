package org.example;


import java.io.File;

public class Main {
    public static void main(String[] args) {
        String TEXT = "Костя Петя Маша Аня Вера Антон Марина Андрей Ирина ася Миша";
        String FILE_NAME = "names.txt";
        String FOLDER_NAME = "name_list";
        String PATH = FOLDER_NAME + File.separator + FILE_NAME;

        File folder = new File(FOLDER_NAME);
        folder.mkdir();

        Reading reading = new Reading();
        Record record = new Record();
        record.getRecord(TEXT,PATH);
        reading.getReading(PATH);

    }
}
