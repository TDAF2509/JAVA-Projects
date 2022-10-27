package com.TDAF;

public class Main {

    public static void main(String[] args) {
        int count=0;
        for (int i=1; i<999; i++){
            isPrime(3);
            if (isPrime(i)==true){
                System.out.println(i+" is a prime number");
                count++;
                if (count==3){
                    break;
                }
            }
        }
        System.out.println(isPrime(6));
        //  initialise ; termination ; increment
        // where it starts ; where it ends ; how much it changes by
        for (int i=2; i<9; i++){
            //"%.2f" will lower the precision and reduce the number of 0s
            //the 2f means there are only 2 0s after the decimal points
            System.out.println("10,000 at "+i+"% interest = "+String.format("%.2f",+calculateInterest(10000,i)));
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount*(interestRate/100));

    }

    public static boolean isPrime(int n) {
        if (n==1){
            return false;
        }

        //Math.sqrt(n) is used over n/2 because it requires less loops
        //This means it is more efficient as it takes up less storage space
        for (int i=2; i<=Math.sqrt(n); i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
