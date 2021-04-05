package com.company;

// Encapsulation is the mechanism of restricting access to the components of objects being created
// Protect the members of a class from external access , thus, guarding against unauthorized access
// It allows to change change things without breaking our code

public class EnhancedPlayer {
    private String fullName;
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String fullName, int health, String weapon) {
        this.fullName = fullName;
        this.hitPoints = (health > 0 && health <= 100) ? health : this.hitPoints;
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        this.hitPoints -= damage;
        //System.out.println("Player knocked out ") = (this.health < 0) ? this.health : ;
        if (this.hitPoints < 0){
            System.out.println("Player knocked out!!");
            // reduce number of lives for current player
        }
    }

    public int getHitPoints() {
        return hitPoints;
    }

}
