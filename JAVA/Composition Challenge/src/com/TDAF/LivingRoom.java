package com.TDAF;

public class LivingRoom {
    private Door theDoor;
    private Windows theWindows;
    private Floor theFloor;
    private Walls theWalls;
    private Furniture theFurniture;
    private TV theTv;

    public LivingRoom(Door theDoor, Windows theWindows, Floor theFloor, Walls theWalls, Furniture theFurniture, TV theTv) {
        this.theDoor = theDoor;
        this.theWindows = theWindows;
        this.theFloor = theFloor;
        this.theWalls = theWalls;
        this.theFurniture = theFurniture;
        this.theTv = theTv;
    }

    public void doorDescription(){
        System.out.println("The Door is a "+theDoor.getType()+" Door");
        theDoor.isWood();
        theDoor.isGlass();
        theDoor.isPlastic();
    }

    public void wallDescription(){
        theWalls.isPaint();
        theWalls.isWallpaper();
        theWalls.isObjects();
        theWalls.getPictures();
    }

    public void windowsDescription(){
        System.out.println("The window is "+theWindows.getType());
    }

    public void furnitureDescription(){
        theFurniture.getType();
        theFurniture.getManufactuter();
        theFurniture.getSize();
        theFurniture.getColour();
        theFurniture.getMaterial();
        theFurniture.getTexture();

    }

    public void tvDescription(){
        System.out.println("The Tv is a "+theTv.getSize()+" inch "+
                theTv.getName()+ " with a "+theTv.getBox()+" box");
    }

    public void floorDescription(){
        theFloor.getDesign();
        theFloor.getSize();
        theFloor.isWood();
        theFloor.isTile();
        theFloor.isCarpet();
    }


}
