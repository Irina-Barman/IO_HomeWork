// --- Сервис вывода---
package org.example;

import java.util.List;

public class CatPrinter {
    public void printNames(List<Cat> cats) {
        System.out.println("Cat names from file:");
        cats.forEach(cat -> System.out.println(cat.getName()));
    }
}