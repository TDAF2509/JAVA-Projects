package com.TDAF;

public class Sportperson {
    private String name;
    private String sport;
    private int age;

    public Sportperson(String name, String sport) {
        this.name = name;
        this.sport = sport;
        this.age = 0;
    }

    public void updateAge(int Newage) {
        age+=Newage;
    }
}
