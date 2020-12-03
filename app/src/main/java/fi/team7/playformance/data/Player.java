package fi.team7.playformance.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Player {
    @PrimaryKey(autoGenerate = true)
    public long pid;
    public String firstName;
    public String lastName;
    public int number;
    public long teamID;

    public Player(long pid, String firstName, String lastName, int number, long teamID) {
        this.pid = pid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.teamID = teamID;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pid=" + pid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + ", " +
                " number='" + number + '\'' +
        '}';
    }
}
