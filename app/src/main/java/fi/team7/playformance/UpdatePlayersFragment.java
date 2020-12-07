package fi.team7.playformance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import fi.team7.playformance.teams.NewPlayer;


public class UpdatePlayersFragment extends Fragment implements View.OnClickListener {

    private Button addNewplayer;
    private TextView teamName;
    private long TID;

    public UpdatePlayersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_players, container, false);
        teamName = view.findViewById(R.id.tvForTeamName);
        addNewplayer = view.findViewById(R.id.addNew);
        addNewplayer.setOnClickListener(this);
        Bundle bundle = getArguments();
        TID = bundle.getLong("tid", Long.parseLong("0"));
        Log.d("SOPT", String.valueOf(TID));
        teamName.setText(NewPlayer.appDB.teamDAO().getTeamByID(TID).name);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addNew:
                Bundle bundle2 = new Bundle();
                bundle2.putLong("tid", TID);
                AddPlayerFragment info = new AddPlayerFragment();
                info.setArguments(bundle2);
                NewPlayer.fragmentManager.beginTransaction().
                        replace(R.id.fragment_conteiner, info).addToBackStack(null).commit();
            break;
        }
    }

}