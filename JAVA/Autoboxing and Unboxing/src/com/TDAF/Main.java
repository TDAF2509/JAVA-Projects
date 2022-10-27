package com.TDAF;

import java.util.ArrayList;

class IntClass{
    private int myValue;

    public IntClass(int myValue){
        this.myValue = myValue;
    }

    public int getMyValue(){
        return myValue;
    }

    public void setMyValue(int myValue){
        this.myValue = myValue;
    }
}
public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tayo");

        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(56));
        Integer integer = new Integer(56);
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
//        for (int i=0; i<=10; i++){
//            System.out.println(i+" --> "+intArrayList.get(i).intValue());
//        }


        //This is a much quicker version of the above, This is better for modern compilers
        Integer myIntValue = 56;//Java reads this as Integer.valueOf(56)
        int myInt = myIntValue; //Java reads this as int myInt = myInt.intValue()

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl=0.0; dbl<=10.0;dbl+=0.5){
            myDoubleValues.add(dbl);//Java reads this as myDoubleValues.add(Double.valueOf(dbl))
        }

        for (int i=0; i<myDoubleValues.size(); i++){
            double value = myDoubleValues.get(i);// Java reads this as double value = myDoubleValues.get(i).doubleValue()
            System.out.println(i+" --> "+value);
        }
    }
}
