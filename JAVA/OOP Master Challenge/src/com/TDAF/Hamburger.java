package com.TDAF;

public class Hamburger {
    private String bread;
    private String meat;
    private String lettuce;
    private String tomato;
    private String cheese;
    private String bacon;
    private double price;
    private String name;



    public Hamburger(String bread, String meat, double price, String name) {
        this.bread = bread;
        this.meat = meat;
        this.price = price;
        this.name = name;
    }

    public String getLettuce() {
        price+=0.5;
        return lettuce;
    }

    public String getTomato() {
        price+=0.5;
        return tomato;
    }

    public String getCheese() {
        price+=0.5;
        return cheese;
    }

    public String getBacon() {
        price+=0.5;
        return bacon;
    }

    public String getBread() {
        return bread;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getMeat() {
        return meat;
    }
}
