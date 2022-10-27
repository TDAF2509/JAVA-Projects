package com.TDAF;

public class VipCustomer {
    private String name;
    private double creditLimit;
    private String Email;

    //Constructor with 3 parameters with default values
    public VipCustomer(){
        this("Tayo",10000,"Email");
        System.out.println("Empty constructor called");
    }

    //Constructor that passes on 2 values and adds a default for the third parameter
    public VipCustomer(String name, double creditLimit){
        this(name, creditLimit, "Unknown@email.com");
    }

    //Constructor should save all fields
    public VipCustomer(String name, double creditLimit, String Email){
        this.name=name;
        this.creditLimit=creditLimit;
        this.Email=Email;
    }


    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return Email;
    }
}
