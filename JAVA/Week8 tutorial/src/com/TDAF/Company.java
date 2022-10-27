package com.TDAF;

import java.util.Arrays;

public class Company {
    private String name;
    private int numberOfEmployees = 0;
    private Employee[] listOfEmployees;

    public Company(String name, int numberOfEmployees, Employee[] listOfEmployees) {
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
        this.listOfEmployees = listOfEmployees;
        increment();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Employee[] getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(Employee[] listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    private void increment(){
        numberOfEmployees++;
        System.out.println(numberOfEmployees);
        listOfEmployees= new Employee[numberOfEmployees];
//        System.out.println(Arrays.toString(listOfEmployees));

    }
}
