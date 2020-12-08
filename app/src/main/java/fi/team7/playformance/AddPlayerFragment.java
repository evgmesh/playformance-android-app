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


public class AddPlayerFragment extends Fragment {

    private EditText firstName, lastName, number;
    private TextView teamName;
    private Button btnSave;

    public AddPlayerFragment() {
        // Required empty public constructor
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
        teamName.setText(NewPlayer.appDB.teamDAO().getTeamByID(i).name);

        // Event listener
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fistNameSt = firstName.getText().toString();
                String lastNameSt = lastName.getText().toString();
                int numberInt = Integer.parseInt(number.getText().toString());

                Player p = new Player(0, fistNameSt, lastNameSt, numberInt, i);
                NewPlayer.appDB.playerDAO().createPlayer(p);

                // Shows result to user as pop up message
                Toast.makeText(getActivity(), "Player saved", Toast.LENGTH_SHORT).show();

                // Sets all inputs to NON
                firstName.setText("");
                lastName.setText("");
                number.setText("");
            }
        });
        return view;
    }
}