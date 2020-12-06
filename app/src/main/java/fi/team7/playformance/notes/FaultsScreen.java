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

    public void btnActionFAIL(View view) {
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);

        if(view.getId() == R.id.bBblock) {
            Note n = new Note(0, "", "BAD BLOCK", i);
            db.noteDAO().createNote(n);
            Toast.makeText(FaultsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.bMserve) {
            Note n = new Note(0, "", "MISS SERVE", i);
            db.noteDAO().createNote(n);
            Toast.makeText(FaultsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.bBposition) {
            Note n = new Note(0, "", "BAD POSITION", i);
            db.noteDAO().createNote(n);
            Toast.makeText(FaultsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.bBtouch) {
            Note n = new Note(0, "", "EXTRA TOUCH", i);
            db.noteDAO().createNote(n);
            Toast.makeText(FaultsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.bBattack) {
            Note n = new Note(0, "", "BAD ATTACK", i);
            db.noteDAO().createNote(n);
            Toast.makeText(FaultsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.bBreceive) {
            Note n = new Note(0, "", "BAD RECEIVE", i);
            db.noteDAO().createNote(n);
            Toast.makeText(FaultsScreen.this, "Note added", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.bOtherPlayerFail) {
            Intent intent = new Intent(this, SelectionOfPlayer.class);
            startActivity(intent);
        } else if (view.getId() == R.id.bToWinsFail) {
            Intent intent = new Intent(this, WinsScreen.class);
            startActivity(intent);
        }
    }
}