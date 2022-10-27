package com.TDAF;

public class Bicycle {
    private String makersName;
    private String modelName;
    private int age;
    private Boolean onHire;

    public Bicycle(String makersName, String modelName, int age) {
        this.makersName = makersName;
        this.modelName = modelName;
        this.age = age;
        this.onHire = false;
    }

    public String getMakersName() {
        return makersName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getAge() {
        return age;
    }

    public Boolean getOnHire() {
        return onHire;
    }

    public void setAge(int age) {
        if (age>=this.age){
            this.age = age;
        }
    }

    public void setMakersName(String makersName) {
        this.makersName = makersName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setOnHire(Boolean onHire) {
        this.onHire = onHire;
    }
}
