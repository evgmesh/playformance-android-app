package fi.team7.playformance;

import java.util.ArrayList;
import java.util.List;

public class Player {

    //Only one instance of this class is created automatically
    //when the class is loaded
    private static final Player playerInstance = new Player();

    /**
     * Get reference to the Players data stories which is a SINGLETON
     * @return
     */
    public static Player getInstance(){
        return playerInstance;
    }

    //List guarantees the list to hold original order
    private List<Player> players;

    private Player(){
        this.players = new ArrayList<>();
        // new players can be added here in bellow

    }

    //This will be used by the ListView listing all players into ListView widget
    public List<Player> getAllPlayers() {
        return this.players;
    }


}
