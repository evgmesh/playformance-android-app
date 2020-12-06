package fi.team7.playformance.data;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import fi.team7.playformance.notes.Note;

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

    @Embedded public Note note;

    @Override
    public String toString() {
        return  firstName + " " + lastName + ", pid=" + pid
        + ", " + " number= " + number;
    }
}
