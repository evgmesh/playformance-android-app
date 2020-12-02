package fi.team7.playformance.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Player {
    @PrimaryKey(autoGenerate = true)
    public long pid;
    public String firstName;
    public String lastName;
    public long teamID;

    public Player(long pid, String firstName, String lastName, long teamID) {
        this.pid = pid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamID = teamID;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pid=" + pid +
                ", firstName='" + firstName + '\'' +
                ", lasstName='" + lastName + '\'' +
                '}';
    }
}
