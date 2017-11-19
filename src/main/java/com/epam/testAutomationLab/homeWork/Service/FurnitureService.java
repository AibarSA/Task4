package com.epam.testAutomationLab.homeWork.Service;

import com.epam.testAutomationLab.homeWork.Entity.Furniture;
import com.epam.testAutomationLab.homeWork.Entity.Room;

public class FurnitureService {

    public static double totalFurnitureArea(Room room){
            double totalAreaOfFurnitures =0;
            for (Furniture furniture : room.getFurnitures()) {
                totalAreaOfFurnitures += furniture.getFurnitureArea();
            }

            return totalAreaOfFurnitures;
        }




}

