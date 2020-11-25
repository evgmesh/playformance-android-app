package fi.team7.playformance;

import java.util.ArrayList;
import java.util.List;

public class League {
    private static final League leagueInstance = new League();

    public static League getInstance(){
        return leagueInstance;
    }

    private List<Team> teams; // List holds original order of teams

    Coach coach = new Coach("Matthieu", "Molinier", "matthieu.molinier@gmail.com", "43422223432");
    private League(){
        this.teams = new ArrayList<>();
        this.teams.add(new Team(coach, "Kiri"));
    }


    // This I'll use in Existing teams activity
    public List<Team> getAllTeams(){
        return this.teams;
    }

    /**
     *
     * @param indexOfaTeam
     * @return
     */
    public Team getTeam(int indexOfaTeam){
        return  this.teams.get(indexOfaTeam);
    }

    public void addTeam(Team team){
        this.teams.add(team);
    }


    // Here I need to add methods to store List in shared prefferences
    // Also I need to add method to read this List
}
