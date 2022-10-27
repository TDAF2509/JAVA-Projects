package com.TDAF;

public class Design {
    private String colour;
    private String material;
    private String texture;
    private int thickness;
    private boolean decorative;

    public Design(String colour, String material, String texture, int thickness, boolean decorative) {
        this.colour = colour;
        this.material = material;
        this.texture = texture;
        this.thickness = thickness;
        this.decorative = decorative;
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

    public int getThickness() {
        return thickness;
    }

    public boolean isDecorative() {
        return decorative;
    }
}
