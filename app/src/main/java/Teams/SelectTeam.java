package Teams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fi.team7.playformance.Coach;
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
        League league = League.getInstance();

//        Coach coach = new Coach("Matthieu", "Molinier",
//                "matthieu.molinier@gmail.com", "0404135521");
//        Coach coach2 = new Coach("Juha", "Miettinen",
//                "juha.o.miettinen@gmail.com", "0405860935");
//        Team team1 = new Team(coach, "Kiri");
//        Team team2 = new Team(coach2, "JyskeM5");
//        league.addTeam(team1);
//        league.addTeam(team2);

        loadList(league);
        sharedPreferences = getSharedPreferences(KEY_TEAMS, MODE_PRIVATE);

        loadList(league);
        String temp = "";
        temp += "all teams: \n";
        for (Team team: league.getAllTeams()) {
            temp += team + "\n";
        }
        ListView listView = findViewById(R.id.lvTeams);
        listView.setAdapter(new ArrayAdapter<Team>(this,
                android.R.layout.simple_list_item_1, League.getInstance().getAllTeams()));

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
        saveTeams();
    }

    private void saveTeams(){
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

}