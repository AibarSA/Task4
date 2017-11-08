package HomeWork.Entity;


import java.util.ArrayList;
import java.util.List;

public class Building {

   // static Logger logger =LogManager.getLogger(Building.class);

   // private String buildingName;
    List<Room> rooms = new ArrayList<Room>();


    private static Building inctanse = new Building();
    private Building() {
    }

    public static Building getInctanse() {
        return inctanse;
    }


    public void addRoom(Room room) {
        rooms.add(room);
    }


    public Room getRoom(String name){
        Room res = null;
        for (int i = 0; i <rooms.size() ; i++) {
            Room room = rooms.get(i);
            if (room.getName().equals(name)) res = room;
        }return res;
    }



    public void describe(){
    System.out.println(rooms);
    }




    

    @Override
    public String toString() {
        return "Building{" +
                "rooms=" + rooms +
                '}';
    }

/*
    public void describe() throws IlluminanceTooMuchException, SpaceUsageTooMuchException, IlluminanceNotEnoughException {
            logger.info(buildingName);
        for (int i = 0; i <rooms.size() ; i++) {
            String roomName = rooms.get(i).getName();
            double totalAreaOfFurnitures =0;
            int totalIlluminationOfLightbulbs =0;
            int totalIlluminationOfWindows = rooms.get(i).getWindow()*700;
            double areaOfRoom = rooms.get(i).getRoomArea();
            String furnitureName;




            for (int j = 0; j <rooms.get(i).lightbulbs.size() ; j++) {
                totalIlluminationOfLightbulbs += rooms.get(i).lightbulbs.get(j).getLightbulbIllumination();
            }
            for (int j = 0; j <rooms.get(i).furnitures.size() ; j++) {
                totalAreaOfFurnitures += rooms.get(i).furnitures.get(j).furnitureArea;
            }

            if((totalIlluminationOfLightbulbs + totalIlluminationOfWindows) > 4000){
                throw new IlluminanceTooMuchException();
            }

            if((totalIlluminationOfLightbulbs + totalIlluminationOfWindows) < 300){
                throw new IlluminanceNotEnoughException();
            }

            if((totalAreaOfFurnitures*100/areaOfRoom) > 70){
                throw new SpaceUsageTooMuchException();
            }





            logger.info(roomName);

            StringBuilder sb = new StringBuilder();
            sb.append("Illumination = "+ (totalIlluminationOfLightbulbs+ totalIlluminationOfWindows) +"("+ rooms.get(i).getWindow() + " of windows with 700 lx");

            if (rooms.get(i).lightbulbs.size()==0){
                sb.append(")");
            }else {
                for (int j = 0; j < rooms.get(i).lightbulbs.size(); j++) {
                    if (j==0) sb.append(", lightBulbs: ");
                    sb.append(rooms.get(i).lightbulbs.get(j).getLightbulbIllumination() + " lx");
                    if (j < rooms.get(i).lightbulbs.size() - 1) sb.append(" and ");
                    if (j == rooms.get(i).lightbulbs.size() - 1) sb.append(")");
                }
            }

            logger.info(String.valueOf(sb));
            logger.info("Room area = " + areaOfRoom + " m^2 (used: "+ totalAreaOfFurnitures + " m^2, available space : "+ (areaOfRoom-totalAreaOfFurnitures)+" m^2, or "+ (100-(totalAreaOfFurnitures*100/areaOfRoom)) +" % )");
            logger.info("Furniture: ");

            if (!rooms.get(i).furnitures.isEmpty()){
                for (int j = 0; j <rooms.get(i).furnitures.size() ; j++) {
                    furnitureName = rooms.get(i).furnitures.get(j).name;
                    logger.info(furnitureName + " (area: " + rooms.get(i).furnitures.get(j).furnitureArea + " m^2)");
                }
            }else{
                logger.info("There is no any furniture.");
            }



        }
    }

    */
}
