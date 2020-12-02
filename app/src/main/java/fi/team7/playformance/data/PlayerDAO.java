package fi.team7.playformance.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlayerDAO {
    @Query("Select * FROM player")
    public List<Player> getPlayer();

    @Query("Select * FROM player WHERE pid= :id")
    public Player getPlayerByID(long id);

    @Insert
    public long createPlayer(Player p);

}
