package fi.team7.playformance.teams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fi.team7.playformance.data.Player;
import fi.team7.playformance.R;

public class TeamCreationSC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creation_s_c);


    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    /*public void saveTeam(View view) {

        EditText editText1 = findViewById(R.id.txtNewPfirstName);
        EditText editText2 = findViewById(R.id.txtNewPlaststName);
        EditText editText3 = findViewById(R.id.txtNewPlayerNumber);
        String fName = editText1.getText().toString();
        String lName = editText2.getText().toString();
        int number = Integer.valueOf(editText3.getText().toString());

        EditText editText8 = findViewById(R.id.txtTeamName);
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

     */
}
