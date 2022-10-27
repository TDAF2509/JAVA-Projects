package com.TDAF;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        int highscore=calculateScore(gameOver,score,levelCompleted,bonus);
        System.out.println("your final score was "+highscore);

        // calling procedures with parameters
        // can type in values or variable names
       calculateScore(true,800,levelCompleted,bonus);
        calculateScore(true,600,3,20);


        int position=calculateHighScorePosition(1500);
        displayHighScorePosition("Tayo",position);

        position=calculateHighScorePosition(1000);
        displayHighScorePosition("Jihad",position);

        position=calculateHighScorePosition(400);
        displayHighScorePosition("Shafi",position);

        position=calculateHighScorePosition(50);
        displayHighScorePosition("Hamza",position);
    }

    // void means don`t return a value
    public static int calculateScore(boolean gameOver,int score, int levelCompleted, int bonus){

        if (gameOver){
            int finalScore = score+ (levelCompleted * bonus);
            System.out.println("final score was " + finalScore);
            return finalScore;
        }

        // -1 is used to indicate an error
        return -1;
    }

    public static void displayHighScorePosition(String playerName,int position){

        System.out.println(playerName + " managed to get into position "+position+" on the high score table");
    }

    public static int calculateHighScorePosition(int score){
        if (score>1000){
            return 1;
        }else if(score>500 && score<=1000){
            return 2;
        }else if (score>100 && score<=500){
            return 3;
        }else{
            return 4;
        }
        //Alternative method

    }

}
