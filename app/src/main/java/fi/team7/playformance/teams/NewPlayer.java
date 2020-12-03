package fi.team7.playformance.teams;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import fi.team7.playformance.R;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.Player;
import fi.team7.playformance.data.Team;
import fi.team7.playformance.data.TeamWithPlayers;

public class NewPlayer extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectTeam.EXTRA, 0);
        ((TextView) findViewById(R.id.teamName)).setText(db.teamDAO().getTeamByID(i).name);

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    //SOMETHING IS NOT WORKING INSIDE OF THIS FUNCTIONS.


//    public void buttonPress(View view) {
//        Bundle b = getIntent().getExtras();
//        long tid = b.getLong(SelectTeam.EXTRA, 0);
//        saveP(tid);
//    }
//
//    public void saveP(long tid) {
//
//        EditText editText1 = findViewById(R.id.txtNewPfirstName2);
//        EditText editText2 = findViewById(R.id.txtNewPlaststName2);
//        EditText editText3 = findViewById(R.id.txtNewPlayerNumber2);
//
//        String fName = editText1.getText().toString();
//        String lName = editText2.getText().toString();
//        int number = Integer.valueOf(editText3.getText().toString());
//
//        AppDB db = Room.databaseBuilder(getApplicationContext(),
//                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
//
//        Player p1 = new Player(0, fName, lName, number, tid);
//        db.playerDAO().createPlayer(p1);
//        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
//        for (TeamWithPlayers tw: twp) {
//            Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players);
//        }
//    }

}