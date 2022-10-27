package com.TDAF;


import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        String hello="abcdefghij";
        System.out.println(hello.length());
        String[] normalArray={"10","5","25","15","30","50"};
        System.out.println(normalArray[0]);
        System.out.println("Normal array = "+Arrays.toString(normalArray));
        reverse(normalArray);
        System.out.println("Reversed array = "+Arrays.toString(normalArray));
    }

    public static void reverse (String[] array) {
        int maxIndex = array.length-1;
        int halflength = array.length/2;
        for (int i=0;i<halflength;i++){
            String temp = array[i];
            array[i] = array[maxIndex-i];
            array[maxIndex - i] = temp;
        }

    }




}
