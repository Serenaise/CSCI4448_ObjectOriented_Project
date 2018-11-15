package Controller;

import Model.Board;
import Model.PlayerList;
import Model.Pot;
import Model.RoundOfPlay;
import View.Screen;

public class BettingRound {


    public static int execute(PlayerList players, Board board, Pot pot, RoundOfPlay round, Screen view){
        int playerIndex = 0;
        int currentBet = 0;
        while (playerIndex < players.getNumberOfPlayers()){
            int bet = view.getBet(playerIndex, players, board, currentBet,pot,round);
            if (bet == 1){
                //TODO: If we are keeping track of how much money the player has we should subtract from how much they have.
                int raiseValue = view.getRaiseValue();
                System.out.println("You chose to raise by " + raiseValue);
                currentBet = currentBet + raiseValue;
                if (playerIndex == 0){
                    playerIndex++;
                }
                else {
                    playerIndex = 0;
                }
            }
            else if (bet == 2){
                System.out.println("You chose to call");
                //TODO: Take bet value from player
                playerIndex++;
            }
            else {
                System.out.println("You chose to fold");
                players.removePlayer(playerIndex+1);
            }

            // TODO: Figure out how to clear the screen.
            //try {
            //    Runtime.getRuntime().exec("clear");
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}

        }
//        System.out.println("There are "+players.getNumberOfPlayers() + " player(s) left in the game.");
        return currentBet;
    }
}
