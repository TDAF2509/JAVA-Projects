package com.TDAF;

public class Floor {
    private boolean carpet;
    private boolean wood;
    private boolean tile;
    private int size;
    private Design design;

    public Floor(boolean carpet, boolean wood, boolean tile, int size, Design design) {
        this.carpet = carpet;
        this.wood = wood;
        this.tile = tile;
        this.size = size;
        this.design = design;
    }

    public boolean isCarpet() {
        if (carpet==true){
            System.out.println("The floor is carpeted");
        }
        return carpet;
    }

    public boolean isWood() {
        if (wood==true){
            System.out.println("The floor is wooden");
        }
        return wood;
    }

    public boolean isTile() {
        if (tile==true){
            System.out.println("The floor is tiled");
        }
        return tile;
    }

    public int getSize() {
        System.out.println("The floor is size "+size);
        return size;
    }

    public Design getDesign() {
        return design;
    }
}
