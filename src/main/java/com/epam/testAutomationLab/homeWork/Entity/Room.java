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
        res.append(ExeptionService.checkForExceptions(this));
        res.append(RoomService.infoAboutIllumination(this));
        res.append(RoomService.infoAboutRoomArea(this));
        res.append(RoomService.infoAboutFurniture(this));
        return String.valueOf(res);
    }
}
