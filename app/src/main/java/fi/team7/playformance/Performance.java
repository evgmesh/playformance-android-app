package fi.team7.playformance;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.TeamWithPlayers;
import fi.team7.playformance.teams.SelectTeam;

public class Performance extends AppCompatActivity {


    public final static String EXTRA = "fi.team7.playformance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);


    // Reference to data base
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