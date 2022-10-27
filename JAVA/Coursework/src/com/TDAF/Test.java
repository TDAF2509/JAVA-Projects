package com.TDAF;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("Tayo",19);
        Student student2 = new Student("Laura",18);
        Student student3 = new Student("Bob",20);
        Student student4 = new Student("Charles",21);
        Student student5 = new Student("Beth",19);
        Marks marks = new Marks();
        System.out.println(student1.getName());
        Team team1 = new Team(student2,student3);
        Team team2 = new Team(student4,student5);

        team1.atLeastOneResit();
    }


}
