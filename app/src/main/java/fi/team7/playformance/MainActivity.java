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
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

//        deletePlayer();


        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
        for (TeamWithPlayers tw: twp) {
            Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players );
        }
//        Log.d("PLAYDB", "Team: " + db.teamDAO().getTeamWithPlayers());




        findViewById(R.id.btn1).setOnClickListener(onClickListener);
    }

    @Override
    protected void onPause() {
        Log.i("MAIN", "Main is on pause");
        super.onPause();
        testTeamGeneration();
        testTeamGeneration();
        testTeamGeneration();
        testTeamGeneration();
        testTeamGeneration();
        testTeamGeneration();
//        teamRemove(4);
    }



    @Override
    protected void onResume() {
        super.onResume();
    }



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
//        t.name = "New name";
        db.teamDAO().deleteTeam(t);
    }

    public void deletePlayer(int pid){
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Player p = db.playerDAO().getPlayerByID(pid);
                db.playerDAO().deletePlayer(p);
    }

    // THINK ABOUT THIS

//    public void deleteNote(int pid){
//        AppDB db = Room.databaseBuilder(getApplicationContext(),
//                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
//        Player p = db.playerDAO().getPlayerByID(pid);
//        db.playerDAO().getPlayerByID().note.;
//    }


}