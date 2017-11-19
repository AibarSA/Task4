package com.epam.testAutomationLab.homeWork.Entity;


import com.epam.testAutomationLab.homeWork.Service.ExeptionService;
import com.epam.testAutomationLab.homeWork.Service.RoomService;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private int roomArea;
    private int window ;
    List<Lightbulb> lightbulbs = new ArrayList<Lightbulb>();
    List<Furniture> furnitures = new ArrayList<Furniture>();


    public Room(String name, int roomArea, int window) {
        this.name = name;
        this.roomArea = roomArea;
        this.window = window;
    }

    public List<Lightbulb> getLightbulbs() {
        return lightbulbs;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public Room(String name, int roomArea) {
        this.name = name;
        this.roomArea = roomArea;

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


    public void addLightBulb(Lightbulb lightbulb) { lightbulbs.add(lightbulb); }

    public void addFurniture(Furniture furniture) { furnitures.add(furniture); }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        return String.valueOf(res.append(ExeptionService.checkForExceptions(this))
                                 .append(RoomService.infoAboutIllumination(this))
                                 .append(RoomService.infoAboutRoomArea(this))
                                 .append(RoomService.infoAboutFurniture(this)));
    }
}
