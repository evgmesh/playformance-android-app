package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    private final View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(this, TeamCreationSC.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.btnNewTeam).setOnClickListener(onClickListener);
    }
}