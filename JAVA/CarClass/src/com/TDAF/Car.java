package com.TDAF;

public class Car {
    private int doors;
    private int wheels;
    private String model;
    private String colour;

    public void setModel(String model) {
        String validModel= model.toLowerCase();
        if (validModel.equals("R8") || validModel.equals("sport")){
            this.model = model;
        }else{
            this.model= "Unknown";
        }
    }

    public String getModel(){
        return this.model;
    }
}
