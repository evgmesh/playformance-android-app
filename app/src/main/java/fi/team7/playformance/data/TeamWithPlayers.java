package fi.team7.playformance.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class TeamWithPlayers {
    @Embedded
    public Team team;
    @Relation(parentColumn = "tid", entityColumn = "teamID")
    public List<Player> players;

    @Override
    public String toString() {
        return team.name;
    }
}
