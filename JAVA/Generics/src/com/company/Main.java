package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        
        
        SoccerPlayer frank = new SoccerPlayer("Frank");
        FootballPlayer nanayaw = new FootballPlayer("Nana Yaw");
        FootballPlayer joe = new FootballPlayer("Joe");

        Team<FootballPlayer> groningen = new Team<>("FC Groningen");
        groningen.addPlayer(joe);
        Team<FootballPlayer> zwolle = new Team<>("PEC Zwolle");
        zwolle.addPlayer(nanayaw);

        BaseballPlayer gideon = new BaseballPlayer("Gideon");
        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Chicago Cubs");
        baseballPlayerTeam.addPlayer(gideon);

        Team<SoccerPlayer> soccerPlayerTeam = new Team<>("Red Bulls FC");
        soccerPlayerTeam.addPlayer(frank);
        

        groningen.matchResult(baseballPlayerTeam, 3, 1);
        groningen.matchResult(soccerPlayerTeam, 1, 0);
        soccerPlayerTeam.matchResult(groningen, 1, 5);
        soccerPlayerTeam.matchResult(groningen, 2, 2);
        baseballPlayerTeam.matchResult(soccerPlayerTeam, 5,6);
        baseballPlayerTeam.matchResult(groningen, 3, 1);
        zwolle.matchResult(groningen, 3, 2);
        zwolle.matchResult(groningen, 3, 1);

        System.out.println(groningen.numPlayer());

        System.out.println("Rankings");
        System.out.println(groningen.getName() + ": " + groningen.ranking());
        System.out.println(soccerPlayerTeam.getName() + ": " + soccerPlayerTeam.ranking());
        System.out.println(baseballPlayerTeam.getName() + ": " + baseballPlayerTeam.ranking());
        System.out.println(zwolle.getName() + ": " + zwolle.ranking());

        System.out.println(groningen.compareTo(zwolle));
    }
}
