package fi.team7.playformance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import fi.team7.playformance.teams.NewPlayer;


public class UpdatePlayersFragment extends Fragment implements View.OnClickListener {

    private TextView teamName;
    private long tid;

    public UpdatePlayersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_players, container, false);
        teamName = view.findViewById(R.id.tvForTeamName);

       view.findViewById(R.id.addNew).setOnClickListener(this);
        Bundle bundle = getArguments();
        tid = bundle.getLong("tid", Long.parseLong("0"));
        teamName.setText(NewPlayer.appDB.teamDAO().getTeamByID(tid).name);

        return view;
    }

    // When button "New Player" clicked new fragment is pop up and new player can be added to the chosen team
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addNew:
                Bundle bundle2 = new Bundle();
                bundle2.putLong("tid", tid);
                AddPlayerFragment info = new AddPlayerFragment();
                info.setArguments(bundle2);
                NewPlayer.fragmentManager.beginTransaction().
                        replace(R.id.fragment_conteiner, info).addToBackStack(null).commit();
            break;
        }
        //TODO here I can add new cases to update players, update team, remove player and team
    }
}

// TODO link this code to new fragment to add functionality to the buttons
/* //COMMANDS FOR TEAM UPDATE

        Team t = db.teamDAO().getTeamByID(3);
        t.name = "New name";

        // Update
        db.teamDAO().updateTeam(t);
        // Delete
        db.teamDAO().deleteTeam(t);


 // COMMANDS FOR PLAYER UPDATE
        Player p = db.playerDAO().getPlayerByID(2);
        p.firstName = "NewNamePlayer";
        db.playerDAO().updatePlayer(p);
        db.playerDAO().deletePlayer(p);

 */