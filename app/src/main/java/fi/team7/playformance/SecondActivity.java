package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fi.team7.playformance.teams.SelectTeam;
import fi.team7.playformance.teams.TeamCreationSC;

public class SecondActivity extends AppCompatActivity {

//    private final View.OnClickListener onClickListener = view -> {
//        Intent intent = new Intent(this, TeamCreationSC.class);
//        startActivity(intent);
//    };
//    private final View.OnClickListener onClickListener2 = view -> {
//        Intent intent2 = new Intent(this, SelectTeam.class);
//        startActivity(intent2);
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    public void buttonPressed(View view) {
        if (view.getId() == R.id.btnNewTeam) {
            Intent intent = new Intent(this, TeamCreationSC.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnExistTeam) {
            Intent intent = new Intent(this, SelectTeam.class);
            startActivity(intent);
        }
//        if (view.getId() == R.id.btnPerformance) {
//            Intent intent = new Intent(this, Performance.class);
//            startActivity(intent);
//        }
    }
}