package com.TDAF;

public class NumberToWords {
    public static void numberToWords(int number) {
        int resetnumber = number;
        int remainder = resetnumber;
        String word = "";
        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            while (resetnumber > 0) {
                remainder %= 10;
                switch (remainder) {
                    case 0:
                        word = "Zero";
                        //System.out.println(word);
                        break;
                    case 1:
                        word = "One";
                        //System.out.println(word);
                        break;
                    case 2:
                        word = "Two";
                        //System.out.println(word);
                        break;
                    case 3:
                        word = "Three";
                        //System.out.println(word);
                        break;
                    case 4:
                        word = "Four";
                        //System.out.println(word);
                        break;
                    case 5:
                        word = "Five";
                        //System.out.println(word);
                        break;
                    case 6:
                        word = "Six";
                        //System.out.println(word);
                        break;
                    case 7:
                        word = "Seven";
                        //System.out.println(word);
                        break;
                    case 8:
                        word = "Eight";
                        //System.out.println(word);
                        break;
                    case 9:
                        word = "Nine";
                        //System.out.println(word);
                        break;
                    default:
                        System.out.println("here");
                        break;
                }
                System.out.println(word);
                resetnumber -= remainder;
                resetnumber/=10;
                remainder=resetnumber;
            }
        }
    }

    public static void reverse(int number) {
        int n=number;
        int remainder=(n%=10);
    }

    public static int getDigitCount(int number) {
        int resetnumber = number;
        int remainder = resetnumber;
        int digits=0;
        if (number<0){
            return -1;
        }else{
            while (resetnumber > 0) {
                remainder %= 10;
                resetnumber -= remainder;
                resetnumber/=10;
                digits++;
                remainder=resetnumber;
            }
            System.out.println(digits);
            return digits;
        }

    }
}
