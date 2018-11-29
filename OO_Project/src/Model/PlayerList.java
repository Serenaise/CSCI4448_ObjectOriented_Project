package Model;

import java.util.*;

/**
 * The PlayerList class tracks the players currently in the game.
 */
public class PlayerList implements Cloneable {
    /**
     * players holds the players currently in the game.
     */
    private ArrayList<Player> players;

    /**
     * Builds a PlayerList with the specified number of players. The numbers of the players in the list start at 1 and
     * go to numberOfPlayers.
     * @param numberOfPlayers the number of players to add to the PlayerList
     */
    public PlayerList(int numberOfPlayers){
        this.players = new ArrayList<Player>();
        for (int i = 0; i< numberOfPlayers; i++){
            players.add(new Player(i+1));
        }
    }

//    public ArrayList<Player> getPlayers() {
//        return players;
//    }

    /**
     * Retrieves the player at index i.
     * @param i the index of the Player to retrieve from the PlayerList
     * @return Returns the Player at index i.
     */
    public Player getPlayer(int i){
        return players.get(i);
    }

    public int getNumberOfPlayers(){
        // returns the number of players between 1 and 5 not index.
        return players.size();
    }

    /**
     * Removes a Player from the PlayerList.
     * @param playerNumber the number of the player to remove.
     * @return Returns an ArrayList of players with the player removed.
     */
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

    @Override
    public PlayerList clone(){
        PlayerList playersClone = new PlayerList(this.getNumberOfPlayers());
        playersClone.players = this.players;
        return playersClone;
    }

}
