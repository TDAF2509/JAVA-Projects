package com.TDAF;

public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        int total=0;
        if (number<0){
            return -1;
        }else{
            while (number>0){
                int n=number;
                n%=10;
                number-=n;
                number/=10;
                if ((n%2)==0){
                    total+=n;
                }
            }
            System.out.println(total);
        }
        return number;
    }
}
