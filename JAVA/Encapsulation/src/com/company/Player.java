package com.company;

public class Player {
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage){
        this.health -= damage;
        //this.health == 0 ? 0 : System.out.println("Player knocked out");
        if (this.health < 0){
            System.out.println("Player knocked out!!");
            // reduce number of lives for current player
        }
    }

    public int healthRemaining(){
        return this.health;
    }
}
