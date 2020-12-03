package fi.team7.playformance.teams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import fi.team7.playformance.R;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.TeamWithPlayers;

public class SelectionOfPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_of_player);

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();

        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectTeam.EXTRA, 0);
        ((TextView) findViewById(R.id.tvSelectedTeam)).setText(db.teamDAO().getTeamByID(i).name);
    }
}

//League.getInstance().getTeam(i).getName()