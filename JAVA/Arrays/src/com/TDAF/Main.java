package com.TDAF;

import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//        // Defined an array of type integer with space for 10 elements
//        // The square brackets are the syntax for an array in java
//        int[] myIntArray= new int[10];
//        // This saves the number 50 to the array in element position 5
//        // The arrays in java act like the arrays in python in terms of
//        // starting point as both start from 0, so technically 50 would be
//        // saved in position 6;
//        myIntArray[5]=50;
//        // This will print out the value of the item in position 5 of the array
//        System.out.println("myIntArray[5]= "+myIntArray[5]);
//
//        // Defined an array of type integer, by defining it this way java knows
//        // the number of elements in the array and the numbers assigned to each element
//        int[] myIntArray2 = {1,2,3,4,5,6,7,8,9,10};
//        System.out.println("myIntArray2[5]= "+myIntArray2[5]);
//        System.out.println("myIntArray2[9]= "+myIntArray2[9]);
//
//        // Using a for loop to populate an array
//        // .length is a substitute for the value of 10 as that is the array length
//        // If a value greater than the length of the array was chosen then there
//        //  would be an error as it cant populate more elements than there are
//        for (int i =0 ; i<myIntArray.length ; i++){
//            myIntArray[i] = i*10;
//            System.out.println("myIntArray["+i+"]= "+myIntArray[i]);
//        }
//
//        // Calls the module below and
//        printArray(myIntArray);
//
//        // Defined an arra of type double with space for 10 elements
//        double[] myDoubleArray = new double[10];
//    }
//
//    // Another method of looping and printing arrays
//    public static void printArray(int[] array){
//        for (int i =0 ; i<array.length ; i++){
//            System.out.println("Element "+i+", value is "+array[i]);
//        }
//    }



    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5);

        for (int i=0;i<myIntegers.length;i++){
            System.out.println("Element "+i+", typed value was "+myIntegers[i]);
        }
        System.out.println("The average is "+getAverage(myIntegers));

    }

    public static int[] getIntegers(int number){
        System.out.println("Enter "+ number+ " integer values. \r");
        int[] values = new int[number];

        for (int i=0;i<values.length;i++){
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static double getAverage(int[] array) {
        int sum = 0;
        for (int i=0; i<array.length;i++){
            sum += array[i];
        }

        return (double) sum / (double)array.length;

    }
}
