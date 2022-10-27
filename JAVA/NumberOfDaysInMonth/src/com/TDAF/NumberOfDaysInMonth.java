package com.TDAF;

public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
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

    public static int getDaysinMonth(int month, int year) {
        if ((month<1)||(month>12)||(year<1)||(year>9999)){
            return -1;
        }else{
            switch (month){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    System.out.println("31");
                    return 31;

                case 2:
                    if (isLeapYear(year)==true){
                        System.out.println("29");
                        return 29;
                    }else{
                        System.out.println("28");
                        return 28;
                    }
                case 4: case 6: case 9: case 11:
                    System.out.println("30");
                    return 30;
            }
        }

        return month;
    }
}