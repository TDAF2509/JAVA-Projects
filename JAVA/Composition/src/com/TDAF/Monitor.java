package com.TDAF;

public class Monitor {
    private String model;
    private String manufacturar;
    private int size;
    private Resolution nativeResolution;

    public Monitor(String model, String manufacturar, int size, Resolution nativeResolution) {
        this.model = model;
        this.manufacturar = manufacturar;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String colour){
        System.out.println("Drawing pixel at "+x+","+y+" in colour "+colour);
    }

    public String getModel() {
        return model;
    }

    public String getManufacturar() {
        return manufacturar;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }
}
