package com.TDAF;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //readIntegers(5);
        findMin(readIntegers(5));


    }

    private static Scanner scanner = new Scanner(System.in);

    public static int[] readIntegers(int count) {
        int[] array = new int[count];
        for (int i=0;i<array.length;i++){
            array[i]=scanner.nextInt();
        }

        System.out.println("Array = "+ Arrays.toString(array));
        return array;

    }

    public static void findMin(int[] array) {
        int[] min = array;
        int minimum = 0;
        for (int i=0; i<min.length-1;i++){
            if (min[i]<min[i+1]){
            }else{
                minimum=min[i+1];
            }
        }
        System.out.println("Minimum= "+minimum);

    }


}
