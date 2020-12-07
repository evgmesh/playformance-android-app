package fi.team7.playformance.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import fi.team7.playformance.R;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.teams.SelectionOfPlayer;

public class WinsScreen extends AppCompatActivity {
//    private Button ace, ftAttack, block, tip, spike, stAttack, otherPlayer, faults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wins_screen);
//        ace = findViewById(R.id.bAce);
//        ftAttack = findViewById(R.id.bFTAttack);
//        block = findViewById(R.id.bBlock);
//        tip = findViewById(R.id.bTip);
//        spike = findViewById(R.id.bSpike);
//        stAttack = findViewById(R.id.bSTAttack);

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);

        ((TextView) findViewById(R.id.playerWIN)).setText(db.playerDAO().getPlayerByID(i).firstName);
    }


    public void btnActionWIN(View view) {
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);

//        if (view.getId() == R.id.bOtherPlayerWin) {
//            Intent intent = new Intent(this, SelectionOfPlayer.class);
//            startActivity(intent);
//        } else if (view.getId() == R.id.bToFaultsWin) {
//            Intent intent = new Intent(this, FaultsScreen.class);
//            startActivity(intent);
//         }
        if (view.getId() == R.id.bAce) {
            Note n = new Note(0, "ACE", "", i);
            db.noteDAO().createNote(n);
            Toast.makeText(WinsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.bFTAttack) {
            Note n = new Note(0, "FIRST TIME ATTACK", "", i);
            db.noteDAO().createNote(n);
            Toast.makeText(WinsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.bBlock) {
            Note n = new Note(0, "BLOCK", "", i);
            db.noteDAO().createNote(n);
            Toast.makeText(WinsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.bTip) {
            Note n = new Note(0, "TIP", "", i);
            db.noteDAO().createNote(n);
            Toast.makeText(WinsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.bSpike) {
            Note n = new Note(0, "DIAGONAL SPIKE", "", i);
            db.noteDAO().createNote(n);
            Toast.makeText(WinsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.bSTAttack) {
            Note n = new Note(0, "SECOND TIME ATTACK", "", i);
            db.noteDAO().createNote(n);
            Toast.makeText(WinsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        }
    }
}

