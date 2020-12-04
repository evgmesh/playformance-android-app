package fi.team7.playformance.teams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import fi.team7.playformance.R;
import fi.team7.playformance.SelectionForPlayer;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.Player;
import fi.team7.playformance.data.TeamWithPlayers;

public class SelectionOfPlayer extends AppCompatActivity {

    public final static String EXTRA = "fi.team7.playformance";
    public final static String TAG = "PLAYERLIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_of_player);

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();

        Bundle b = getIntent().getExtras();
        long i = b.getLong(EXTRA, 0);
        ((TextView) findViewById(R.id.tvSelectedTeam)).setText(db.teamDAO().getTeamByID(i).name);


        List<Player> lvp = db.playerDAO().getPlayersByTeamID(i);
        ListView listView = findViewById(R.id.lvPlayers);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lvp));


        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Player pl = (Player) parent.getItemAtPosition(position);
            Log.d(TAG, "onItemClick(" + pl + ")");
            Intent nextActivity = new Intent(this, SelectionForPlayer.class);
            nextActivity.putExtra(EXTRA, pl.pid);
            startActivity(nextActivity);
        });
    }

    public void buttonPressed(View view) {
        Intent intent = new Intent(this, NewPlayerOld.class);
        Bundle c = getIntent().getExtras();
        long i = c.getLong(EXTRA, 0);
        intent.putExtra(EXTRA, i);
        startActivity(intent);
    }
}

//League.getInstance().getTeam(i).getName()