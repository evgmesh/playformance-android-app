package fi.team7.playformance.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TeamDAO {
    @Query("Select * FROM team")
    public List<TeamWithPlayers> getTeamWithPlayers();

    @Insert
    public long createTeam(Team t);

}
