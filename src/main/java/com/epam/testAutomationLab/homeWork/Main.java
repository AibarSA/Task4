package com.epam.testAutomationLab.homeWork;

import com.epam.testAutomationLab.homeWork.Entity.*;
import com.epam.testAutomationLab.homeWork.Exception.IlluminanceTooMuchException;
import com.epam.testAutomationLab.homeWork.Exception.SpaceUsageTooMuchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


        Building building = new Building("Building1");

        building.addRoom(new Room("firstRoom",250,3));
        building.addRoom(new Room("secondRoom",80,2));
        building.addRoom(new Room("thirdRoom",350));

        building.getRoom("firstRoom").addLightBulb(new Lightbulb(150));
        building.getRoom("firstRoom").addLightBulb(new Lightbulb(250));
        building.getRoom("thirdRoom").addLightBulb(new Lightbulb(150));


        building.getRoom("firstRoom").addFurniture(new Divan("Divan", 50));
        building.getRoom("firstRoom").addFurniture(new BilliardTable("BilliardTable", 7));
        building.getRoom("firstRoom").addFurniture(new DiningTable("DiningTable", 15));
        building.getRoom("thirdRoom").addFurniture(new Aquarium("Aquarium", 5020));
        building.getRoom("thirdRoom").addFurniture(new Bookcase("Bookcase", 35));



        building.describe();


/*
        try {
            building.describe();
        } catch (IlluminanceTooMuchException e) {
            logger.error("Allowed level of illuminance in the room exceeded, total room illuminance should be less than 4000 lx.");
        } catch (SpaceUsageTooMuchException e) {
            logger.error("Allowed level of usage of room area exceeded, total room space usage should be less than 70%.");
        } catch (IlluminanceNotEnoughException e) {
            logger.error("Not enough illuminance in the room , total room illuminance should be more than 300 lx.");
        }

*/


    }
}