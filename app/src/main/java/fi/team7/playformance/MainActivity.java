package fi.team7.playformance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.Player;
import fi.team7.playformance.data.Team;

public class MainActivity extends AppCompatActivity {

    // Starts next activity
    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(onClickListener);
    }
}



/*  For debug process

        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
        for (TeamWithPlayers tw: twp) {
            Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players );
        }

            Note n = new Note(0, "Fast attack", "Poor recieve", 1);
        Note n1 = new Note(0, "Sleep well", "Dring coffe", 1);
        db.noteDAO().createNote(n);
        db.noteDAO().createNote(n1);
        Log.d("PLNOT", db.noteDAO().getNotesByPlayerID(i).toString() + db.playerDAO().getPlayer());


        Log.d("NOTEST", "Player " + db.playerDAO().getPlayerByID(i).firstName
                + " with notes: " + db.noteDAO().getNotesByPlayerID(i).toString());
 */

    // These methods can be used in future for UPDATE of teams and players

/*
    public void testTeamGeneration(){
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Team team = new Team(0, "Generataed from main");
        long tid = db.teamDAO().createTeam(team);
        Player p1 = new Player(0, "Ivan", "Ivanov", 7, tid);
        db.playerDAO().createPlayer(p1);
    }
    public void teamRemove(int tid){
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Team t = db.teamDAO().getTeamByID(tid);
        db.teamDAO().deleteTeam(t);

        // This is how I can change name of the team
//        t.name = "New name";
    }

    public void deletePlayer(int pid){
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Player p = db.playerDAO().getPlayerByID(pid);
        db.playerDAO().deletePlayer(p);
    }

    public void deleteNote(int pid){
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Player p = db.playerDAO().getPlayerByID(pid);
        db.playerDAO().getPlayerByID(pid).note.achievment.contentEquals("something");
    }
    */