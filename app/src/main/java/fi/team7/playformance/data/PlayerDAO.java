package fi.team7.playformance.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlayerDAO {
    @Query("SELECT * FROM player")
    public List<PlayerWithNotes> getPlayerWithNotes();

    @Query("SELECT * FROM player WHERE pid= :id")
    public Player getPlayerByID(long id);

    @Query("SELECT * FROM player WHERE teamID= :id")
    public List<Player> getPlayersByTeamID(long id);

    @Update
    public void updatePlayer(Player p);

    @Delete
    public void deletePlayer(Player p);

    @Insert
    public long createPlayer(Player p);

}
