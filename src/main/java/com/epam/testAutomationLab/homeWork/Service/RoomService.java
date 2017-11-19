package com.epam.testAutomationLab.homeWork.Service;

import com.epam.testAutomationLab.homeWork.Entity.Furniture;
import com.epam.testAutomationLab.homeWork.Entity.Room;

import java.text.DecimalFormat;

import static com.epam.testAutomationLab.homeWork.Service.FurnitureService.totalFurnitureArea;

public class RoomService {


    public static int totalRoomIllumination(Room room){
        int totalIlluminationOfWindows = room.getWindow()*700;
        return totalIlluminationOfWindows + LightBulbService.totalLightbulbIllumination(room);
    }



    public static double availableSpaceOfRoom(Room room){
        return room.getRoomArea()- totalFurnitureArea(room);
    }



    public static double usedSpaceOfRoomInPercent(Room room){
        return FurnitureService.totalFurnitureArea(room)*100/room.getRoomArea();
    }




    public static double availableSpaceOfRoomInPercent(Room room){
        return 100-(usedSpaceOfRoomInPercent(room));
    }





    public static double usedSpaceOfRoom(Room room){
        return FurnitureService.totalFurnitureArea(room);
    }



    public static String infoAboutIllumination(Room room){
        StringBuilder sb = new StringBuilder();
        sb.append('\n'+room.getName());

        if (room.getWindow()>0) {
            sb.append("\nIllumination = " + totalRoomIllumination(room) + "(" + room.getWindow() + " of windows with 700 lx");
        }else{
            sb.append("\nIllumination = " + totalRoomIllumination(room) + "(" );
        }

        if (room.getWindow()>0 && room.getLightbulbs().size()>0) sb.append(",");

        if (room.getLightbulbs().size()==0){
            sb.append(")");
        }else {
            for (int j = 0; j < room.getLightbulbs().size(); j++) {
                if (j==0) sb.append(" lightBulbs: ");
                sb.append(room.getLightbulbs().get(j).getLightbulbIllumination() + " lx");
                if (j < room.getLightbulbs().size() - 1) sb.append(" and ");
                if (j == room.getLightbulbs().size() - 1) sb.append(")");
            }
        }
        return (String.valueOf(sb));
    }




    public static String infoAboutRoomArea(Room room){
        StringBuilder sb = new StringBuilder();
        sb.append("\nRoom area = " + room.getRoomArea() + " m^2 (used: "+
                usedSpaceOfRoom(room) + " m^2, available space : "+
                availableSpaceOfRoom(room)+" m^2, or "+
                new DecimalFormat("##.##").format(availableSpaceOfRoomInPercent(room)) +" % )");
        return (String.valueOf(sb));
    }





    public static String infoAboutFurniture(Room room){
        StringBuilder sb = new StringBuilder();
        sb.append("\nFurniture: ");

        if (!room.getFurnitures().isEmpty()){
            for (Furniture furniture : room.getFurnitures()) {
                sb.append('\n'+furniture.getName() + " (area: " + furniture.getFurnitureArea() + " m^2)");
            }
        }else{
            sb.append("\nThere is no any furniture.");
        }
        return (String.valueOf(sb));
    }
}
