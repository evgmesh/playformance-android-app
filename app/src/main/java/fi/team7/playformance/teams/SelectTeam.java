package fi.team7.playformance.teams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fi.team7.playformance.R;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.TeamWithPlayers;

public class SelectTeam extends AppCompatActivity {

    public final static String EXTRA = "fi.team7.playformance";

    public final static String TAG = "TEAMLIST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_team);

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();

        ListView listView = findViewById(R.id.lvTeams);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, twp));
        for (TeamWithPlayers tw: twp) {
            Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players);
        }
        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Log.d(TAG, "onItemClick(" + position + ")");
            Intent nextActivity = new Intent(SelectTeam.this, SelectionOfPlayer.class);
            nextActivity.putExtra(EXTRA, position);
            startActivity(nextActivity);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}