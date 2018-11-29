package Controller;

import Model.*;
import View.Screen;
import java.io.IOException;

/**
 * The BettingRound class runs a round of betting in which players raise, call, and/or fold
 */
public class BettingRound {

    /**
     * Runs a betting round.
     * @param game the current state of the game
     * @param view the view used to get the players choice for bet types and values
     * @return Returns the amount that each player must surrender to the pot.
     */
    public static int execute(Game game, Screen view){
        PlayerList players = game.getPlayers();
        Board board = game.getBoard();
        Pot pot = game.getPot();
        RoundOfPlay round = game.getRound();
        int playerIndex = 0;
        int currentBet = 0;
        while (playerIndex < players.getNumberOfPlayers()){
            int bet = view.getBet(playerIndex, players, board, currentBet,pot,round);
            if (bet == 1){
                int raiseValue = view.getRaiseValue();
//                System.out.println("You chose to raise by " + raiseValue);
                currentBet = currentBet + raiseValue;
                if (playerIndex == 0){
                    playerIndex++;
                }
                else {
                    playerIndex = 0;
                }
            }
            else if (bet == 2){
//                System.out.println("You chose to call");
                playerIndex++;
            }
            else {
//                System.out.println("You chose to fold");
                players.removePlayer(playerIndex+1);
            }

            try {
                Runtime.getRuntime().exec("clear");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//        System.out.println("There are "+players.getNumberOfPlayers() + " player(s) left in the game.");
        return currentBet;
    }
}
