package com.TDAF;

public class Student {
    private String name;
    private int age;
    private Boolean resitter;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.resitter=true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Boolean getResitter() {
        return resitter;
    }

    public void setAge(int age) {
        if (age>=this.age){
            this.age = age;
        }
    }


}
