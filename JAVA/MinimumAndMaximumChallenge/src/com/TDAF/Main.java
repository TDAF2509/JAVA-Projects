package com.TDAF;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int value = 0;
        int i = 1;

        while (i <= 10) {
            System.out.println("Enter number #" + i);
            boolean hasNextInt = scanner.hasNextInt();
            int NextInt = scanner.nextInt();
            int maximum = NextInt;
            int minimum = NextInt;
            if (hasNextInt) {
                i++;
                System.out.println("Enter number #" + i);
                int number = scanner.nextInt();
                scanner.nextLine();
                if (number > maximum) {
                    maximum = number;
                    i++;
                } else if (number < minimum) {
                    minimum = number;
                    System.out.println("Invalid Number");
                }
                scanner.nextLine();
            }
            //System.out.println("value is " + value);
            //System.out.println("Maximum = " + maximum + " Minimum = " + minimum);
        }
        System.out.println("value is " + value);
        System.out.println("Maximum = " + maximum + " Minimum = " + minimum);
        scanner.close();
    }
}
