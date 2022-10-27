package com.TDAF;

public class Main {

    public static void main(String[] args) {
        Design design = new Design("beige","wool","soft",4,false);
        Floor floor = new Floor(true,false,false,7,design);
        Door door = new Door("Hinge",true,false,true);
        Windows windows = new Windows("Double glazed",6,false);
        TV tv = new TV("LG",50,"virgin");
        Walls walls = new Walls(true,true,true,"Boat");
        Furniture furniture = new Furniture("Sofa","Layzee Boy","Beige","Leather","soft",8);
        LivingRoom livingRoom = new LivingRoom(door,windows,floor,walls,furniture,tv);

        livingRoom.furnitureDescription();
        livingRoom.floorDescription();
        livingRoom.doorDescription();
        livingRoom.tvDescription();
        livingRoom.wallDescription();
        livingRoom.windowsDescription();
    }
}
