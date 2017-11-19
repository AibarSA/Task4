package com.epam.testAutomationLab.homeWork.Service;

import com.epam.testAutomationLab.homeWork.Entity.Lightbulb;
import com.epam.testAutomationLab.homeWork.Entity.Room;

public class LightBulbService {

    public static int totalLightbulbIllumination(Room room){
        int totalIlluminationOfLightbulbs =0;
        for (Lightbulb lightbulb : room.getLightbulbs()) {
             totalIlluminationOfLightbulbs += lightbulb.getLightbulbIllumination();
        }
        return totalIlluminationOfLightbulbs;
    }

}
