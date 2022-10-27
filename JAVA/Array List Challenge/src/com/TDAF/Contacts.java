package com.TDAF;

import java.util.ArrayList;

public class Contacts {
    private String name;
    private String number;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public static Contacts newContact(String name, String number){
        return new Contacts(name,number);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
