package com.epam.testAutomationLab.homeWork.Service;


import com.epam.testAutomationLab.homeWork.Entity.Room;
import com.epam.testAutomationLab.homeWork.Exception.IlluminanceNotEnoughException;
import com.epam.testAutomationLab.homeWork.Exception.IlluminanceTooMuchException;
import com.epam.testAutomationLab.homeWork.Exception.SpaceUsageTooMuchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public  class ExeptionService {

    static Logger logger = LogManager.getLogger(ExeptionService.class);

    public static String checkForExceptions(Room room){

        StringBuilder sb = new StringBuilder();



        if((RoomService.totalRoomIllumination(room)) > 4000){
            try {
                throw new IlluminanceTooMuchException();
            } catch (IlluminanceTooMuchException e) {
                sb.append("\nERROR: Allowed level of illuminance in the room exceeded, total room illuminance should be less than 4000 lx.");
                logger.error("Allowed level of illuminance in the room exceeded, total room illuminance should be less than 4000 lx.");
            }
        }



        if((RoomService.totalRoomIllumination(room)) < 300){
            try {
                throw new IlluminanceNotEnoughException();
            } catch (IlluminanceNotEnoughException e) {
                sb.append("\nERROR: Not enough illuminance in room, total room illuminance should be more than 300 lx.");
                logger.error("\nNot enough illuminance in room, total room illuminance should be more than 300 lx.");
            }
        }



        if((RoomService.usedSpaceOfRoomInPercent(room)) > 70){
            try {
                throw new SpaceUsageTooMuchException();
            } catch (SpaceUsageTooMuchException e) {
                sb.append("\nERROR: Allowed level of usage of room area exceeded, total room space usage should be less than 70%.");
                logger.error("Allowed level of usage of room area exceeded, total room space usage should be less than 70%.");
            }
        }


        return String.valueOf(sb);
    }
}
