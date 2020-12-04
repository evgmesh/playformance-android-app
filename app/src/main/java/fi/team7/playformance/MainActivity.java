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
            Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players);
        }
//        Log.d("PLAYDB", "Team: " + db.teamDAO().getTeamWithPlayers());

//        Player p1 = new Player(0, "Duncan", "McCloud", 03, 2);
//        db.playerDAO().createPlayer(p1);



        findViewById(R.id.btn1).setOnClickListener(onClickListener);
    }

    @Override
    protected void onPause() {
        Log.i("MAIN", "Main is on pause");
        super.onPause();
//        teamGeneration();
//        teamRemove(2);
//        teamRemove(4);
//        teamRemove(5);
//        teamRemove(6);
//        teamRemove(7);
//        teamRemove(8);
//        teamRemove(9);
    }



    @Override
    protected void onResume() {
        super.onResume();
    }



    public void teamGeneration(){
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Team team = new Team(0, "First from main");
        long tid = db.teamDAO().createTeam(team);
        Player p1 = new Player(0, "Ivan", "Ivanov", 4, tid);
        db.playerDAO().createPlayer(p1);
        Team team2 = new Team(0, "Second from main");
        long tid2 = db.teamDAO().createTeam(team2);
        Player p2 = new Player(0, "Doe", "John", 2, tid2);
        db.playerDAO().createPlayer(p2);
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


}