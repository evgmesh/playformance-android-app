package fi.team7.playformance.teams;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import fi.team7.playformance.R;
import fi.team7.playformance.UpdatePlayersFragment;
import fi.team7.playformance.data.AppDB;

public class NewPlayer extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static AppDB appDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);
        fragmentManager = getSupportFragmentManager();
        appDB = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

        Bundle b = getIntent().getExtras();
        long i = b.getLong(SelectionOfPlayer.EXTRA, 0);

        if (findViewById(R.id.fragment_conteiner) != null) {
            if (savedInstanceState != null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("tid", i);
            UpdatePlayersFragment info = new UpdatePlayersFragment();
            info.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.fragment_conteiner, info).commit();
        }
    }
}