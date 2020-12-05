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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdatePlayersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdatePlayersFragment extends Fragment implements View.OnClickListener {

    private Button addNewplayer;
    private TextView teamName;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private long TID;
    // TODO: Rename and change types of parameters
    private long mParam1;

    public UpdatePlayersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment UpdatePlayersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdatePlayersFragment newInstance(long param1) {
        UpdatePlayersFragment fragment = new UpdatePlayersFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getLong(ARG_PARAM1);
//
//            Log.d("ARG", String.valueOf(mParam1));
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_players, container, false);

        teamName = view.findViewById(R.id.tvForTeamName);
        addNewplayer = view.findViewById(R.id.addNew);
        addNewplayer.setOnClickListener(this);
        Bundle bundle = getArguments();
        TID = bundle.getLong("tid", Long.parseLong("0"));
        Log.d("SOPT", String.valueOf(TID));
        teamName.setText(NewPlayer.appDB.teamDAO().getTeamByID(TID).name);
//        Log.i("CHECKDB", NewPlayer.appDB.teamDAO().getTeamByID(i).name);



        return view;
    }

//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            String myValue = this.getArguments().getString("message");
//    ...
//        }



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