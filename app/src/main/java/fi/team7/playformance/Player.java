package fi.team7.playformance;

import java.util.ArrayList;
import java.util.List;

public class Player extends Person{

    //Only one instance of this class is created automatically
    //when the class is loaded
    private int number;
    private List<Note> notes = new ArrayList<Note>();

    public Player(String firstName, String lastName, int number) {
        super(firstName, lastName);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getNotes(){
        String temp = "Notes:\n";
        for (Note note: notes) {
            temp += note.toString() + "\n";
        }
        return temp;
    }

    public void addNote (Note note){
        this.notes.add(note);
    }

    @Override
    public String toString(){
        return super.toString() + getNotes();
    }

}
