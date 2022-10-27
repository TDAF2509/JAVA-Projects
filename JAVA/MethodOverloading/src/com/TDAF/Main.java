package com.TDAF;

public class Main {

    public static void main(String[] args) {
	int newScore= calculateScore("tayo",500);
        System.out.println("New score is "+newScore);
        calculateScore(75);
        double centimeters = calcFeetAndInchesToCentimeters(6,0);
        if (centimeters<0){
            System.out.println("Invalid parameters");
        }

        calcFeetAndInchesToCentimeters(157);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("player "+playerName+" scored "+score+" points");
        return score*1000;
    }
    public static int calculateScore(int score) {
        System.out.println("unnamed player scored "+score+" points");
        return score*1000;

    }

    public static int calculateScore(){
        System.out.println("no player name, no player score");
        return 0;
    }

    // even if you changed the returned data type it like this :public static void calculateScore(){
    // it would still cause a problem because it has the same method name and parameters
        //System.out.println("no player name, no player score");

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if ((feet < 0) || ((inches < 0) || (inches > 12))) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }
        double centimeters = (feet*12)*2.54;
        centimeters += inches*2.54;
        System.out.println(feet+" feet, "+inches+" inches = "+centimeters+"cm");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            return -1;
        }
        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + " inches is equal to " + feet + " feet and" + remainingInches + " inches");
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }

}
