package org.example;

import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private String breed;
    private double weight;
    private static final long serialVersionUID = 1L;

    public Cat(String name, String breed, double weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                '}';
    }
}
