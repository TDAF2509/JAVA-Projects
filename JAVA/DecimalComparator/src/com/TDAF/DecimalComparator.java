package com.TDAF;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double number1,double number2) {
        number1*=1000;
        number2*=1000;
        if ((number1-number2)<1 && (number1-number2)>-1){
            return true;
        }else{
            return false;
        }

    }
}
