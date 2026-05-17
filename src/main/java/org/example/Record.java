package org.example;

import java.io.*;

/**
 * Класс для записи текстовой строки в файл.
 * При возникновении ошибки ввода-вывода выбрасывает непроверяемое исключение RuntimeException.
 */
public class Record {

    /**
     * Записывает переданную текстовую строку в файл с указанным именем.
     * Используется try-with-resources для автоматического закрытия потока.
     *
     * @param text     текст, который необходимо записать в файл
     * @param fileName имя файла (может включать путь), в который будет произведена запись
     */
    public void getRecord(String text, String fileName) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName)) {

            // Преобразуем строку в массив байтов (кодировка по умолчанию — платформенная)
            byte[] buffer = text.getBytes();

            // Записываем все байты из буфера в выходной поток
            // параметры: данные, смещение (0 — с начала), длина (весь массив)
            fos.write(buffer, 0, buffer.length);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}