package com.TDAF;

public class BarkingDog{
    public static boolean shouldWakeUp(boolean barking,int hourofDay){

        if(hourofDay<0 || hourofDay > 23){
            return false;
        }else if ((hourofDay<8 || hourofDay>22)&& barking==true){
            return true;
        }else{
            return false;
        }

    }
}

