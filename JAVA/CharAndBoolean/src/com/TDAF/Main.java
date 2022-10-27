package com.TDAF;

public class Main {

    public static void main(String[] args) {
        //The characters here are achieved using unicode
        char copyrightSymbol = '\u00A9';
        System.out.println("unicode for the copyright symbol is "+copyrightSymbol);

        boolean myboolean = true;
        boolean isMale= true;

        if (myboolean){
            System.out.println("True");
        }

        char regesteredSymbol = '\u00AE';
        System.out.println("unicode for the registered symbol is "+regesteredSymbol);

        char spiral = '\u058E';
        System.out.println("unicode for the Left-Facing Armenian Eternity Sign symbol is "+spiral);

        char sigma = '\u03A3';
        System.out.println("unicode for the sigma symbol is "+sigma);
    }
}
