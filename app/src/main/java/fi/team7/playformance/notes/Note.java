package fi.team7.playformance.notes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    public long nid;
    public String achievment;
    public String fail;
    public long playerID;

    public Note(long nid, String achievment, String fail, long playerID) {
        this.nid = nid;
        this.achievment = achievment;
        this.fail = fail;
        this.playerID = playerID;
    }

    @Override
    public String toString() {
        return "Note " +
                "achievment='" + achievment + '\'' +
                ", fail='" + fail + '\'';
    }

    public String getAchievment() {
        return achievment;
    }

    public String getFail() {
        return fail;
    }

}
