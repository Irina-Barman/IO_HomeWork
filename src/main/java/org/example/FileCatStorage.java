// --- Файловая реализация ---
package org.example;

import java.io.*;
import java.util.List;

public class FileCatStorage implements CatStorage {
    private final File file;

    public FileCatStorage(String folderPath, String fileName) {
        File dir = new File(folderPath);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IllegalStateException("Не удалось создать папку: " + folderPath);
        }
        this.file = new File(dir, fileName);
    }

    @Override
    public void save(List<Cat> cats) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(cats);
        } catch (IOException e) {
            throw new UncheckedIOException("Ошибка сохранения котов", e);
        }
    }

    @Override
    public List<Cat> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?> rawList) {
                return castToCatList(rawList);
            }
            throw new IOException("Ожидался List<Cat>, получен " + obj.getClass());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Ошибка загрузки котов", e);
        }
    }

    @SuppressWarnings("unchecked")
    private List<Cat> castToCatList(List<?> rawList) {
        return (List<Cat>) rawList;
    }
}