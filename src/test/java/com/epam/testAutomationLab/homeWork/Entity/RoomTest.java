package com.epam.testAutomationLab.homeWork.Entity;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RoomTest {

    @Test
    public void addLightBulbTest(){
        Room room = new Room("firstRoom",250,3);
        int before = room.lightbulbs.size();
        room.addLightBulb(new Lightbulb(100));

           int result = room.lightbulbs.size();

        Assert.assertEquals(result,before+1);

    }
}
