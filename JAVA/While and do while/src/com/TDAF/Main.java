package com.TDAF;

public class Main {

    public static void main(String[] args) {
	int count =1;
	while (count!=5){
       // System.out.println("Count value is "+count);
        count++;
    }

    count=1;
    while (true){
	    if (count==5){
	        break;
        }
       // System.out.println("count value is "+count);
	    count++;
    }
    count=1;
    do {
       // System.out.println("Count value is "+count);
        count++;
    }while (count!=5);

    int number=4;
    int finishnumber=20;
    int even=0;
    while (number<=finishnumber){
        number++;
        count++;
        if (!isEvenNumber(number)){
            continue;
        }
        System.out.println("Even number is "+number);
        even++;
        if (even>=5){
            System.out.println("even numbers found = "+even);
            break;
        }


    }
    //isEvenNumber(18);
    }

    public static boolean isEvenNumber(int number) {
        if ((number%=2)!=0){
            System.out.println("false");
            return false;
        }else{
            System.out.println("true");
            return true;
        }

    }
}
