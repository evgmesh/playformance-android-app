package fi.team7.playformance.data;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import fi.team7.playformance.notes.Note;

public class PlayerWithNotes {
    @Embedded
    public Player player;
    @Relation(parentColumn = "pid", entityColumn = "playerID")
    public List<Note> notes;

    public List<Note> getNotes() {
        return notes;
    }

    @NonNull
    @Override
    public String toString() {
        return player.firstName;
    }
}
