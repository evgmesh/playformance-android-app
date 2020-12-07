package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.Player;
import fi.team7.playformance.data.Team;
import fi.team7.playformance.data.TeamWithPlayers;
import fi.team7.playformance.notes.Note;

public class MainActivity extends AppCompatActivity {


    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to data base
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
        for (TeamWithPlayers tw: twp) {
            Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players );
        }
        findViewById(R.id.btn1).setOnClickListener(onClickListener);
    }


    // These methods can be used in future for UPDATE of teams and players

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

        // This is how I can change name of the team
//        t.name = "New name";

        db.teamDAO().deleteTeam(t);
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


}