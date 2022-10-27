package com.TDAF;

public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        int reverse=0;
        int n=number;
        while ((n>0) || (n<0)){
            int lastdigit=n;
            lastdigit%=10;
            reverse=(reverse*10)+lastdigit;
            n/=10;
        }
        System.out.println(reverse);
        if (number==reverse){
            System.out.println("true");
            return true;
        }else{
            System.out.println("false");
            return false;
        }

    }
}
