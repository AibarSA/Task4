package HomeWork.Entity;

import HomeWork.Entity.Furniture;
import HomeWork.Entity.Lightbulb;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private int roomArea;
    private int window ;
    List<Lightbulb> lightbulbs = new ArrayList<Lightbulb>();
    List<Furniture> furnitures = new ArrayList<Furniture>();



    public String getName() {
        return name;
    }


    public int getRoomArea() {
        return roomArea;
    }


    public int getWindow() {
        return window;
    }


    public Room(String name, int roomArea, int window) {
        this.name = name;
        this.roomArea = roomArea;
        this.window = window;
    }

    public Room(String name, int roomArea) {
        this.name = name;
        this.roomArea = roomArea;
    }

    public void addLightBulb(Lightbulb firstLightBulb) {

        lightbulbs.add(firstLightBulb);
    }

    public void addFurniture(Furniture divan) {
        furnitures.add(divan);
    }
}
