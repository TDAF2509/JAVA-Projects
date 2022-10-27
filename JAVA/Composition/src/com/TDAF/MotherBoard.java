package com.TDAF;

public class MotherBoard {

    private String model;
    private String manufacturar;
    private int ramSlots;
    private int cardSlots;
    private String bios;

    public MotherBoard(String model, String manufacturar, int ramSlots, int cardSlots, String bios) {
        this.model = model;
        this.manufacturar = manufacturar;
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String progrmName){
        System.out.println("program "+progrmName+" is now loading");
    }

    public String getModel() {
        return model;
    }

    public String getManufacturar() {
        return manufacturar;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public int getCardSlots() {
        return cardSlots;
    }

    public String getBios() {
        return bios;
    }
}
