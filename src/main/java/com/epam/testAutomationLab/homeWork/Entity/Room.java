package com.epam.testAutomationLab.homeWork.Entity;

import com.epam.testAutomationLab.homeWork.Exception.IlluminanceTooMuchException;
import com.epam.testAutomationLab.homeWork.Exception.SpaceUsageTooMuchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Room {
    static Logger logger = LogManager.getLogger(Room.class);

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
        int totalIlluminationOfWindows = window*700;
        double totalAreaOfFurnitures =0;
        int totalIlluminationOfLightbulbs =0;


        for (Lightbulb lightbulb : lightbulbs) {
            totalIlluminationOfLightbulbs += lightbulb.getLightbulbIllumination();
        }
        for (Furniture furniture : furnitures) {
            totalAreaOfFurnitures += furniture.furnitureArea;
        }

        if((totalIlluminationOfLightbulbs + totalIlluminationOfWindows) > 4000){
            try {
                throw new IlluminanceTooMuchException();
            } catch (IlluminanceTooMuchException e) {
                res.append("\nERROR: Allowed level of illuminance in "+name+" exceeded, total room illuminance should be less than 4000 lx.");
                logger.error("Allowed level of illuminance in the room exceeded, total room illuminance should be less than 4000 lx.");
            }
        }

            if((totalIlluminationOfLightbulbs + totalIlluminationOfWindows) < 300){
                try {
                    throw new IlluminanceNotEnoughException();
                } catch (IlluminanceNotEnoughException e) {
                    res.append("\nERROR: Not enough illuminance in "+name+", total room illuminance should be more than 300 lx.");
                    logger.error("\nNot enough illuminance in "+name+", total room illuminance should be more than 300 lx.");
                }
            }

            if((totalAreaOfFurnitures*100/roomArea) > 70){
                try {
                    throw new SpaceUsageTooMuchException();
                } catch (SpaceUsageTooMuchException e) {
                    res.append("\nERROR: In "+name+" allowed level of area usage exceeded, total room space usage should be less than 70%.");
                    logger.error("Allowed level of usage of room area exceeded, total room space usage should be less than 70%.");
                }
            }

        res.append('\n'+name);

        StringBuilder sb = new StringBuilder();

        if (window>0) {
            sb.append("Illumination = " + (totalIlluminationOfLightbulbs + totalIlluminationOfWindows) + "(" + window + " of windows with 700 lx");
        }else{
            sb.append("Illumination = " + (totalIlluminationOfLightbulbs + totalIlluminationOfWindows) + "(" );
        }

        if (window>0 && lightbulbs.size()>0) sb.append(",");

        if (lightbulbs.size()==0){
            sb.append(")");
        }else {
            for (int j = 0; j < lightbulbs.size(); j++) {
                if (j==0) sb.append(" lightBulbs: ");
                sb.append(lightbulbs.get(j).getLightbulbIllumination() + " lx");
                if (j < lightbulbs.size() - 1) sb.append(" and ");
                if (j == lightbulbs.size() - 1) sb.append(")");
            }
        }

        res.append('\n'+String.valueOf(sb));
        res.append("\nRoom area = " + roomArea + " m^2 (used: "+ totalAreaOfFurnitures + " m^2, available space : "+
                  (roomArea-totalAreaOfFurnitures)+" m^2, or "+ new DecimalFormat("##.##").format(100-(totalAreaOfFurnitures*100/roomArea)) +" % )");
        res.append("\nFurniture: ");

        if (!furnitures.isEmpty()){
            for (Furniture furniture : furnitures) {

                res.append('\n'+furniture.name + " (area: " + furniture.furnitureArea + " m^2)");
            }
        }else{
            res.append("\nThere is no any furniture.");
        }
        return String.valueOf(res);
    }


//    @Override
//    public String toString() {
//        return name ;
//    }
}