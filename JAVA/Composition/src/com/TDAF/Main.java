package com.TDAF;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20,20,5);
        Case theCase = new Case("220B", "Dell", "240",dimensions);

        Monitor theMonitor = new Monitor("27inchBeast", "Acer", 27, new Resolution(2540,1440));

        MotherBoard thenotherBoard = new MotherBoard("BJ-200", "Asus",4,6,"v2.44");

        PC thePC = new PC(theCase,theMonitor,thenotherBoard);

        thePC.powerUP();
    }
}
