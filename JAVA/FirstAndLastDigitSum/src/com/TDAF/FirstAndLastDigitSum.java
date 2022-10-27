package com.TDAF;

public class FirstAndLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        if (number<0){
            return -1;
        }else{
            int n=number;
            int last=number%10;
            int first=n%10;
            while (n>0){
                first=n%10;
                n=(n-first)/10;
            }
            return (first+last);
        }
    }
}
