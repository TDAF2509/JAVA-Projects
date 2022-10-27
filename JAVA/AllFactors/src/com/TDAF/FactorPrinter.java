package com.TDAF;

public class FactorPrinter {
    public static void printFactors(int number) {
        if (number<1){
            System.out.println("Invalid Value");
        }else{
            int factors = 0;
            int num1=number;
            int i = 1;
            while (i < number+1) {
                factors = (num1 %= i);
                if (factors==0) {
                    System.out.println(i);
                }
                i++;
                num1 = number;
            }
        }

    }
}
