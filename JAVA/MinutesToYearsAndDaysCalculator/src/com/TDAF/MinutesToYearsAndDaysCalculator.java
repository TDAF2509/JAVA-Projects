package com.TDAF;

public class MinutesToYearsAndDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        if (minutes<0){
            System.out.println("Invalid Value");
        }else{
            long days=(minutes/(60*24));
            days%=365;
            long years=(minutes/(60*24*365));
            System.out.println(minutes+" min = "+years+" y and "+days+" d");
        }


    }
}
