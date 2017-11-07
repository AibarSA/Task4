package HomeWork;


import HomeWork.Entity.*;
import HomeWork.Exception.IlluminanceTooMuchException;
import HomeWork.Exception.SpaceUsageTooMuchException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Main {
    static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        org.apache.log4j.BasicConfigurator.configure();


        Room firstRoom = new Room();
        firstRoom.setName("firstRoom");
        firstRoom.setRoomArea(250);
        firstRoom.setWindow(3);

        Room secondRoom = new Room();
        secondRoom.setName("secondRoom");
        secondRoom.setRoomArea(80);
        secondRoom.setWindow(2);

        Building building = new Building("Building1");

        building.addRoom(firstRoom);
        building.addRoom(secondRoom);

        building.getRoom(firstRoom).addLightBulb(new Lightbulb(150));
        building.getRoom(secondRoom).addLightBulb(new Lightbulb(250));


        building.getRoom(firstRoom).addFurniture(new Divan("Divan", 50));
        building.getRoom(firstRoom).addFurniture(new BilliardTable("BilliardTable", 7));
        building.getRoom(firstRoom).addFurniture(new DiningTable("DiningTable", 15));
        building.getRoom(secondRoom).addFurniture(new Aquarium("Aquarium", 20));
        building.getRoom(secondRoom).addFurniture(new Bookcase("Bookcase", 35));


        System.out.println(firstRoom);
        System.out.println(secondRoom);









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
