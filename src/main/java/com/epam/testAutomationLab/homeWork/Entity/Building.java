package com.epam.testAutomationLab.homeWork.Entity;


import com.epam.testAutomationLab.homeWork.Exception.IlluminanceTooMuchException;
import com.epam.testAutomationLab.homeWork.Exception.SpaceUsageTooMuchException;
import com.epam.testAutomationLab.homeWork.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Building {

   static Logger logger = LogManager.getLogger(Main.class);

    private String name;
    List<Room> rooms = new ArrayList<Room>();


    public Building(String name) {
        this.name = name;
    }

    public void addRoom(Room room) {
        logger.debug("adding "+ room+" to rooms list");
        rooms.add(room);
    }


    public Room getRoom(String name){
        logger.debug("came parametre "+ name);
        Room res = null;

        for (Room room : rooms) {
            if (room.getName().equals(name)) res = room;
        }
        logger.debug("return "+ res);
        return res;
    }

    public void setName(String name) {
        this.name = name;
    }

/*
    public void describe(){
        System.out.println(this);
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
*/


    public void describe() throws IlluminanceTooMuchException, SpaceUsageTooMuchException, IlluminanceNotEnoughException {
        logger.info(this);

        for (Room room : rooms) {
            int totalIlluminationOfWindows = room.getWindow()*700;
            double totalAreaOfFurnitures =0;
            int totalIlluminationOfLightbulbs =0;


            for (Lightbulb lightbulb : room.lightbulbs) {
                totalIlluminationOfLightbulbs += lightbulb.getLightbulbIllumination();
            }
            for (Furniture furniture : room.furnitures) {
                totalAreaOfFurnitures += furniture.furnitureArea;
            }

            if((totalIlluminationOfLightbulbs + totalIlluminationOfWindows) > 4000){
                throw new IlluminanceTooMuchException();
            }

            if((totalIlluminationOfLightbulbs + totalIlluminationOfWindows) < 300){
                throw new IlluminanceNotEnoughException();
            }

            if((totalAreaOfFurnitures*100/room.getRoomArea()) > 70){
                throw new SpaceUsageTooMuchException();
            }


            logger.info(room.getName());

            StringBuilder sb = new StringBuilder();
            if (room.getWindow()>0) {
                sb.append("Illumination = " + (totalIlluminationOfLightbulbs + totalIlluminationOfWindows) +
                         "(" + room.getWindow() + " of windows with 700 lx");
            }else{
                sb.append("Illumination = " + (totalIlluminationOfLightbulbs + totalIlluminationOfWindows) + "(" );
            }

            if (room.getWindow()>0 && room.lightbulbs.size()>0) sb.append(",");

            if (room.lightbulbs.size()==0){
                sb.append(")");
            }else {
                for (int j = 0; j < room.lightbulbs.size(); j++) {
                    if (j==0) sb.append("lightBulbs: ");
                    sb.append(room.lightbulbs.get(j).getLightbulbIllumination() + " lx");
                    if (j < room.lightbulbs.size() - 1) sb.append(" and ");
                    if (j == room.lightbulbs.size() - 1) sb.append(")");
                }
            }

            logger.info(String.valueOf(sb));
            logger.info("Room area = " + room.getRoomArea() + " m^2 (used: "+ totalAreaOfFurnitures + " m^2, available space : "+
                       (room.getRoomArea()-totalAreaOfFurnitures)+" m^2, or "+
                        new DecimalFormat("##.##").format(100-(totalAreaOfFurnitures*100/room.getRoomArea())) +" % )");
            logger.info("Furniture: ");

            if (!room.furnitures.isEmpty()){
                for (Furniture furniture : room.furnitures) {

                    logger.info(furniture.name + " (area: " + furniture.furnitureArea + " m^2)");
                }
            }else{
                logger.info("There is no any furniture.");
            }
        }
    }



    @Override
    public String toString() {
        return name;
    }

}
