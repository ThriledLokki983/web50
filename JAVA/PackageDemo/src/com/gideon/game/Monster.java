package com.gideon.game;

import java.util.ArrayList;
import java.util.List;

public class Monster implements Isaveable {
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        ArrayList<String> myMedium = new ArrayList<>();
        myMedium.add(0, this.name);
        myMedium.add(1, "" + this.hitPoints);
        myMedium.add(2, "" + this.strength);
        return myMedium;
    }

    @Override
    public void read(List<String> savedMedia) {
        if (savedMedia != null && savedMedia.size() > 0){
            this.name = savedMedia.get(0);
            this.hitPoints = Integer.parseInt(savedMedia.get(1));
            this.strength = Integer.parseInt(savedMedia.get(2));
        }

    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}
