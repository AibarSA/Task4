package com.epam.testAutomationLab.homeWork.Entity;

public abstract class Furniture {

    String name;
    int furnitureArea;

    public Furniture(String name, int furnitureArea) {
        this.name = name;
        this.furnitureArea = furnitureArea;
    }

    public String getName() {
        return name;
    }

    public int getFurnitureArea() {
        return furnitureArea;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", furnitureArea=" + furnitureArea +
                '}';
    }
}
