package fi.team7.playformance.teams;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import fi.team7.playformance.R;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.notes.FaultsScreen;
import fi.team7.playformance.notes.WinsScreen;

public class SelectionForPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_for_player);

        // Reference to data base
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        //Getting player ID and display of his name in textView on the screen
        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);
        ((TextView) findViewById(R.id.selectedPlayer)).setText(db.playerDAO().getPlayerByID(i).firstName);
    }

    // User chose what to assign to player - wins or fails
    public void chose(View view) {
        if (view.getId() == R.id.btnFaults) {
            Intent intent = new Intent(this, FaultsScreen.class);
            Bundle c = getIntent().getExtras();
            long l = c.getLong(SelectionOfPlayer.EXTRA, 0);
            intent.putExtra(SelectionOfPlayer.EXTRA, l);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnWins) {
            Intent intent = new Intent(this, WinsScreen.class);
            Bundle c = getIntent().getExtras();
            long l = c.getLong(SelectionOfPlayer.EXTRA, 0);
            intent.putExtra(SelectionOfPlayer.EXTRA, l);
            startActivity(intent);
        }
    }
}