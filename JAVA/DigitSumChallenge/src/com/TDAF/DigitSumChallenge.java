package com.TDAF;

public class DigitSumChallenge {
    public static int sumDigits(int number) {
        int total=0;
        if (number<10){
            return -1;
        }else{
            while (number>0){
                int n=number;
                n%=10;
                number-=n;
                number/=10;
                total+=n;
            }
            System.out.println(total);
        }
        return number;
    }
}
