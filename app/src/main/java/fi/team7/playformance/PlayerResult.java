package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.PlayerWithNotes;
import fi.team7.playformance.data.TeamWithPlayers;
import fi.team7.playformance.notes.Note;
import fi.team7.playformance.teams.SelectionOfPlayer;

public class PlayerResult extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_result);


        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        ((TextView) findViewById(R.id.playerName)).setText(db.playerDAO().getPlayerByID(i).firstName);

        String temp = "Achievements: \n";
        List<Note> ln = db.noteDAO().getNotesByPlayerID(i);
//        Log.d("NONON", "Player with id " + i + " has following achie");
        for (Note no: ln) {
            if(no.achievment == ""){
                continue;
            }
            temp += no.achievment + "\n";
        }
        ((TextView) findViewById(R.id.txtAchie)).setText(temp);

        String temp2 = "Fails: \n";
        List<Note> ln2 = db.noteDAO().getNotesByPlayerID(i);
//        Log.d("NONON", "Player with id " + i + " has following fails");
        for (Note no2: ln2) {
            temp += no2.fail + "\n";
        }
        ((TextView) findViewById(R.id.txtFail)).setText(temp2);





    }
}