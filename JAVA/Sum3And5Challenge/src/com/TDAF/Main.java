package com.TDAF;

public class Main {

    public static void main(String[] args) {
        int count=0;
        int sum=0;
        for (int i=1; i<=1000; i++){
            Sum3And5(i);
            if (Sum3And5(i)==true){
                System.out.println(i);
                sum+=i;
                count++;
            }else if (count==5){
                System.out.println("the sum of the values is "+sum);
                break;
            }
        }
    }

    public static boolean Sum3And5(int number) {
        int remainder=number;
        int remain=number;
        // if ((i%3==0)&&(i%5==0)) is also a viable option
        if (((remainder%=3)==0)&&((remain%=5)==0)){
            return true;
        }else{
            return false;
        }
    }
}
