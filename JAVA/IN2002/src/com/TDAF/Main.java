package com.TDAF;

public class Main {


    public static int bla(int[] array) {
        if (array.length == 0){
            return 0;
        }else{
            return blaHelp(array,1,0);
        }

    }

    public static int blaHelp(int[] arr,int i,int j){
        if (arr.length == i){
            return j;
        }
        int k = blaHelp(arr,i+1,j);
        if (k>arr[i]){
            return k;
        }
        return arr[i];
    }

    public static void main(String[] args) {
        int[] test={1,7,3,4,5};
        bla(test);
        System.out.println(bla(test));

    }
}
