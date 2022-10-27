package com.TDAF;

public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour){

        if(kilometersPerHour<0){
            return -1;
        }else{
            return Math.round(kilometersPerHour/1.609);
           // System.out.println(kilometersPerHour+"km/h = "+milesPerHour+"mi/h");
        }

    }


    public static void printConversion(double kilometersPerHour){

        if(kilometersPerHour<0){
            System.out.println("invalid value");
        }else{
            long milesPerHour=toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour+"km/h="+milesPerHour+"mi/h");
        }

    }
}
