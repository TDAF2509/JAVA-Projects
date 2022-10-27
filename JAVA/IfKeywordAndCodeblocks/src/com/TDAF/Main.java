package com.TDAF;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        if (score < 5000 && score> 1000) {
            System.out.println("Your score was less than 5000 but greater than 1000");
        }else if (score<1000){
            System.out.println("score was less than 1000");
        }else {
            System.out.println("here");
        }

        if (gameOver){
            int finalScore = score+ (levelCompleted * bonus);
            System.out.println("final score was " + finalScore);

        }

        boolean GameOver=true;
        int secondScore=10000;
        int levelCompleted2=8;
        int bonuns=200;

        if(GameOver){
            int Finalscore=secondScore+(levelCompleted2*bonuns);
            System.out.println("final score ="+ Finalscore);
        }

        }


}
