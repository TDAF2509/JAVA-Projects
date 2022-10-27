package com.TDAF;

public class TV {
    private String name;
    private int size;
    private String box;

    public TV(String name, int size, String box) {
        this.name = name;
        this.size = size;
        this.box = box;
    }

    public void turnOn(){
        System.out.println("The TV has been turned on");
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getBox() {
        return box;
    }
}
