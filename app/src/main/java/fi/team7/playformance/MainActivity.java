package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(onClickListener);

        // Reference to singleton League
        League league = League.getInstance();
        Player player = new Player("Gulshan", "Kundra", 3);

        league.getTeam(0).addPlayer(player);
        Note note = new Note("Bad recieve", false);
        league.getTeam(0).getPlayer(0).addNote(note);

//        Coach coach = new Coach("John", "Steven", "john.ste", "43422223432");
//        Team team = new Team(coach, "Kiri");
//        team.addPlayer(player);
//        Coach coach2 = new Coach("John2", "Steven2", "john.ste2", "242352352");
//        Player player2 = new Player("Shon2", "Whilson2", 2);
//        player2.addNote(new Note("Bad recieve", true));
//        player2.addNote(new Note("Good attack", false));
//        Team team2 = new Team(coach2, "Kiri2");
//        team2.addPlayer(player2);


        TextView tv = findViewById(R.id.textView);
        String temp = league.getTeam(0) + "\n" + "\n" + "\n";

//        temp += league.getTeam(0).getPlayer(0) + " his number is: "
//                + league.getTeam(0).getPlayer(0).getNumber();
//        temp += league.getTeam(1) + "\n";
//        temp += "\n team2" +  team2.getCoach().toString() + "\n";
//        temp += team2.getAllPlayers();
        temp += "all teams: " + league.getAllTeams();
        tv.setText(temp);

    }
}