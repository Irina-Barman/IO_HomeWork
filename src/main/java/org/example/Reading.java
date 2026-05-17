package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Класс для чтения содержимого файла и вывода его в консоль.
 */

public class Reading {

    /**
     * Читает файл с указанным именем, извлекает из него имена,
     *  отбирает те, которые начинаются с буквы 'А' или 'а' (без учёта регистра),
     *   и выводит каждое такое имя на отдельной строке в консоль.
     *   Реализация использует InputStreamReader и буфер фиксированного размера (1024 символа)
     *   для эффективного чтения. После чтения всего файла содержимое разбивается по пробелам,
     *   и полученный массив имён обрабатывается с помощью Stream API.
     *   Reader использует стандартную кодировку StandardCharsets.UTF_8
     */

    public void getReading(String fileName) {
        File file = new File(fileName);
        StringBuilder stringResult = new StringBuilder();

        try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            char[] buffer = new char[1024];
            int countSimbol = reader.read(buffer);

            while (countSimbol > 0) {
                stringResult.append(new String(buffer, 0, countSimbol));
                countSimbol = reader.read(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String strings = stringResult.toString();
        String [] names = strings.split(" ");

        Arrays.stream(names)
                .filter((name) -> name.toLowerCase().startsWith("а"))
                .forEach(System.out::println);
}


}
