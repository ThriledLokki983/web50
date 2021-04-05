package com.company;

public class Main {

    public static void main(String[] args) {
	// Encapsulation is the mechanism of restricting access to the components of objects being created
        // Protect the members of a class from external access , thus, guarding against unauthorized access
        // It allows to change change things without breaking our code
//
//        Player player = new Player();
//        player.name = "Gideon";
//        player.health = 20;
//        player.weapon = "Gun";
//
//        int damage = 8;
//        player.loseHealth(damage);
//        System.out.println("Remaining Health = " + player.healthRemaining());
//
//        damage = 15;
//        player.health = 200;
//        player.loseHealth(damage);
//        System.out.println("Remaining Health = " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("Tim", 70, "Sword");
        System.out.println("Initial Health = " + player.getHitPoints());

    }
}
