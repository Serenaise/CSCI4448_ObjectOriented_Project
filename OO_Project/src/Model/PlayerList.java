package Model;

import java.util.*;

public class PlayerList {
    private ArrayList<Player> players;

    public PlayerList(int numberOfPlayers){
        this.players = new ArrayList<Player>();
        for (int i = 0; i< numberOfPlayers; i++){
            players.add(new Player(i+1));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public Player getPlayer(int i){
        return players.get(i);
    }
    public int getNumberOfPlayers(){
        // returns the number of players between 1 and 5 not index.
        return players.size();
    }
    public ArrayList<Player> removePlayer(int playerNumber){
        int sz = players.size();
        for (int i = 0; i < sz; i++){
            Player p = players.get(i);
            if (p.getNumber()==playerNumber){
                players.remove(p);
                sz = sz - 1;
            }
        }
        return players;
    }

}
