package HomeWork;


public class Main {
    public static void main(String[] args) {

        Building building = new Building("Building1");

        Room firstRoom = new Room("firstRoom", 250,3);
        Room secondRoom = new Room("secondRoom", 80,2);
        Room thirdRoom = new Room("thirdRoom", 500,1);

        building.addRoom(firstRoom);
        building.addRoom(secondRoom);
        building.addRoom(thirdRoom);

        building.getRoom(firstRoom).addLightBulb(new Lightbulb(170));
        building.getRoom(firstRoom).addLightBulb(new Lightbulb(250));
        building.getRoom(thirdRoom).addLightBulb(new Lightbulb(370));


        building.getRoom(firstRoom).addFurniture(new Divan("Divan", 20));
        building.getRoom(firstRoom).addFurniture(new BilliardTable("BilliardTable", 7));
        building.getRoom(firstRoom).addFurniture(new DiningTable("DiningTable", 15));
        building.getRoom(thirdRoom).addFurniture(new Aquarium("Aquarium", 20));
        building.getRoom(thirdRoom).addFurniture(new Bookcase("Bookcase", 35));


        try {
            building.describe();
        } catch (IlluminanceTooMuchException e) {
            e.printStackTrace();
        } catch (SpaceUsageTooMuchException e) {
            e.printStackTrace();
        }


    }
}
