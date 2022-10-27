package com.TDAF;

public class Furniture {
    private String type;
    private String manufactuter;
    private String colour;
    private String material;
    private String texture;
    private int size;

    public Furniture(String type, String manufactuter, String colour, String material, String texture, int size) {
        this.type = type;
        this.manufactuter = manufactuter;
        this.colour = colour;
        this.material = material;
        this.texture = texture;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public String getManufactuter() {
        return manufactuter;
    }

    public String getColour() {
        return colour;
    }

    public String getMaterial() {
        return material;
    }

    public String getTexture() {
        return texture;
    }

    public int getSize() {
        return size;
    }
}
