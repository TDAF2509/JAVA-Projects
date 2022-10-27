package com.TDAF;

public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first,int second) {
        if (first<10 || second<10){
            return -1;
        }else {
            int hcf1 = 0;
            int hcf2 = 0;
            int i = 1;
            int num1 = first;
            int num2 = second;
            int hcf = 0;
            while (i < first) {
                hcf1 = (num1 %= i);
                hcf2 = (num2 %= i);
                if ((hcf1==0) && (hcf2==0)) {
                    hcf = i;
                    System.out.println("highest common factor " + hcf);
                    System.out.println(" ");
                }
                i++;
                num1 = first;
                num2 = second;
            }
            return hcf;
        }
    }
}