package HomeWork.Entity;

import HomeWork.Entity.Furniture;
import HomeWork.Entity.Lightbulb;
import HomeWork.Exception.IlluminanceTooMuchException;
import HomeWork.Exception.SpaceUsageTooMuchException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private int roomArea;
    private int window ;
    List<Lightbulb> lightbulbs = new ArrayList<Lightbulb>();
    List<Furniture> furnitures = new ArrayList<Furniture>();
    Building building = Building.getInctanse();

    public Room(String name, int roomArea, int window) {
        this.name = name;
        this.roomArea = roomArea;
        this.window = window;
    }

    public Room(String name, int roomArea) {
        this.name = name;
        this.roomArea = roomArea;

    }

    public Room() {

    }


    public String getName() {
        return name;
    }


    public int getRoomArea() {
        return roomArea;
    }


    public int getWindow() {
        return window;
    }




    public void addLightBulb(Lightbulb firstLightBulb) {

        lightbulbs.add(firstLightBulb);
    }

    public void addFurniture(Furniture divan) {
        furnitures.add(divan);
    }

    StringBuilder sb = new StringBuilder();

    @Override
    public String toString() {
        for (int i = 0; i <building.rooms.size() ; i++) {

             sb.append( "Room{" +
                    "name='" + building.rooms.get(i).getName() + '\'' +
                    ", roomArea=" + building.rooms.get(i).getRoomArea() +
                    ", window=" + building.rooms.get(i).getWindow() +
                    ", lightbulbs=" + building.rooms.get(i).lightbulbs +
                    ", furnitures=" + building.rooms.get(i).furnitures +
                    '}');
        }

        return String.valueOf(sb);
    }
}
