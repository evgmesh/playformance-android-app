package Teams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import fi.team7.playformance.R;

public class SelectionOfPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_of_player);
        Bundle b = getIntent().getExtras();
        int i = b.getInt(SelectTeam.EXTRA, 0);
        ((TextView) findViewById(R.id.tvSelectedTeam)).setText(
                League.getInstance().getTeam(i).getName());
    }
}