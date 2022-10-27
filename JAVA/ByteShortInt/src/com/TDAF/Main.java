package com.TDAF;

public class Main {

    public static void main(String[] args) {
        // integer has a width of 32 (2 to the 32 divided by 2)
        int myMinValue= -2_147_483_648;
        int myMaxValue= 2_147_483_647;
        int myIntValue=50;
        int myNewValue= (int) (myIntValue);
        System.out.println(myNewValue);

        // Byte has a width of 8 (2 to the 8 divided by 2)
        byte myMaxByteValue= 127;
        byte myMinByteValue= -128;
        byte myByteValue =10;
        byte myNewByteValue = (byte) (myByteValue);
        System.out.println(myNewByteValue);

        // Short has a width of 16 (2 to the 16 divided by 2)
        short myMaxShortValue= 32767;
        short myMinShortValue= -32768;
        short myShortValue=20;
        short myNewShortValue= (short) (5000+10*(myShortValue+myByteValue+myIntValue));
        System.out.println(myNewShortValue);

        //Long has a width of 64 (2 to the 64 divided by 2)
        long myMaxLongValue= 922_337_203_6_854_775_807L;
        long myMinLongValue= -9223372036854775808L;
        long myNewLongVlaue= 50000L+10L*(myNewByteValue + myNewShortValue + myNewValue);
        System.out.println(myNewLongVlaue);
    }
}
