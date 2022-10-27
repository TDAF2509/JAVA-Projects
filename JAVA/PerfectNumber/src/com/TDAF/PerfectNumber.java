package com.TDAF;

public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        if (number<1){
            return false;
        }else{
            int factors = 0;
            int num1=number;
            int i = 1;
            int total=0;
            while (i < number) {
                factors = (num1 %= i);
                if (factors==0) {
                    System.out.println(i);
                    total+=i;
                }
                i++;
                num1 = number;
            }
            if ((total)==i){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }
    }
}
