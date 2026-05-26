package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "cat_list.ser";
        String folderName = "cat";

        List<Cat> cats = createCats();
        saveCatsToFile(cats, folderName, fileName);
        List<Cat> loadedCats = loadCatsFromFile(folderName, fileName);
        printCatNames(loadedCats);
    }

    private static List<Cat> createCats() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik", "Don Sphinx", 7.5));
        cats.add(new Cat("Simon", "Birman", 5.0));
        cats.add(new Cat("Iris", "Burmese", 6.0));
        cats.add(new Cat("Masha", "Siamese", 4.5));
        return cats;
    }

    private static void saveCatsToFile(List<Cat> cats, String folder, String fileName) {
        File dir = new File(folder);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IllegalStateException("Не удалось создать папку: " + folder);
        }
        File file = new File(dir, fileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(cats);
        } catch (IOException e) {
            throw new UncheckedIOException(e); // оборачиваем, чтобы не ломать сигнатуру
        }
    }

    private static List<Cat> loadCatsFromFile(String folder, String fileName) {
        File file = new File(folder, fileName);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?> rawList) {
                return castToCatList(rawList);
            } else {
                throw new IOException("Ожидался List<Cat>, получен " + obj.getClass());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Ошибка чтения файла", e);
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Cat> castToCatList(List<?> rawList) {
        return (List<Cat>) rawList;
    }

    private static void printCatNames(List<Cat> cats) {
        System.out.println("Cat names from file:");
        cats.forEach(cat -> System.out.println(cat.getName()));
    }
}