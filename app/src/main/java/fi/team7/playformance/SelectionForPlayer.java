package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fi.team7.playformance.notes.FaultsScreen;
import fi.team7.playformance.notes.WinsScreen;
import fi.team7.playformance.teams.SelectTeam;
import fi.team7.playformance.teams.TeamCreationSC;

public class SelectionForPlayer extends AppCompatActivity {

    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_for_player);
    }

    public void chose(View view) {
        if (view.getId() == R.id.btnFaults) {
            Intent intent = new Intent(this, FaultsScreen.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnWins) {
            Intent intent = new Intent(this, WinsScreen.class);
            startActivity(intent);
        }
    }
}