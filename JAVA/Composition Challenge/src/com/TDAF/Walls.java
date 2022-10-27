package com.TDAF;

public class Walls {
    private boolean paint;
    private boolean wallpaper;
    private boolean objects;
    private String pictures;


    public Walls(boolean paint, boolean wallpaper, boolean objects, String pictures) {
        this.paint = paint;
        this.wallpaper = wallpaper;
        this.objects = objects;
        this.pictures = pictures;
    }


    public boolean isPaint() {
        if (paint==true){
            System.out.println("The wall is painted");
        }
        return paint;
    }

    public boolean isWallpaper() {
        if (wallpaper==true){
            System.out.println("The wall has wallpaper");
        }
        return wallpaper;
    }

    public boolean isObjects() {
        if (objects==true){
            System.out.println("The wall has objects on it");
        }
        return objects;
    }

    public String getPictures() {
        System.out.println("There is a picture of a "+pictures);
        return pictures;
    }
}
