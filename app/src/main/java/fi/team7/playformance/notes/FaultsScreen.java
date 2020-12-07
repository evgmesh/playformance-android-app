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

public class FaultsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faults_sreen);

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);

        ((TextView) findViewById(R.id.playerFAIL)).setText(db.playerDAO().getPlayerByID(i).firstName);
    }

    // Assignment of different fails to a chosen player. Later it can be found in section Performance

    public void btnActionFAIL(View view) {
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);

        Note n = null;
        if (view.getId() == R.id.bBblock) {
            n = new Note(0, "", "BAD BLOCK", i);
        } else if (view.getId() == R.id.bMserve) {
            n = new Note(0, "", "MISS SERVE", i);
        } else if (view.getId() == R.id.bBposition) {
            n = new Note(0, "", "BAD POSITION", i);
        } else if (view.getId() == R.id.bBtouch) {
            n = new Note(0, "", "EXTRA TOUCH", i);
        } else if (view.getId() == R.id.bBattack) {
            n = new Note(0, "", "BAD ATTACK", i);
        } else if (view.getId() == R.id.bBreceive) {
            n = new Note(0, "", "BAD RECEIVE", i);
        }
        db.noteDAO().createNote(n);
        Toast.makeText(FaultsScreen.this, "Note added", Toast.LENGTH_SHORT).show();

        // TODO Two more buttons bOtherPlayerFail and bToWinsFail should redirect user to WINs screen and to screen of player choose. Add it here
    }
}