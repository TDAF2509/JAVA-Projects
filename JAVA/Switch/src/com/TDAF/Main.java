package com.TDAF;

public class Main {

    public static void main(String[] args) {

        int switchValue=2;

        switch (switchValue){
            case 1:
                System.out.println("value was 1");
                break;

            case 2:
                System.out.println("value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("was a 3, or a 4, or a 5");
                System.out.println("Actually it was a " + switchValue);
                break;
             default:
                 System.out.println("was not 1,2,3,4 or 5");
                 break;
        }

        char SwitchValue='A';
        switch (SwitchValue){
            case 'A':
                System.out.println("value was A");
                break;
            case 'B':
                System.out.println("value was B");
                break;
            case 'C':
                System.out.println("value was C");
                break;
            case 'D':
                System.out.println("value was D");
                break;
            case 'E':
                System.out.println("Value was E");
                break;

            default:
                System.out.println("value was not A,B,C,D or E");
                break;
        }

        String month = "June";
        // .toLowerCase() converts the String "June" to lowercase this would be the same
        // if the upper and lowercases were mixed
        // .toUpperCase converts String text to uppercase
        switch (month.toLowerCase()){
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
        }
    }
}
