package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Record {
    private static final String EXIT_COMMAND = "exit";
    private static final String EXIT_COMMAND_RUS = "выход";

    public void getRecord(String fileName) {

        try (Scanner scanner = new Scanner(System.in);
             FileOutputStream fileOutput = new FileOutputStream(fileName, true);
             BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput)) {
            System.out.println("Enter a name or 'exit' to complete the input: ");

            while (true) {
                System.out.println("Name: ");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase(EXIT_COMMAND) || name.equalsIgnoreCase(EXIT_COMMAND_RUS) ) {
                    System.out.println("Recording finished");
                    break;
                }

                String recordLine = name + System.lineSeparator();

                byte[] buffer = recordLine.getBytes(StandardCharsets.UTF_8);
                bufferedOutput.write(buffer, 0, buffer.length);
            }
            bufferedOutput.flush();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            throw new RuntimeException("Failed to record names to " + fileName, e);
        }
    }
}

