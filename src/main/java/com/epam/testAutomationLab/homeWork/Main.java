package com.epam.testAutomationLab.homeWork;

import com.epam.testAutomationLab.homeWork.Entity.*;
import com.epam.testAutomationLab.homeWork.Exception.IlluminanceTooMuchException;
import com.epam.testAutomationLab.homeWork.Exception.SpaceUsageTooMuchException;
import com.epam.testAutomationLab.homeWork.Service.LightBulbService;
import com.epam.testAutomationLab.homeWork.Service.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    public static void main(String[] args) {


        Building building = new Building("Building1");

        building.addRoom(new Room("firstRoom",250,3));
        building.addRoom(new Room("secondRoom",80,2));
        building.addRoom(new Room("thirdRoom",350));

        building.getRoom("firstRoom").addLightBulb(new Lightbulb(150));
        building.getRoom("firstRoom").addLightBulb(new Lightbulb(250));
        building.getRoom("thirdRoom").addLightBulb(new Lightbulb(150));


        building.getRoom("firstRoom").addFurniture(new Divan("Divan", 20));
        building.getRoom("firstRoom").addFurniture(new BilliardTable("BilliardTable", 7));
        building.getRoom("firstRoom").addFurniture(new DiningTable("DiningTable", 15));
        building.getRoom("thirdRoom").addFurniture(new Aquarium("Aquarium", 20));
        building.getRoom("thirdRoom").addFurniture(new Bookcase("Bookcase", 35));


        building.describe();

    }
}
