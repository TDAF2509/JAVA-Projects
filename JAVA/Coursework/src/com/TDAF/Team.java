package com.TDAF;

public class Team {
    private Student person1;
    private Student person2;
    private static int numberOfTeams;

    public Team(Student person1, Student person2) {
        this.person1 = person1;
        this.person2 = person2;
        numberOfTeams++;
        System.out.println("Number of teams = "+numberOfTeams);
    }

    public Student getPerson1() {
        return person1;
    }

    public void setPerson1(Student person1) {
        this.person1 = person1;
    }

    public Student getPerson2() {
        return person2;
    }

    public void setPerson2(Student person2) {
        this.person2 = person2;
    }

    public static int getNumberOfTeams() {
        return numberOfTeams;
    }

    public boolean atLeastOneResit(){
        if (person1.getResitter()==true || person2.getResitter()==true){
            System.out.println("one resit");
            return true;
        }
        System.out.println("No resit");
        return false;
    }


}
