package com.TDAF;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("");//set to empty
        person.setLastName("");//set to empty
        person.setAge(10);
        System.out.println("fullName= "+ person.getFirstName());
        System.out.println("teen= "+person.isTeen());
        person.setFirstName("Tayo");
        //person.setLastName("Ajibode-Folkes");
        person.setAge(18);
        System.out.println("fullName= "+person.getFullName());
        System.out.println("teen= "+person.isTeen());
        person.setLastName("Ajibode-Folkes");
        System.out.println("fullName= " +person.getFullName());
    }
}
