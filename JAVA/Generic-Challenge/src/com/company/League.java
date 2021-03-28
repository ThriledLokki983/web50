package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 10:54 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class League<T extends Team> {
    public String name;

    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean add(T team){
        if (league.contains(team)){
            return false;
        }
        league.add(team);
        return true;
    }

    public void showLeagueTable(){
        Collections.sort(league);
        System.out.println("=============== League Table ==================");
        for (T t : league){
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
