package com.epam.testAutomationLab.homeWork.Entity;


import com.epam.testAutomationLab.homeWork.Exception.IlluminanceTooMuchException;
import com.epam.testAutomationLab.homeWork.Exception.SpaceUsageTooMuchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Building {

   static Logger logger = LogManager.getLogger(Building.class);

    private String name;
    List<Room> rooms = new ArrayList<Room>();


    public Building(String name) {
        this.name = name;
    }

    public void addRoom(Room room) {
        logger.debug("adding "+ room.getName()+" to rooms list");
        rooms.add(room);
    }


    public Room getRoom(String name){
        logger.debug("came parameter "+ name);
        Room res = null;
        for (Room room : rooms) {
            if (room.getName().equals(name)) res = room;
        }
        logger.debug("return "+ res.getName());
        return res;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void describe(){
        System.out.println(this);
        for (Room room : rooms) {
            System.out.println(room);
        }
    }


    @Override
    public String toString() {
        return name;
    }

}
