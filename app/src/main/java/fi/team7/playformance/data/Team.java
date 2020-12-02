package fi.team7.playformance.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Team {
    @PrimaryKey(autoGenerate = true)
    public long tid;
    public String name;



    public Team(long tid, String name) {
        this.tid = tid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                '}';
    }
}
