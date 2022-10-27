package com.TDAF;

public class Main {

    public static void main(String[] args) {
        int myVariables=50;
        myVariables++;
        myVariables--;
        System.out.println("This is a test");

        // java can still read this since the semi colon is not between lines as a terminator
        // however a plus is needed between each line
        System.out.println("this is " +
        "another" + " test");

        // many statements can be put on one line as along as a semi colon separates them
        int anotherVariable=50;myVariables--;System.out.println("this is another one");


    }
}
