package com.TDAF;

public class Main {

    public static void main(String[] args) {
        //width of int =32 (4 bytes)
        int myIntValue = 30/8;

        //width of float =32 (4 bytes)
        float myFloatValue = 5f/3f;
        float myFloatValue2 = 30f/8f;
        float myFloatValue3 = 64f/31f;

        //width of double = 64 (8 bytes)
        double myDoubleValue =5d/3d;
        double myDoubleValue2 = 64d/31d;
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myFloatValue2 = " + myFloatValue2);
        System.out.println("myFloatValue3 = " + myFloatValue3);
        System.out.println("myDoubleValue = " + myDoubleValue);
        System.out.println(Math.round(myDoubleValue));
        System.out.println("myDoubleValue2 = "+ myDoubleValue2);


        double myDoublePounds = 200d;
        double myDoubleKilograms= myDoublePounds*0.45359237d;
        System.out.println("kilograms double = " + myDoubleKilograms+"kg");

        float myFloatPounds = 200f;
        float myFloatKilograms= myFloatPounds*0.45359237f;
        System.out.println("kilograms float = " + myFloatKilograms +"kg");

    }
}
