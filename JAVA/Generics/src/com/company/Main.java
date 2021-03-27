package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer gideon = new BaseballPlayer("Gideon");
        SoccerPlayer frank = new SoccerPlayer("Frank");

        Team<FootballPlayer> groningen = new Team<>("FC Groningen");
        groningen.addPlayer(joe);
//        groningen.addPlayer(gideon);
//        groningen.addPlayer(frank);

        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Chicago Cubs");
        baseballPlayerTeam.addPlayer(gideon);

        Team<SoccerPlayer> soccerPlayerTeam = new Team<>("Red Bulls FC");
        soccerPlayerTeam.addPlayer(frank);

        System.out.println(groningen.numPlayer());
    }
}
