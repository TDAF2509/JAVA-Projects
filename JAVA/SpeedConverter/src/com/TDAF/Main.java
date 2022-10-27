package com.TDAF;

public class Main {
    public static void main(String[] args) {
        long miles = SpeedConverter.toMilesPerHour(1);
        System.out.println("Miles"+miles);

        SpeedConverter.printConversion(1.5);
    }
}
