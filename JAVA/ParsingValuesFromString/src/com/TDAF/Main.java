package com.TDAF;

public class Main {

    public static void main(String[] args) {
        String numberAsString="2018";
        System.out.println("numberAsString= "+numberAsString);

        //converts string to integer
        int intnumber= Integer.parseInt(numberAsString);
        System.out.println("number= "+intnumber);

        //converts string to double can be used for float and long and short as well
        double doublemumber = Double.parseDouble(numberAsString);
        System.out.println("doublenumber = "+doublemumber);

        //numberAsString concatenates 1 to 2018
        numberAsString+=1;
        intnumber+=1;
        doublemumber+=1;

        System.out.println("numberAsSting= "+numberAsString);
        System.out.println("number= "+intnumber);
        System.out.println("doublenumber= "+doublemumber);
    }
}
