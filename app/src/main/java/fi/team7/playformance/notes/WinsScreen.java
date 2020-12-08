package fi.team7.playformance.notes;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import fi.team7.playformance.R;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.teams.SelectionOfPlayer;

public class WinsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wins_screen);
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);

        ((TextView) findViewById(R.id.playerWIN)).setText(db.playerDAO().getPlayerByID(i).firstName);
    }

    // Assignment of clicked achievment to the chosen player
    public void btnActionWIN(View view) {
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);

        Note n = null;
        if (view.getId() == R.id.bAce) {
            n = new Note(0, "ACE", "", i);
        } else if (view.getId() == R.id.bFTAttack) {
            n = new Note(0, "FIRST TIME ATTACK", "", i);
        } else if (view.getId() == R.id.bBlock) {
            n = new Note(0, "BLOCK", "", i);
        } else if (view.getId() == R.id.bTip) {
            n = new Note(0, "TIP", "", i);
        } else if (view.getId() == R.id.bSpike) {
            n = new Note(0, "DIAGONAL SPIKE", "", i);
        } else if (view.getId() == R.id.bSTAttack) {
            n = new Note(0, "SECOND TIME ATTACK", "", i);
        }
        db.noteDAO().createNote(n);
        Toast.makeText(WinsScreen.this, "Note added", Toast.LENGTH_SHORT).show();

        // TODO Two more buttons bOtherPlayerWin and bToFaultsWin should redirect user to WINs screen and to screen of player choose. Add it here
    }
}

