package com.TDAF;

public class Door {
    private String type;
    private boolean wood;
    private boolean plastic;
    private boolean glass;

    public Door(String type, boolean wood, boolean plastic, boolean glass) {
        this.type = type;
        this.wood = wood;
        this.plastic = plastic;
        this.glass = glass;
    }

    public String getType() {
        return type;
    }

    public boolean isWood() {
        if (wood==true){
            System.out.println("The Door is wooden");
        }
        return wood;
    }

    public boolean isPlastic() {
        if (plastic==true){
            System.out.println("The Door is plastic");
        }
        return plastic;
    }

    public boolean isGlass() {
        if (glass==true){
            System.out.println("The Door is glass");
        }
        return glass;
    }
}
