package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Утилитарный класс для чтения и вывода содержимого страниц из файла.
 * <p>
 * Файл рассматривается как последовательность страниц фиксированного размера (PAGE_SIZE).
 * Пользователь может запрашивать страницы по номеру от MIN_PAGE до MAX_PAGE.
 * Поддерживаются команды выхода "stop" или "стоп".
 * Параметр (file)- путь к файлу, из которого читаются страницы (должен существовать и быть доступен для чтения)
 * IOException если возникает ошибка ввода-вывода при работе с файлом (например, файл не найден,
 * недостаточно прав, проблема с чтением или позиционированием)
 *
 */

public class ReadingAndPrintPages {
    private static final int PAGE_SIZE = 3000;
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 10;
    private static final String EXIT_COMMAND = "stop";
    private static final String EXIT_COMMAND_RUS = "стоп";

    public void printPages(String pathFile) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter page number (" + MIN_PAGE + "-" + MAX_PAGE + ") or 'stop' to finish:");

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(pathFile, "r")) {
            byte[] buffer = new byte[PAGE_SIZE];

            while (true) {
                System.out.println("Enter pages: ");
                String input = scanner.nextLine();

                if (isExitCommand(input)) {
                    break;
                }

                int pageNumber;
                try {
                    pageNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a number or 'stop'.");
                    continue;
                }
                if (pageNumber < MIN_PAGE || pageNumber > MAX_PAGE) {
                    System.out.println("the number must be between " + MIN_PAGE + " and " + MAX_PAGE);
                    continue;
                }
                long position = (long) (pageNumber - 1) * PAGE_SIZE;

                randomAccessFile.seek(position);
                int bytesRead = randomAccessFile.read(buffer);
                if (bytesRead == -1) {
                    System.out.println("End of file reached, no data to read.");

                } else {
                    String pageContent = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                    System.out.println(pageContent);
                }
            }
        }
    }

    private boolean isExitCommand(String input) {
        return input.equalsIgnoreCase(EXIT_COMMAND) || input.equalsIgnoreCase(EXIT_COMMAND_RUS);
    }
}
