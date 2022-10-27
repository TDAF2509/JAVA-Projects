package com.TDAF;

public class ComboObject {
    private int ID;
    private String Description;


    public ComboObject(String desc, int id){
        this.ID = id;
        this.Description = desc;
    }
    public String getDescription(){return this.Description;}
    public int getID(){return this.ID;}
    @Override
    public String toString() {
        return this.Description;
    }
}
