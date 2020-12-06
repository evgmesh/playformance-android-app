package fi.team7.playformance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fi.team7.playformance.data.Player;
import fi.team7.playformance.notes.Note;
import fi.team7.playformance.teams.NewPlayer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddPlayerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPlayerFragment extends Fragment {

    private EditText firstName, lastName, number;
    private TextView teamName;
    private Button btnSave;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private long mParam1;

    public AddPlayerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment NewPlayer.
     */
    // TODO: Rename and change types and number of parameters
    public static AddPlayerFragment newInstance(long param1) {
        AddPlayerFragment fragment = new AddPlayerFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getLong(ARG_PARAM1);
            Log.d("ARG", String.valueOf(mParam1));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_player, container, false);
        teamName = view.findViewById(R.id.teamName);
        firstName = view.findViewById(R.id.txtNewPfirstName2);
        lastName = view.findViewById(R.id.txtNewPlaststName2);
        number = view.findViewById(R.id.txtNewPlayerNumber2);
        btnSave = view.findViewById(R.id.btnSubmit2);
        Bundle bundle = getArguments();
        long i = bundle.getLong("tid", Long.parseLong("0"));
        Log.d("SOPT", String.valueOf(i));
        teamName.setText(NewPlayer.appDB.teamDAO().getTeamByID(i).name);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fistNameSt = firstName.getText().toString();
                String lastNameSt = lastName.getText().toString();
                int numberInt = Integer.parseInt(number.getText().toString());

                Player p = new Player(0, fistNameSt, lastNameSt, numberInt, i);
                NewPlayer.appDB.playerDAO().createPlayer(p);
                Toast.makeText(getActivity(), "Player added", Toast.LENGTH_SHORT).show();
                firstName.setText("");
                lastName.setText("");
                number.setText("");
            }
        });
        return view;
        // Inflate the layout for this fragment
    }
}