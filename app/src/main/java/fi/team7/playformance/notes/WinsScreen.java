package fi.team7.playformance.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fi.team7.playformance.R;
import fi.team7.playformance.teams.SelectTeam;
import fi.team7.playformance.teams.SelectionOfPlayer;
import fi.team7.playformance.teams.TeamCreationSC;

public class WinsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wins_screen);
    }




    public void faultOrOtherPlayer(View view) {
        if (view.getId() == R.id.btnOtherPlayer) {
            Intent intent = new Intent(this, SelectionOfPlayer.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnToFaults) {
            Intent intent = new Intent(this, FaultsScreen.class);
            startActivity(intent);
        }
    }
}