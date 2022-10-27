package com.TDAF;

public class Circle {
    private int radius;
    private static final double PI = Math.PI;
    private static int numberOfCircles = 0;
    private static double totalSurface = 0;

    public Circle(int radius) {
        this.radius = radius;
        increment();

    }

    public Circle() {
        this.radius = 1;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius<0){
            System.out.println("the radius must be positive, your value will be made positive");
            radius*=-1;
        }
        this.radius = radius;
    }

    public static int getNumberOfCircles() {
        return numberOfCircles;
    }

    public static void setNumberOfCircles(int numberOfCircles) {
        Circle.numberOfCircles = numberOfCircles;
    }

    public static double getTotalSurface() {
        return totalSurface;
    }

    public static void setTotalSurface(double totalSurface) {
        Circle.totalSurface = totalSurface;
    }

    private double increment(){
        numberOfCircles++;
        return totalSurface+=surface();
    }

    private double surface(){
        double surface = PI*(radius*radius);
        return surface;
    }


}
