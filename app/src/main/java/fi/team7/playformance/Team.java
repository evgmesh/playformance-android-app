package fi.team7.playformance;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private Coach coach;
    private String name;
    private List<Player> players = new ArrayList<Player>();

    public Team(Coach coach, String name) {
        this.coach = coach;
        this.name = name;
    }
    // A method to add Team members
    private Team(){
        this.players.add(new Player("Ivan", "Ivanov", 1));
    }

    // A method to change coach if needed
    public void addCoach (Coach coach){
        this.coach = coach;
    }
    // Getters


    public Player getPlayers(int indexOfaPlayer) {
        return players.get(indexOfaPlayer);
    }


    public void addPlayer(Player player){
        this.players.add(player);
    }

    public String getAllPlayers() {
        String temp = "";
        for (Player player: players) {
            temp += player.toString() + "\n";
        }
        return temp;
    }

    public Coach getCoach() {
        return coach;
    }

}

