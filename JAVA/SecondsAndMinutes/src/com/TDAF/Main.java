package com.TDAF;

public class Main {
    //CONSTANTS ARE TYPED IN UPPERCASE
    public static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        getDurationString(65,90);
        getDurationString(3600);

    }

    public static String getDurationString(int minutes, int seconds) {
        if((minutes<0) || (seconds<0) || (seconds>59)){
            return INVALID_VALUE_MESSAGE;
        }

        int hours=(minutes/60);
        hours+=(seconds/3600);
        if((minutes%=60)==0){
        }
        System.out.println(hours+"h "+minutes+"m "+seconds+"s");
        return hours;
    }

    public static String getDurationString(int seconds) {
        if (seconds<0){
            return INVALID_VALUE_MESSAGE;
        }
        int minutes = (seconds/60);
        if ((seconds%=60)==0){
        }
        return getDurationString(minutes,seconds);

    }
}
