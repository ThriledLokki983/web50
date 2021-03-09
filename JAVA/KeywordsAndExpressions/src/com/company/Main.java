package com.company;

public class Main<score> {

    public static void main(String[] args) {
	// write your code here

        boolean gameOver = true;
        int scoreScore = 5000;
        int levelCompleted = 5;
        int bonus = 100;
        if( scoreScore == 500){
            System.out.println("Your have the highest score:");
        }
        else if (scoreScore < 5000){
            System.out.println("You did not get the highest score, sorry try again next time!!");
        }
        else{
            System.out.println("You are neither here nor there");
        }

        if(gameOver){ // Whatever is inside this codeblock is within the scope of the
            int finalScore = scoreScore + (levelCompleted * bonus); // the variable created here cannot be used outside the codeblock
            System.out.println("Your final score is: " + finalScore);
        }

        if(gameOver){
           scoreScore = 10000;
           levelCompleted = 8;
           bonus = 200;
           int finalScore = scoreScore + (levelCompleted * bonus);
            System.out.println("Your second score is: " + finalScore);
        }
    }

    // keywords are reserved words for the java programming language. you cannot use them as variables.
    //
    //Expressions data type is not part of the expression, but variables, operators are
    // part of the expression -- the entire line minus the semi colon and the data type is your expression.

    // statement = from the data type assignment all the way to the end of the line with the semi colon.
    // Semi colon is needed to make a statement valid ==> there are exceptions

    // if Keyword and Code Block


}
