package fi.team7.playformance.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TeamDAO {
    @Query("SELECT * FROM team")
    public List<TeamWithPlayers> getTeamWithPlayers();

    @Query("SELECT * FROM team WHERE tid= :id")
    public Team getTeamByID(long id);

    @Delete
    public void deleteTeam(Team t);

    @Update
    public void updateTeam(Team t);

    @Insert
    public long createTeam(Team t);

}
