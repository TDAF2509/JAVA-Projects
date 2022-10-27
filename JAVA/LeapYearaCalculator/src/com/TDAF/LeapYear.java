package com.TDAF;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        System.out.println("year "+year);

        int remainder=year%4;
        int remainder2=year%100;
        int remainder3=year%400;
        if (year>9999 || year<1){
            System.out.println("false");
            System.out.println("year "+year);
            return false;
        }else if(remainder==0){
            System.out.println("year "+year);
            if(remainder2==0){
                System.out.println("year "+year);
                if(remainder3==0){
                    System.out.println("year "+year);
                    System.out.println("true");
                    return true;
                }else{
                    System.out.println("year "+year);
                    System.out.println("false");
                    return false;
                }
            }else{
                System.out.println("year "+year);
                System.out.println("true");
                return true;
            }

        }
        System.out.println("year "+year);
        System.out.println("false");
        return false;
    }
}
