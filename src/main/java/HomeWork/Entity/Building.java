package HomeWork.Entity;

import HomeWork.Exception.IlluminanceTooMuchException;
import HomeWork.Exception.SpaceUsageTooMuchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private static Logger logger = LoggerFactory.getLogger(Building.class);

    private String BuildingName;
    List<Room> rooms = new ArrayList<Room>();

    public Building(String buildingName) {
        BuildingName = buildingName;
    }


    public void addRoom(Room firstRoom) {
        rooms.add(firstRoom);
    }


    public Room getRoom(Room firstRoom){
        for (int i = 0; i <rooms.size() ; i++) {
            Room r = rooms.get(i);
            if (r.equals(firstRoom)) return r;
        }return null;
    }


    public void describe() throws IlluminanceTooMuchException, SpaceUsageTooMuchException {
        for (int i = 0; i <rooms.size() ; i++) {
            int totalIlluminationOfLightbulbs =0;
            double totalAreaOfFurnitures =0;
            int totalIlluminationOfWindows = rooms.get(i).getWindow()*700;
            double areaOfRoom = rooms.get(i).getRoomArea();
            String furnitureName;




            for (int j = 0; j <rooms.get(i).lightbulbs.size() ; j++) {
                totalIlluminationOfLightbulbs += rooms.get(i).lightbulbs.get(j).getLightbulbIllumination();
            }
            for (int j = 0; j <rooms.get(i).furnitures.size() ; j++) {
                totalAreaOfFurnitures += rooms.get(i).furnitures.get(j).furnitureArea;
            }

            if((totalIlluminationOfLightbulbs + totalIlluminationOfWindows) > 4000){
                throw new IlluminanceTooMuchException();
            }

            if((totalAreaOfFurnitures*100/areaOfRoom) > 70){
                throw new SpaceUsageTooMuchException();
            }




            logger.info('\n'+rooms.get(i).getName());
            logger.info("Illumination = "+ (totalIlluminationOfLightbulbs+ totalIlluminationOfWindows) +"("+ rooms.get(i).getWindow() + " of windows with 700 lx, and total illuminance of lightbulbs is: " + totalIlluminationOfLightbulbs+ " lx)");
            logger.info('\n'+"Room area = " + areaOfRoom + " m^2 (used: "+ totalAreaOfFurnitures + " m^2, available space : "+ (areaOfRoom-totalAreaOfFurnitures)+" m^2, or "+ (100-(totalAreaOfFurnitures*100/areaOfRoom)) +" % )");
            logger.info("Furniture: ");

            if (!rooms.get(i).furnitures.isEmpty()){
                for (int j = 0; j <rooms.get(i).furnitures.size() ; j++) {
                    furnitureName = rooms.get(i).furnitures.get(j).name;
                    logger.info(furnitureName + " (area: " + rooms.get(i).furnitures.get(j).furnitureArea + " m^2)");
                }
            }else{
                logger.info("There is no any furniture.");
            }



        }
    }
}
