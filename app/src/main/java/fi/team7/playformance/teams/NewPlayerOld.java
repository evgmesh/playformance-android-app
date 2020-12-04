package fi.team7.playformance.teams;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import fi.team7.playformance.R;
import fi.team7.playformance.UpdatePlayers;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.Player;

public class NewPlayerOld extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static AppDB appDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);
        fragmentManager = getSupportFragmentManager();
        appDB = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();


        if(findViewById(R.id.fragment_conteiner) != null) {
            if(savedInstanceState !=null) {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_conteiner, new UpdatePlayers()).commit();
        }

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

//        Bundle b = getIntent().getExtras();
//        long i = b.getLong(SelectTeam.EXTRA, 0);
//        ((TextView) findViewById(R.id.teamName)).setText(db.teamDAO().getTeamByID(i).name);

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
////        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
////        for (TeamWithPlayers tw: twp) {
////            Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players);
////        }
//
//    }

}