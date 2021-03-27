package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements Isaveable{
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;


    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> myMedium = new ArrayList<>();
        myMedium.add(0, this.name);
        myMedium.add(1, "" + this.hitPoints);
        myMedium.add(2, "" + this.strength);
        myMedium.add(3, "" + this.weapon);
        return myMedium;
    }

    @Override
    public void read(List<String> myMedium) {
        if (myMedium != null && myMedium.size() > 0){
            this.name = myMedium.get(0);
            this.hitPoints = Integer.parseInt(myMedium.get(1));
            this.strength = Integer.parseInt(myMedium.get(2));
            this.weapon = myMedium.get(3);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
