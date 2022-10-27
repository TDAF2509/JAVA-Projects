package com.TDAF;

public class Car {
    private String model;
    private int speed;
    private double miles;

    public Car(String model, int speed, double miles) {
        this.model = model;
        this.speed = speed;
        this.miles = miles;
    }

    public void updateSpeed(int speed) {
        speed+=speed;
    }

    public void updateMiles(double miles){
        miles+=miles;
    }
}
