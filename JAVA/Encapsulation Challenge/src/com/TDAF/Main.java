package com.TDAF;

public class Main {

    public static void main(String[] args) {
	Printer printer = new Printer(70,true);
        System.out.println("Toner Level is "+printer.getTonerLVL()+"%");
        printer.printing(25);
        System.out.println();
        System.out.println("Toner Level is "+printer.getTonerLVL()+"%");
        printer.printing(60);
//        System.out.println("Toner Level is "+printer.getTonerLVL()+"%");
//        System.out.println();
//        printer.fillToner(50);

    }
}
