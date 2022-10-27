package com.TDAF;

public class LastDigitChecker {
    public static boolean hasSameLastDigit(int num1,int num2,int num3) {
        if (num1<10 || num1>1000 || num2<10 || num2>1000 || num3<10 || num3>1000){
            return false;
        }
        num1%=10;
        num2%=10;
        num3%=10;
        if (num1==num2 || num1==num3 || num2==num3){
            System.out.println("True");
            return true;
        }
        return false;
    }

    public static boolean isValid(int valid) {
        if (valid<10 || valid>1000) {
            return false;
        }else{
            return true;
        }
    }
}
