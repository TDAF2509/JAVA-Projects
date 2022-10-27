package com.TDAF;

public class Student {
    private String name;
    private int IDnumeber;
    private int[] marks;

    public Student(String name, int IDnumeber, int[] marks) {
        this.name = name;
        this.IDnumeber = IDnumeber;
        this.marks = marks;
    }

    public int updateMark (int newMark,int i) {
        marks[i]=newMark;
        for (int x=0;x<marks.length;x++)
        if (marks[i]<40){
            return marks[i];
        }
        return marks[i];
    }
}
