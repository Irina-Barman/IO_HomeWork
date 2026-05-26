package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik", "Don Sphinx", 7.5));
        cats.add(new Cat("Simon", "Birman", 5.0));
        cats.add(new Cat("Iris", "Burmese", 6.0));
        cats.add(new Cat("Masha", "Siamese", 4.5));

        CatStorage storage = new FileCatStorage("cat", "cat_list.ser");

        storage.save(cats);
        List<Cat> loadedCats = storage.load();

        CatPrinter printer = new CatPrinter();
        printer.printNames(loadedCats);
    }
}