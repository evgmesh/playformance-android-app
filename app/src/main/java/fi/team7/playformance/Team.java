package fi.team7.playformance;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private Coach coach;
    private String name;
    private List<Player> players = new ArrayList<>();

    public Team(Coach coach, String name) {
        this.coach = coach;
        this.name = name;
    }
    // A method to add Team members
    // A method to change coach if needed
    // Getters


    public Coach getCoach() {
        return coach;
    }
}

