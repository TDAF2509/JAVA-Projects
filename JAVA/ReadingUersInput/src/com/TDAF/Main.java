package com.TDAF;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.in allows the user to type into the console and return it to the program
        //This is what a variable of type scanner does
        //Scanner is a class
        // 'new' creates a new instance of type scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of birth: ");

        boolean hasNextInt=scanner.hasNextInt();

        if (hasNextInt){
            int YearOfBirth=scanner.nextInt();
            //scanner.nextLine is used here so the program handles the next line character
            //and does not take the input to be the enter key
            scanner.nextLine();
            System.out.println("Your year of birth is "+YearOfBirth);

            System.out.println("Enter your name: ");
            //reads a line of input from the console and saves it under the variable 'name'
            String name = scanner.nextLine();

            int age = 2019-YearOfBirth;

            if (age>=0 && age <=100){
                //prints out what the user types
                System.out.println("Your name is "+name+", and you are "+age+" years old");
            }else{
                System.out.println("Invalid birth year");
            }
        }else {
            System.out.println("Unable to parse year of birth");
        }
        //after closing the scanner calling methods like nextLine will cause errors
        scanner.close();
    }
}
