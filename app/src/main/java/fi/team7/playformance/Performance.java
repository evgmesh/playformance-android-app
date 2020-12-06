package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.TeamWithPlayers;
import fi.team7.playformance.teams.SelectTeam;
import fi.team7.playformance.teams.SelectionOfPlayer;

public class Performance extends AppCompatActivity {


    public final static String EXTRA = "fi.team7.playformance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);



        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();


        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();

        ListView listView = findViewById(R.id.listWithTeams);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, twp));

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            TeamWithPlayers tv = (TeamWithPlayers) parent.getItemAtPosition(position);
            Log.d(SelectTeam.TAG, "onItemClick(" + tv + ")");
            Intent nextActivity = new Intent(Performance.this, PerformancePlayers.class);
            nextActivity.putExtra(EXTRA, tv.team.tid);
            startActivity(nextActivity);
        });
    }
}

//    AppDB db = Room.databaseBuilder(getApplicationContext(),
//            AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
//
//    Bundle b = getIntent().getExtras();
//    long i = b.getLong(Performance.EXTRA, 0);
//        ((TextView) findViewById(R.id.txtPlayersTitle)).setText(db.teamDAO().getTeamByID(i).name);
//
//                List<Player> lvp = db.playerDAO().getPlayersByTeamID(i);
//        ListView listView = findViewById(R.id.listWithPlayers);
//        listView.setAdapter(new ArrayAdapter<>(this,
//        android.R.layout.simple_list_item_1, lvp));