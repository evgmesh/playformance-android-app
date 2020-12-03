package fi.team7.playformance.teams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import java.util.List;

import fi.team7.playformance.SecondActivity;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.Player;
import fi.team7.playformance.R;
import fi.team7.playformance.data.Team;
import fi.team7.playformance.data.TeamWithPlayers;



public class TeamCreationSC extends AppCompatActivity {

    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, SelectTeam.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creation_s_c);
        findViewById(R.id.btnSubmit).setOnClickListener(onClickListener);


//        AppDB db = Room.databaseBuilder(getApplicationContext(),
//                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
//        Team team = new Team(0, "Kiri");
//        long tid = db.teamDAO().createTeam(team);
//        Player p1 = new Player(0, "John", "Test", 4, tid);
//        db.playerDAO().createPlayer(p1);
//        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
//        for (TeamWithPlayers tw: twp) {
//        Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players);
//        }


    }

    @Override
    protected void onPause() {
        super.onPause();

    }
    private void saveTeamPlayer(){

    }


    public void saveTeam(View view) {

        EditText editText1 = findViewById(R.id.txtNewPfirstName);
        EditText editText2 = findViewById(R.id.txtNewPlaststName);
        EditText editText3 = findViewById(R.id.txtNewPlayerNumber);
        EditText editText4 = findViewById(R.id.txtTeamName);

        String fName = editText1.getText().toString();
        String lName = editText2.getText().toString();
        int number = Integer.valueOf(editText3.getText().toString());
        String teamName = editText4.getText().toString();

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Team team = new Team(0, teamName);
        long tid = db.teamDAO().createTeam(team);
        Player p1 = new Player(0, fName, lName, number, tid);
        db.playerDAO().createPlayer(p1);
        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
        for (TeamWithPlayers tw: twp) {
            Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players);
        }

    }

/*
    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(League.getInstance().getAllTeams());
        editor.putString(KEY_TEAMS, json);
        editor.apply();
    }

    private void loadList(League league) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_TEAMS, null);
        TypeToken<List<Team>> token = new TypeToken<List<Team>>() {
        };
        List<Team> teams = gson.fromJson(json, token.getType());
        if (teams != null) {
            league.addAllTeams(teams);
        }
    }

     */
}
