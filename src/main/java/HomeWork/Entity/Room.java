package HomeWork.Entity;

import HomeWork.Entity.Furniture;
import HomeWork.Entity.Lightbulb;
import HomeWork.Exception.IlluminanceTooMuchException;
import HomeWork.Exception.SpaceUsageTooMuchException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private int roomArea;
    private int window ;
    List<Lightbulb> lightbulbs = new ArrayList<Lightbulb>();
    List<Furniture> furnitures = new ArrayList<Furniture>();
    Building building = Building.getInctanse();

    public Room(String name, int roomArea, int window) {
        this.name = name;
        this.roomArea = roomArea;
        this.window = window;
    }

    public Room(String name, int roomArea) {
        this.name = name;
        this.roomArea = roomArea;

    }

    public Room() {

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




    public void addLightBulb(Lightbulb firstLightBulb) {

        lightbulbs.add(firstLightBulb);
    }

    public void addFurniture(Furniture divan) {
        furnitures.add(divan);
    }

    StringBuilder res = new StringBuilder();

    @Override
    public String toString() {

        double totalAreaOfFurnitures =0;
        int totalIlluminationOfLightbulbs =0;
        int totalIlluminationOfWindows = window*700;
        String furnitureName;


        for (int j = 0; j <lightbulbs.size() ; j++) {
            totalIlluminationOfLightbulbs += lightbulbs.get(j).getLightbulbIllumination();
        }
        for (int j = 0; j <furnitures.size() ; j++) {
            totalAreaOfFurnitures += furnitures.get(j).furnitureArea;
        }



        res.append('\n'+name);

        StringBuilder sb = new StringBuilder();
        sb.append("Illumination = "+ (totalIlluminationOfLightbulbs+ totalIlluminationOfWindows) +"("+ window + " of windows with 700 lx");

        if (lightbulbs.size()==0){
            sb.append(")");
        }else {
            for (int j = 0; j < lightbulbs.size(); j++) {
                if (j==0) sb.append(", lightBulbs: ");
                sb.append(lightbulbs.get(j).getLightbulbIllumination() + " lx");
                if (j < lightbulbs.size() - 1) sb.append(" and ");
                if (j == lightbulbs.size() - 1) sb.append(")");
            }
        }

        res.append('\n'+String.valueOf(sb));
        res.append("\nRoom area = " + roomArea + " m^2 (used: "+ totalAreaOfFurnitures + " m^2, available space : "+ (roomArea-totalAreaOfFurnitures)+" m^2, or "+ new DecimalFormat("##.##").format(100-(totalAreaOfFurnitures*100/roomArea)) +" % )");
        res.append("\nFurniture: ");

        if (!furnitures.isEmpty()){
            for (int j = 0; j <furnitures.size() ; j++) {
                furnitureName = furnitures.get(j).name;
                res.append('\n'+furnitureName + " (area: " + furnitures.get(j).furnitureArea + " m^2)");
            }
        }else{
            res.append("\nThere is no any furniture.");
        }
        return String.valueOf(res);
    }
}
