package com.TDAF;

import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(ExerciseToWorkOn(n));

    }

    public static int ExerciseToWorkOn(int n) {
        int sum=0;
        for (int i=0; i<n;i++){
            if (i%7==0){
                sum+=i;
            }
        }
        return sum;

    }


}

//public class Main{
//    public static void main(String[] args) {
//        int[][] t = {{2,3,3},{2,1},{3,1,3,3}};
//        int x = 0;
//        int i = 0;
//        int j = 0;
//        count:
//        for (i = 0; i < t.length; i++) {
//            for (j = 0; j < t[i].length; j++) {
//                if (t[i][j] == 3) {
//                    x++;
//                    continue count;
//                }
//            }
//        }
//        System.out.print(x);}}
//}
//    public static void main(String[] args){
//        int x = 3;
//        int y = 3;
//        int z = mystery(x,y);
//        // ++Z doesn't reassign the value of Z unlike Z++
//        System.out.println(++z);
//    }
//    public static int mystery(int x, int y){
//        boolean b = x!=y;
//        //if boolean b is true then return 4 else if boolean b is false return 6
//        return b?4:6;
//    }
//}




//public class Main {
//
//
//    public static void main(String[] args) {
//        //EXERCISE 1
//        Scanner scanner = new Scanner(System.in);
////        System.out.println("Enter the first number: ");
////        int first=scanner.nextInt();
////        System.out.println("Enter the second number: ");
////        int second=scanner.nextInt();
////
////        if (first>second){
////            System.out.println("greater");
////        }else{
////            System.out.println("smaller or equal");
////        }
////
////        //EXERCISE 2
////        System.out.println("Enter a value: ");
////        int value=scanner.nextInt();
////        int total=0;
////        for (int i=0;i<=value;i++){
////            total+=i;
////        }
////        System.out.println("Sum of all the numbers = "+total);
////
////        //EXERCISE 3
////        System.out.println("Enter an integer: ");
////        int integer=scanner.nextInt();
////        while (integer>=0){
////            System.out.println("Enter an integer: ");
////            integer=scanner.nextInt();
////            System.out.println(integer);
////        }
////
////        //EXERCISE 4
////        System.out.println("Enter a month of the year: ");
////        String month = scanner.nextLine();
////        switch(month.toUpperCase()){
////            case "JANUARY":
////                System.out.println("JANUARY = 1");
////                break;
////            case "FEBRUARY":
////                System.out.println("FEBRUARY = 2");
////                break;
////            case "MARCH":
////                System.out.println("MARCH =3");
////                break;
////            case "APRIL":
////                System.out.println("APRIL = 4");
////                break;
////            case "MAY":
////                System.out.println("MAY = 5");
////                break;
////            case "JUNE":
////                System.out.println("JUNE = 6");
////                break;
////            case "JULY":
////                System.out.println("JULY = 7");
////                break;
////            case "AUGUST":
////                System.out.println("AUGUST = 8");
////                break;
////            case "SEPTEMBER":
////                System.out.println("SEPTEMBER = 9");
////                break;
////            case "OCTOBER":
////                System.out.println("OCTOBER = 10");
////                break;
////            case "NOVEMBER":
////                System.out.println("NOVEMBER = 11");
////                break;
////            case "DECEMBER":
////                System.out.println("DECEMBER = 12");
////                break;
////            default:
////                System.out.println("That's not a valid month");
////                break;
////        }
////
////        //EXERCISE 5
////        //the code does bubble sort
////
////        //EXERCISE 6
////        System.out.println("Enter an integer n: ");
////        int n = scanner.nextInt();
////        int[] num = new int [n];
////        for (int i=0;i<=n;i++){
////            System.out.println("Enter "+(n-i)+" more integers");
////            int values=scanner.nextInt();
////            num[i]=values;
////        }
////
////        //EXERCISE 7
////        System.out.println("Enter an integer n: ");
////        int arraySize = scanner.nextInt();
////        int[] numberArray = new int [n];
////        for (int i=0;i<=arraySize;i++){
////            System.out.println("Enter "+(arraySize-i)+" more integers");
////            int values=scanner.nextInt();
////            numberArray[i]=values;
////        }
////        reverse(numberArray);
//
//
//        //EXERCISE 8
////        System.out.println("Enter an integer n for the base: ");
////        int base = scanner.nextInt();
////        for (int i=0;i<base+1;i++){
////            System.out.println("");
////            for (int m=1;m<=((2*i)-1);m++){
//////                System.out.println("i "+i);
//////                System.out.println("m "+m);
////                System.out.print("*");
////            }
////        }
////
////
////        //EXERCISE 9
////        System.out.println("\rEnter a positive integer to start from: ");
////        int start = scanner.nextInt();
////        int next = start;
////        int loops=0;
////        while (next!=1){
////            if (next%2==0){
////                next/=2;
////            }else{
////                next=(next*3)+1;
////            }
////            System.out.println("Loops = "+loops);
////            System.out.println("Next = "+next);
////            loops+=1;
////        }
////
////        //EXERCISE 10
////        System.out.println("Enter the first String sequence: ");
////        String first = scanner.nextLine();
////        System.out.println("Enter the second String sequence: ");
////        String second = scanner.nextLine();
////
//        System.out.println(37/8);
//    }
//
//    public static void reverse (int[] array) {
//        int maxIndex = array.length-1;
//        int halflength = array.length/2;
//        for (int i=0;i<halflength;i++){
//            int temp = array[i];
//            array[i] = array[maxIndex-i];
//            array[maxIndex - i] = temp;
//        }
//
//    }
//}
