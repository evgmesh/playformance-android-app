package fi.team7.playformance.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fi.team7.playformance.notes.Note;

 // DAO gives methods for data base update
@Dao
public interface NoteDAO {
    @Query("SELECT * FROM note")
    public List<Note> getNote();

    //
    @Query("select * from note where playerID=:id")
    public List<Note> getNotesByPlayerID(long id);

    @Delete
    public void deleteNote(Note n);

    // New note creation
    @Insert
    public long createNote(Note n);
}
