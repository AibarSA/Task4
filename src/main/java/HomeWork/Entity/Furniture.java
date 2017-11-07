package HomeWork.Entity;

public abstract class Furniture {

    String name;
    int furnitureArea;

    public Furniture(String name, int furnitureArea) {
        this.name = name;
        this.furnitureArea = furnitureArea;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", furnitureArea=" + furnitureArea +
                '}';
    }
}
