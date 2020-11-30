package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(KEY_SHARED, Activity.MODE_PRIVATE);

        findViewById(R.id.btn1).setOnClickListener(onClickListener);

        // Reference to singleton League
        League league = League.getInstance();
//        Player player = new Player("Gulshan", "Kundra", 3);
//
//        league.getTeam(0).addPlayer(player);
//        Note note = new Note("Bad recieve", false);
//        league.getTeam(0).getPlayer(0).addNote(note);

//        Coach coach = new Coach("John", "Steven", "john.ste", "43422223432");
//        Team team = new Team(coach, "Kiri");
//        team.addPlayer(player);
//        Coach coach2 = new Coach("John2", "Steven2", "john.ste2", "242352352");
//        Player player2 = new Player("Shon2", "Whilson2", 2);
//        player2.addNote(new Note("Bad recieve", true));
//        player2.addNote(new Note("Good attack", false));
//        Team team2 = new Team(coach, "Kiri2");
//        team2.addPlayer(player2);
//        league.addTeam(team2);

        TextView tv = findViewById(R.id.textView);
//        String temp = league.getTeam(0) + "\n" + "\n" + "\n";
        String temp = "";

//        temp += league.getTeam(0).getPlayer(0) + " his number is: "
//                + league.getTeam(0).getPlayer(0).getNumber();
//        temp += league.getTeam(1) + "\n";
//        temp += "\n team2" +  team2.getCoach().toString() + "\n";
//        temp += team2.getAllPlayers();
        temp += "all teams: " + loadList();
        tv.setText(temp);
        loadList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveTeams();
    }

    private void saveTeams(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(League.getInstance().getAllTeams());
        editor.putString(KEY_TEAMS, json);
        editor.apply();
        }
    private List<Team> loadList() {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_TEAMS, null);
        TypeToken<List<Team>> token = new TypeToken<List<Team>>() {};
        List<Team> teams = gson.fromJson(json, token.getType());
        return teams;
    }

}