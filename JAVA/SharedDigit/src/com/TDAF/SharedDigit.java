package com.TDAF;

public class SharedDigit {
    public static boolean hasSharedDigit(int number1, int number2) {
        if (number1 < 10 || number1 > 99 || number2 < 10 || number2 > 99) {
            System.out.println("false");
            return false;
        } else {
            int n=number1;
            int m=number2;
            int secondnumber1=(n%=10);
            int secondnumber2=(m%=10);
            int firstnumber1=((number1-n)/10);
            int firstnumber2=((number2-m)/10);
            System.out.println("first of first is "+firstnumber1);
            System.out.println("first of second is "+firstnumber2);
            System.out.println("second of first is "+secondnumber1);
            System.out.println("second of second is "+secondnumber2);
            if ((firstnumber1==firstnumber2) || (firstnumber1==secondnumber2) || (firstnumber2==secondnumber1) || (secondnumber1==secondnumber2)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
            }
        }
        return false;
    }
}