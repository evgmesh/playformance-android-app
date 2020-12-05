package fi.team7.playformance.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fi.team7.playformance.notes.Note;

@Database(entities = {Player.class, Team.class, Note.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract PlayerDAO playerDAO();
    public abstract TeamDAO teamDAO();
    public abstract NoteDAO noteDAO();
}
