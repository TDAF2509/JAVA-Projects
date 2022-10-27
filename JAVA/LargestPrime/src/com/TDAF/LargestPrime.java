package com.TDAF;

public class LargestPrime {
    public static int getLargestPrime(int number) {
        int i = 2;
        int j = 1;
        if (number < 2) {
            System.out.println("false");
            return -1;
        }else{
            for (i=2;i<number;i++){
                while ((number%i==0)&&number>2){
                    number=number/i;
                    System.out.println("prime "+number);
                }
            }
        }
        return number;
    }
}