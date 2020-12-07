package fi.team7.playformance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import fi.team7.playformance.teams.SelectTeam;
import fi.team7.playformance.teams.TeamCreationSC;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

// Choose of options at the beginning - what user want to do - either to create new team,
// work with existing or see performance

    public void buttonPressed(View view) {
        if (view.getId() == R.id.btnNewTeam) {
            Intent intent = new Intent(this, TeamCreationSC.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnExistTeam) {
            Intent intent = new Intent(this, SelectTeam.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnPerformance) {
            Intent intent = new Intent(this, Performance.class);
            startActivity(intent);
        }
    }
}