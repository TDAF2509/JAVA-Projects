package com.TDAF;

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, boolean engine, int cylinders) {
        this.name = name;
        this.engine = engine;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public String startEngine(){
        return "The engine has started";
    }

    public double accelerate(){
        return 1;
    }

    public String brake(){
        return "The brake has been hit";
    }

    public int topSpeed(){
        return 1;
    }

    public int price(){
        return 1;
    }

    public String getName() {
        System.out.println("Car: "+name);
        return name;
    }

    public boolean isEngine() {
        System.out.println("Engine: "+engine);
        return engine;
    }

    public int getCylinders() {
        System.out.println("Number of cylinders: "+cylinders);
        return cylinders;
    }
}

class BMW extends Car {
    public BMW(){
        super("I8 Coupe",true,3);
    }

    @Override
    public int topSpeed() {
        return 155;
    }

    @Override
    public int price() {
        return 115105;
    }

    @Override
    public double accelerate() {
        return 4.4;
    }
}

class Audi extends Car {
    public Audi(){
        super("R8 Coupe",true,10);
    }

    @Override
    public int topSpeed() {
        return 198;
    }

    @Override
    public int price() {
        return 128295;
    }

    @Override
    public double accelerate() {
        return 3.1;
    }
}

class Lamborghini extends Car {
    public Lamborghini(){
        super("Huracan",true,10);
    }


    @Override
    public int topSpeed() {
        return 201;
    }

    @Override
    public int price() {
        return 206000;
    }

    @Override
    public double accelerate() {
        return 2.9;
    }
}

public class Main {
    public static void main(String[] args) {

        Lamborghini lamborghini = new Lamborghini();
        Audi audi = new Audi();
        BMW bmw = new BMW();

        lamborghini.getName();
        lamborghini.isEngine();
        System.out.println(lamborghini.startEngine());
        System.out.println("Top Speed: "+lamborghini.topSpeed()+"mph");
        System.out.println("Acceleration (0-62mph) : "+lamborghini.accelerate()+" secs");
        System.out.println("Price: £"+lamborghini.price());
        System.out.println(lamborghini.brake());
        System.out.println("\n"+"\n");

        audi.getName();
        audi.isEngine();
        System.out.println(audi.startEngine());
        System.out.println("Top Speed: "+audi.topSpeed()+"mph");
        System.out.println("Acceleration (0-62mph) : "+audi.accelerate()+" secs");
        System.out.println("Price: £"+audi.price());
        System.out.println(audi.brake());
        System.out.println("\n"+"\n");

        bmw.getName();
        bmw.isEngine();
        System.out.println(bmw.startEngine());
        System.out.println("Top Speed: "+bmw.topSpeed()+"mph");
        System.out.println("Acceleration (0-62mph) : "+bmw.accelerate()+" secs");
        System.out.println("Price: £"+bmw.price());
        System.out.println(bmw.brake());
        System.out.println("\n"+"\n");
    }

}