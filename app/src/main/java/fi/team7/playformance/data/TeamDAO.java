package fi.team7.playformance.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/*
DAO for entity Team
Provides all needed queryes, or method for elements of Team
 */
@Dao
public interface TeamDAO {
    //List of all teams
    @Query("SELECT * FROM team")
    public List<TeamWithPlayers> getTeamWithPlayers();

    //Seclection of team with known ID
    @Query("SELECT * FROM team WHERE tid= :id")
    public Team getTeamByID(long id);

    @Delete
    public void deleteTeam(Team t);

    // New name for team
    @Update
    public void updateTeam(Team t);

    // New team creation
    @Insert
    public long createTeam(Team t);

}
