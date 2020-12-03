package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.Player;
import fi.team7.playformance.notes.FaultsScreen;
import fi.team7.playformance.notes.WinsScreen;
import fi.team7.playformance.teams.SelectTeam;
import fi.team7.playformance.teams.SelectionOfPlayer;
import fi.team7.playformance.teams.TeamCreationSC;

public class SelectionForPlayer extends AppCompatActivity {

    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_for_player);

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);
        ((TextView) findViewById(R.id.selectedPlayer)).setText(db.playerDAO().getPlayerByID(i).firstName);
    }

    public void chose(View view) {
        if (view.getId() == R.id.btnFaults) {
            Intent intent = new Intent(this, FaultsScreen.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnWins) {
            Intent intent = new Intent(this, WinsScreen.class);
            startActivity(intent);
        }
    }
}