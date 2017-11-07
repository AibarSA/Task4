package HomeWork;


import HomeWork.Entity.*;
import HomeWork.Exception.IlluminanceTooMuchException;
import HomeWork.Exception.SpaceUsageTooMuchException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Main {
    static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();


        Building building = new Building("Building1");


        Room firstRoom = new Room("firstRoom",250,3);
        Room secondRoom = new Room("secondRoom",80,2);
        Room thirdRoom = new Room("thirdRoom",350);

        building.addRoom(firstRoom);
        building.addRoom(secondRoom);
        building.addRoom(thirdRoom);

        building.getRoom(firstRoom).addLightBulb(new Lightbulb(150));
        building.getRoom(firstRoom).addLightBulb(new Lightbulb(250));
        building.getRoom(thirdRoom).addLightBulb(new Lightbulb(170));


        building.getRoom(firstRoom).addFurniture(new Divan("Divan", 50));
        building.getRoom(firstRoom).addFurniture(new BilliardTable("BilliardTable", 7));
        building.getRoom(firstRoom).addFurniture(new DiningTable("DiningTable", 15));
        building.getRoom(thirdRoom).addFurniture(new Aquarium("Aquarium", 20));
        building.getRoom(thirdRoom).addFurniture(new Bookcase("Bookcase", 35));


        System.out.println(firstRoom);
        System.out.println(secondRoom);
        System.out.println(thirdRoom);

        try {
            building.describe();
        } catch (IlluminanceTooMuchException e) {
            logger.error("Allowed level of illuminance in the room exceeded, total room illuminance should be less than 4000 lx.");
        } catch (SpaceUsageTooMuchException e) {
            logger.error("Allowed level of usage of room area exceeded, total room space usage should be less than 70%.");
        } catch (IlluminanceNotEnoughException e) {
            logger.error("Not enough illuminance in the room , total room illuminance should be more than 300 lx.");
        }

    }
}
