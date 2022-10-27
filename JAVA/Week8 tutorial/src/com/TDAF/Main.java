package com.TDAF;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Circle circle1 = new Circle(1);
        circle1.setRadius(1);
        Circle circle2 = new Circle(5);
        circle2.setRadius(5);
        Circle circle3 = new Circle(8);
        circle3.setRadius(8);
        System.out.println("Total surface area = "+Circle.getTotalSurface());


        Job job = new Job("manager",3000);
        Company company = new Company("myCompany",0,new Employee[]{});
        Employee employee = new Employee("Tayo",job,company);

        employee.addEmployee();
        System.out.println(Arrays.toString(employee.getCompany().getListOfEmployees()));


    }
}
