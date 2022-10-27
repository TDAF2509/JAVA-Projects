package com.TDAF;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        //Exercise1
//        Exersice1(1245);
//        //Exercise2
//        if (arithmeticMean(17,43)>geometricMean(17,43)){
//            System.out.println("True");
//        }else{
//            System.out.println("False");
//        }
//        //Exercise3
//        Exercise3(5);
//
//        //Exercise4
//        Exercise4(8);
//
//        //Exercise5
//        if (arithmeticMean(4)>geometricMean(4)){
//            System.out.println("True");
//        }else{
//            System.out.println("False");
//        }

        //Exercise6
        Exercise6Part2(4);

    }

    //Exercise1
    public static int Exersice1(int n) {
        return ((4*n)+5);
    }

    //Exercise2
    public static double arithmeticMean(int a, int b) {
        return ((a+b)/2);
    }

    public static double geometricMean(int a, int b) {
        return Math.sqrt(a*b);
    }

    //Exercise3
    public static int Exercise3(int n) {
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=i;
        }
        if (n<0){
            sum=0;
        }
        return sum;
    }

    //Exercise4
    public static int Exercise4(int n) {
        int product=1;
        if (n>0) {
            for (int i = 0; i < n; i++) {
                product *= i;
            }
        }else if (n<0){
            for (int i = n; i < -1; i++) {
                product *= i;
            }
        }else {
            product=0;
        }

        return product;
    }

    //Exercise5
    public static double arithmeticMean(int n) {
        Scanner scanner=new Scanner(System.in);
        int mean=0;
        for (int i=0;i<n;i++){
            int value = scanner.nextInt();
            mean+=value;
        }
        return (mean/2);
    }

    public static double geometricMean(int n) {
        Scanner scanner=new Scanner(System.in);
        int mean=0;
        for (int i=0;i<n;i++){
            int value = scanner.nextInt();
            mean+=value;
        }
        return (Math.sqrt(mean));
    }

    //Exercise6
    public static void Exercise6Part1(int n) {
        int l=0;
        for (int i=0;i<n+1;i++){
            System.out.println();
            l=0;
            for (int m=1;m<=i;m++){
                while (l<(n+1)-i){
                    System.out.print(" ");
                    l++;
                    //System.out.print(l);
                }
                System.out.print("*");
            }
        }
    }

    //Exercise6
    public static void Exercise6Part2(int n) {
        int l=0;
        int k=0;
        for (int i=0;i<n+1;i++){
            System.out.println();
            l=0;
            for (int m=n;m>=i;m--){
                while (n-i>=0){
                    System.out.print(" ");
                    l++;
                    //System.out.print(l);
                }
                System.out.print("*");
            }
        }
    }
}
