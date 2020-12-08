package fi.team7.playformance.teams;

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

import fi.team7.playformance.R;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.TeamWithPlayers;

public class SelectTeam extends AppCompatActivity {

    public final static String EXTRA = "fi.team7.playformance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_team);

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
        ListView listView = findViewById(R.id.lvPlayers);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, twp));

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            TeamWithPlayers tv = (TeamWithPlayers) parent.getItemAtPosition(position);
            Intent nextActivity = new Intent(SelectTeam.this, SelectionOfPlayer.class);
            nextActivity.putExtra(EXTRA, tv.team.tid);
            startActivity(nextActivity);
        });
    }
}