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


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdatePlayersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdatePlayersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdatePlayersFragment newInstance(String param1, String param2) {
        UpdatePlayersFragment fragment = new UpdatePlayersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_players, container, false);
//        long i = this.getArguments().getLong("tid");
        addNewplayer = view.findViewById(R.id.addNew);
        addNewplayer.setOnClickListener(this);
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
                NewPlayer.fragmentManager.beginTransaction().
                        replace(R.id.fragment_conteiner, new AddPlayerFragment()).addToBackStack(null).commit();
            break;
        }
    }
}