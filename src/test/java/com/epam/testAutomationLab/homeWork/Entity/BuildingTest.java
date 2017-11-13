package com.epam.testAutomationLab.homeWork.Entity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuildingTest {




    @Test
    public void addRoomTest(){
        Building building = new Building("BuildingTest");
        int before = building.rooms.size();

        building.addRoom(new Room("firstRoom",250,3));
        int result = building.rooms.size();
        Assert.assertEquals(result,before+1);

    }
    @Test
    public void getRoomTest(){
        Building building = new Building("BuildingTest");
        building.addRoom(new Room("firstRoom",250,3));

        Room firstRoom = building.getRoom("firstRoom");
        String result = firstRoom.getName();
        Assert.assertEquals(result, "firstRoom");

    }
}
