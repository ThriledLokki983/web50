package com.company;

public class Main {

    public static void main(String[] args) {

        League<Team<FootballPlayer>> footballLeague = new League<>("GPL");

        FootballPlayer nanayaw = new FootballPlayer("Nana Yaw");
        FootballPlayer joe = new FootballPlayer("Joe");
        SoccerPlayer frank = new SoccerPlayer("Frank");
        BaseballPlayer gideon = new BaseballPlayer("Gideon");

        Team<FootballPlayer> groningen = new Team<>("FC Groningen");
        Team<FootballPlayer> zwolle = new Team<>("PEC Zwolle");
        Team<FootballPlayer> kotoko = new Team<>("Asante Kotoko");
        Team<FootballPlayer> hearts = new Team<>("Hearts of Oak");
        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Chicago Cubs");
        Team<SoccerPlayer> soccerPlayerTeam = new Team<>("Red Bulls FC");

        groningen.matchResult(zwolle, 3, 1);
        groningen.matchResult(hearts, 3, 2);
        groningen.matchResult(kotoko, 1, 4);
    /**   soccerPlayerTeam.matchResult(groningen, 1, 5);
        soccerPlayerTeam.matchResult(groningen, 2, 2);
        baseballPlayerTeam.matchResult(soccerPlayerTeam, 5,6);
        baseballPlayerTeam.matchResult(groningen, 3, 1);
     **/
        zwolle.matchResult(groningen, 3, 2);
        zwolle.matchResult(hearts, 3, 1);
        zwolle.matchResult(kotoko, 4, 1);

        hearts.matchResult(groningen, 2, 1);
        hearts.matchResult(zwolle, 3,1);
        hearts.matchResult(kotoko, 1, 4);

        kotoko.matchResult(groningen, 4, 2);
        kotoko.matchResult(zwolle, 3, 1);
        kotoko.matchResult(hearts, 4, 3);

        zwolle.addPlayer(nanayaw);
        groningen.addPlayer(joe);
        baseballPlayerTeam.addPlayer(gideon);
        soccerPlayerTeam.addPlayer(frank);

        footballLeague.add(groningen);
        footballLeague.add(zwolle);
        footballLeague.add(kotoko);
        footballLeague.add(hearts);
        //footballLeague.add(baseballPlayerTeam);
        footballLeague.showLeagueTable();



    }
}
