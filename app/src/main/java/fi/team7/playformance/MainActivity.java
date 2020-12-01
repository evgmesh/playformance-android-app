package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_SHARED = "shared_pref";
    private static final String KEY_TEAMS = "shared_pref_teams";
    private SharedPreferences sharedPreferences;
    Gson gson = new Gson();
    League league = League.getInstance();
    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Coach coach = new Coach("Matthieu", "Molinier",
//                "matthieu.molinier@gmail.com", "0404135521");
//        Coach coach2 = new Coach("Juha", "Miettinen",
//                "juha.o.miettinen@gmail.com", "0405860935");
//        Team team1 = new Team(coach, "Kiri");
//        Team team2 = new Team(coach2, "JyskeM5");
//        league.addTeam(team1);
//        league.addTeam(team2);
    }

    @Override
    protected void onPause() {
        Log.i("MAIN", "Main is on pause");
        super.onPause();
        saveTeams();
    }
// Saving to sharedPreferences and converting to gson
    private void saveTeams(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String json = gson.toJson(League.getInstance().getAllTeams());
        editor.putString(KEY_TEAMS, json);
        editor.apply();
        }
    private void loadList(League league) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);
        String json = sharedPreferences.getString(KEY_TEAMS, null);
        TypeToken<List<Team>> token = new TypeToken<List<Team>>() {};
        List<Team> teams = gson.fromJson(json, token.getType());
        if (teams != null) {
        league.addAllTeams(teams);
        }
    }



    @Override
    protected void onResume() {
        super.onResume();

        sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);

        findViewById(R.id.btn1).setOnClickListener(onClickListener);

        // Reference to singleton League


        loadList(league);

        TextView tv = findViewById(R.id.textView);
//        String temp = league.getTeam(0) + "\n" + "\n" + "\n";
        String temp = "";


        temp += "all teams: ";
        for (Team team: league.getAllTeams()) {
            temp += team + "\n";
        }
        tv.setText(temp);
    }}