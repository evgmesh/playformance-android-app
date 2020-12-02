package fi.team7.playformance.teams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fi.team7.playformance.R;

public class SelectTeam extends AppCompatActivity {

    private static final String KEY_TEAMS = "shared_pref_teams";
    public final static String EXTRA = "fi.team7.playformance";
    private SharedPreferences sharedPreferences;

    public final static String TAG = "TEAMLIST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_team);

        ListView listView = findViewById(R.id.lvTeams);
//        listView.setAdapter(new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, );
//        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
//            Log.d(TAG, "onItemClick(" + position + ")");
//            Intent nextActivity = new Intent(SelectTeam.this, SelectionOfPlayer.class);
//            nextActivity.putExtra(EXTRA, position);
//            startActivity(nextActivity);
//        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reference to singleton League
//        League league = League.getInstance();
//        loadList(league);
//        sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);
//
//        loadList(league);
//        TextView tv = findViewById(R.id.welcomeTV3);
//        String temp = "";
//        temp += "all teams: \n";
//        for (Team team: league.getAllTeams()) {
//            temp += team + "\n";
//        }
//        tv.setText(temp);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /*private void saveTeams(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(League.getInstance().getAllTeams());
        editor.putString(KEY_TEAMS, json);
        editor.apply();
    }
    // Convertion from gson to sharedPreferences and retrieve of this data
    private void loadList(League league) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_TEAMS, null);
        TypeToken<List<Team>> token = new TypeToken<List<Team>>() {};
        List<Team> teams = gson.fromJson(json, token.getType());
        if (teams != null) {
            league.addAllTeams(teams);
        }
    }
    */

}