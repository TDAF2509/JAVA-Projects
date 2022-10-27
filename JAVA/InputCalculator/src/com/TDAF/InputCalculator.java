package com.TDAF;

import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner= new Scanner(System.in);

        long sum=0;
        double counter=0;

        while (true){

            boolean isAnInt=scanner.hasNextInt();

            if (isAnInt){
                int number=scanner.nextInt();
                counter++;
                sum+=number;
                scanner.nextLine();
            }else {
                if (sum==0 && counter==0){
                    System.out.println("SUM = 0 AVG = 0");
                    break;
                }else{
                    long average=Math.round((sum/counter));
                    System.out.println("SUM = "+sum+" AVG = "+average);
                    break;
                }
            }
        }
    }
}
