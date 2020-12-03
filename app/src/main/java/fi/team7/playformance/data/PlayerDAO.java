package fi.team7.playformance.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlayerDAO {
    @Query("SELECT * FROM player")
    public List<Player> getPlayer();

    @Query("SELECT * FROM player WHERE pid= :id")
    public Player getPlayerByID(long id);

    @Delete
    public void deletePlayer(Player p);

    @Insert
    public long createPlayer(Player p);

}
