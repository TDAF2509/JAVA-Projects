package com.TDAF;

public class EqualSumChecker {
    public static boolean hasEqualSum(int number1,int number2,int number3) {
        if ((number1+number2)==number3){
            System.out.println("true");
            return true;
        }else {
            System.out.println("false");
            return false;
        }

    }
}
