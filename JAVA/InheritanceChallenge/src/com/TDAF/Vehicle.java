package com.TDAF;

import com.sun.xml.internal.ws.api.pipe.Engine;

public class Vehicle {

    private String name;
    private String size;
    private int currentDirection;
    private int currentVelocity;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;
        this.currentDirection = 0;
        this.currentVelocity = 0;
    }

   public void steer(int direction){
        this.currentDirection += direction;
       System.out.println("Vehicle.steer() called");
   }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public void move(int velocity, int direction){
       currentVelocity = velocity;
       currentDirection = direction;
       System.out.println("Vehicle.move(): Moving at "+currentVelocity+" in direction "+currentDirection);

   }

   public void stop(){
        this.currentVelocity=0;
   }
}
