package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Reading {

    public void getReading(String fileName) {
        System.out.println("Your list: ");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
    }
}