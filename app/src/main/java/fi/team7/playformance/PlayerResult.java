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

        // Reference to data base
        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        ((TextView) findViewById(R.id.playerName)).setText(db.playerDAO().getPlayerByID(i).firstName);


        int cntW1 = 0;      int cntF1 = 0;
        int cntW2 = 0;      int cntF2 = 0;
        int cntW3 = 0;      int cntF3 = 0;
        int cntW4 = 0;      int cntF4 = 0;
        int cntW5 = 0;      int cntF5 = 0;
        int cntW6 = 0;      int cntF6 = 0;

        List<Note> ln = db.noteDAO().getNotesByPlayerID(i);
        for (Note no: ln) {
            if(no.achievment.contentEquals("ACE"))
                cntW1+= 1;
            if(no.achievment.contentEquals("BLOCK"))
                cntW2+= 1;
            if(no.achievment.contentEquals("DIAGONAL SPIKE"))
                cntW3+= 1;
            if(no.achievment.contentEquals("FIRST TIME ATTACK"))
                cntW4+= 1;
            if(no.achievment.contentEquals("TIP"))
                cntW5+= 1;
            if(no.achievment.contentEquals("SECOND TIME ATTACK"))
                cntW6+= 1;
            if(no.fail.contentEquals("BAD BLOCK"))
                cntF1+= 1;
            if(no.fail.contentEquals("BAD POSITION"))
                cntF2+= 1;
            if(no.fail.contentEquals("BAD ATTACK"))
                cntF3+= 1;
            if(no.fail.contentEquals("MISS SERVE"))
                cntF4+= 1;
            if(no.fail.contentEquals("EXTRA TOUCH"))
                cntF5+= 1;
            if(no.fail.contentEquals("BAD RECEIVE"))
                cntF6+= 1;
        }
        ((TextView) findViewById(R.id.txtCounterW1)).setText(Integer.toString(cntW1));
        ((TextView) findViewById(R.id.txtCounterW2)).setText(Integer.toString(cntW2));
        ((TextView) findViewById(R.id.txtCounterW3)).setText(Integer.toString(cntW3));
        ((TextView) findViewById(R.id.txtCounterW4)).setText(Integer.toString(cntW4));
        ((TextView) findViewById(R.id.txtCounterW5)).setText(Integer.toString(cntW5));
        ((TextView) findViewById(R.id.txtCounterW6)).setText(Integer.toString(cntW6));
        ((TextView) findViewById(R.id.txtCounterF1)).setText(Integer.toString(cntF1));
        ((TextView) findViewById(R.id.txtCounterF2)).setText(Integer.toString(cntF2));
        ((TextView) findViewById(R.id.txtCounterF3)).setText(Integer.toString(cntF3));
        ((TextView) findViewById(R.id.txtCounterF4)).setText(Integer.toString(cntF4));
        ((TextView) findViewById(R.id.txtCounterF5)).setText(Integer.toString(cntF5));
        ((TextView) findViewById(R.id.txtCounterF6)).setText(Integer.toString(cntF6));



//        String temp2 = "Fails: \n";
//        List<Note> ln2 = db.noteDAO().getNotesByPlayerID(i);
////        Log.d("NONON", "Player with id " + i + " has following fails");
//        for (Note no2: ln2) {
//            if(no2.fail.contentEquals(""))
//                continue;
//            temp2 += no2.fail + "\n";
//        }
//        ((TextView) findViewById(R.id.txtFail)).setText(temp2);





    }
}