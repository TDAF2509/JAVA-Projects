package com.TDAF;

public class AreaCalculator {
    public static void main(String[] args) {
        area(5);
        area(5,4);
    }
    public static double area(double radius) {
        if (radius<0){
            return -1;
        }

        double circlearea=(radius*radius*Math.PI);
        //System.out.println(circlearea);
        return circlearea;
    }

    public static double area(double x,double y) {
        if ((x<0)||(y<0)){
            return -1;
        }
        double rectanglearea=(x*y);
        //System.out.println(rectanglearea);
        return rectanglearea;

    }
}
