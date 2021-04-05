package com.company;

class Movie{
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot(){
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie{
    public Jaws(){
        super("Jaws");
    }

    public String plot(){
        return "A shark eats lots of people";
    }
}

class independenceDay extends Movie {
    public independenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to take over Planet earth";
    }
}

class MazeRunner extends Movie{
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids tried to attempt to escape a maze";
    }
}

class starWars extends Movie {
    public starWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial Forces tried to take over the universe";
    }
}

class Forgetable extends Movie{
    public Forgetable() {
        super("Forgettable");
    }

    // No plt at all for this class
}














public class Main {

    public static void main(String[] args) {
	// POLYMORPHISM
        // This is the mechanism in OOP that allows actions to act/behave differently based on the actual object
        // Inheritance allows us to inherit attributes and methods from another class & Polymorphism uses these methods to perform different
        // tasks This allows us to perform a single action in different ways


        // create  a for loop
        for(int i = 1; i < 11; i++){
            Movie movie = randomMovie();
            System.out.println("Movie #: " + i + ": " + movie.getName() + "\n" + "Plot: " + movie.plot() + "\n");
        }
    }

    public static Movie randomMovie(){
    int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated was: " + randomNumber);

        switch (randomNumber){
            case 1:
                return new Jaws();

            case 2:
                return new independenceDay();

            case 3:
                return new Forgetable();

            case 4:
                return new starWars();

            case 5:
                return new MazeRunner();

        }
        return null;
    }
}
