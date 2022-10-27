package com.TDAF;

public class Main {

    public static void main(String[] args) {
        String myString = "This is a string";
        System.out.println("here is my string "+ myString);
        myString= myString+ " and this is more";
        System.out.println("myString is equal to " + myString);

        //Concatination
        String numberString = "250.55";
        numberString = numberString+ "49.95";
        System.out.println("this is the result " +numberString);

        //Java recognises both the string and integer however it will convert the int to string since its being added to it.
        //It would do the same for other data types such as doubles etc
        String lastString  ="10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("lastString is equal to  " + lastString);

    }
}
