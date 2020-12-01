package Teams;

import java.util.ArrayList;
import java.util.List;

public class League {
    private static final League leagueInstance = new League();
//    private static final String KEY_SHARED = "shared_pref";
//    private static final String KEY_TEAMS = "shared_pref";


    public static League getInstance(){
        return leagueInstance;
    }

    private List<Team> teams; // List holds original order of teams

    private League(){
        this.teams = new ArrayList<>();
//        this.teams.add(new Team(coach, "Kiri"));
//        this.teams.add(new Team(coach2, "JyskeM5"));
    }

//    Coach coach = new Coach("Matthieu", "Molinier",
//            "matthieu.molinier@gmail.com", "0404135521");
//    Coach coach2 = new Coach("Juha", "Miettinen",
//            "juha.o.miettinen@gmail.com", "0405860935");

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

    public void addAllTeams(List<Team> teams){
        this.teams = teams;
    }


}
