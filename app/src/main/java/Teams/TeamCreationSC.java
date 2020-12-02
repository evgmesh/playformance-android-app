package Teams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import People.Player;
import fi.team7.playformance.Coach;
import fi.team7.playformance.R;

public class TeamCreationSC extends AppCompatActivity {
    private static final String KEY_TEAMS = "shared_pref_teams";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creation_s_c);


    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();

    }

    public void saveTeam(View view) {
        League league = League.getInstance();
        loadList(league);

        EditText editText1 = findViewById(R.id.txtNewPfirstName);
        EditText editText2 = findViewById(R.id.txtNewPlaststName);
        EditText editText3 = findViewById(R.id.txtNewPlayerNumber);
        String fName = editText1.getText().toString();
        String lName = editText2.getText().toString();
        int number = Integer.valueOf(editText3.getText().toString());

        Player player = new Player(fName, lName, number);
        league.getTeam(0).addPlayer(player);

        EditText editText4 = findViewById(R.id.txtCoachFname);
        EditText editText5 = findViewById(R.id.txtCoachLname);
        EditText editText6 = findViewById(R.id.txtCoachEmail);
        EditText editText7 = findViewById(R.id.txtCoachPnumber);

        EditText editText8 = findViewById(R.id.txtTeamName);

        String CoachfName = editText4.getText().toString();
        String CoachlName = editText5.getText().toString();
        String CoachEmail = editText6.getText().toString();
        String CoachPhone = editText7.getText().toString();

        String newTeam = editText8.getText().toString();

        Coach coach = new Coach(CoachfName, CoachlName, CoachEmail, CoachPhone);
        Team team = new Team(coach, newTeam);
        league.addTeam(team);

        String temp = "";
        temp += "new team: \n" + league.getTeam(2);
//
//////        for (Player player1: league.getTeam(0).getPlayer(0)) {
//////            temp += player + "\n";
//////        }
        Log.i("UNIQ", temp);
    }


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
}
