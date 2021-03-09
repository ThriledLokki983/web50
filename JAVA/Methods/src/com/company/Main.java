package com.company;

import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
	// Methods
//        boolean gameOver = true;
//        int score = 800;
//        int levelCompleted = 5;
//        int bonus = 100;

        calculateScore(true, 800, 5, 100);
        calculateScore(true, 10000, 8, 200); // This is our method now.
        int highScorePosition = calculateHighScorePosition(1500, 900, 50);
        System.out.println(highScorePosition);
        displayHighScorePosition("Gideon ",highScorePosition);
        // now we have just one place to make changes to and everything is fine

        // Another way of looking at it
//        boolean gameOver = true;
//        int score = 900;
//        int levelCompleted = 9;
//        int bonus = 500;
//        calculateScore(gameOver, score, levelCompleted, bonus);

        highScorePosition = highScorePositionCalculation(1000);
        displayHighScorePosition("Gideon", highScorePosition);
        highScorePosition = highScorePositionCalculation(500);
        displayHighScorePosition("Louise", highScorePosition);
        highScorePosition = highScorePositionCalculation(100);
        displayHighScorePosition("Bernard", highScorePosition);
        highScorePosition = highScorePositionCalculation(80);
        displayHighScorePosition("Youngee", highScorePosition);

        // Assign a variable to the return value of our method
//        int highScore = SecondCalculateScore(true, 900, 8, 400);
//        System.out.println("Your highest score is " + highScore);


    }

    // 1st attempt to create a method
    // Method has an attribute Main
    // A method should be within the same class
    // void ==> don'' return anything

    public  static  void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        // Anything in here is what is part of this method
        if (gameOver){
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            System.out.println("Your final score is: " + finalScore);
        }
    }

    public  static  int SecondCalculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        // Anything in here is what is part of this method
        if (gameOver){
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
//            System.out.println("Your final score is: " + finalScore);
            return finalScore;
        }
//        else {
//            return -1;
//        }
        return -1;
    }

    public static int calculateHighScorePosition(int score, int levelCompleted, int bonus) {
        // Anything in here is what is part of this method

            int highScore = score + (levelCompleted * bonus);
            if(highScore >= 1000){
                int topPosition = 1;
                return topPosition; // This is redundant and you can just return 1 straight away
            }
            else if(highScore >= 500 && highScore < 1000)
            {
                int topScore = 2;
                return topScore;
            }
            else if(highScore >= 100 && highScore < 500){
                int topScore = 3;
                return topScore;
            }
            else {
                int topScore = 4;
                return topScore;
            }

    }

    public static int highScorePositionCalculation (int score){
        int position = 4;
        if (score >= 1000){
            position = 1;
        }else if (score >= 500){
            position = 2;
        }else if (score >= 100){
            position = 3;
        }
        return position;
    }

    public static void displayHighScorePosition(String thePlayerName, int highScore){
            System.out.println(thePlayerName + ", managed to get into position " + highScore + " on the high score table");
    }
}


