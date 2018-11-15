package Controller;

import Model.*;
import View.*;

public class Main {

    public static void main(String[] args) {
        // Create game.
        Screen view = new Screen();
        int numberOfPlayers = view.getNumberOfPlayers();
        PlayerList players = new PlayerList(numberOfPlayers);
        RoundOfPlay round = new RoundOfPlay();
        Dealer d = new Dealer();
        Pot pot = new Pot();
        Board board = new Board();
        int playersSacrificeToPot;


        // First round (Pre-Flop).
        // Players are dealt cards and given the opportunity to bet.
        //TODO: Set originator state.
        //TODO: Save state.
        d.dealPlayerCards(players);
        playersSacrificeToPot = BettingRound.execute(players,board,pot,round,view);
        pot.raisePot(playersSacrificeToPot * players.getNumberOfPlayers());
        round.incrementRoundNumber();
        //TODO: Option to go back to earlier in the game.

        // Second round (Flop).
        // Three cards dealt to the board and players bet.
        //TODO: Set originator state.
        //TODO: Save state.
        d.dealBoard(board, round);
        playersSacrificeToPot = BettingRound.execute(players, board, pot, round, view);
        pot.raisePot(playersSacrificeToPot * players.getNumberOfPlayers());
        round.incrementRoundNumber();
        //TODO: Option to go back to earlier in the game.

        // Third round (Turn).
        // One card dealt to the board and players bet.
        //TODO: Set originator state.
        // TODO: Save state.
        d.dealBoard(board, round);
        playersSacrificeToPot = BettingRound.execute(players, board, pot, round, view);
        pot.raisePot(playersSacrificeToPot * players.getNumberOfPlayers());
        round.incrementRoundNumber();
        //TODO: Option to go back to earlier in the game.

        // Fourth round (river).
        // One card dealt to the board and players bet.
        //TODO: Set originator state.
        //TODO: Save state.
        d.dealBoard(board, round);
        playersSacrificeToPot = BettingRound.execute(players, board, pot, round, view);
        pot.raisePot(playersSacrificeToPot * players.getNumberOfPlayers());
        round.incrementRoundNumber();
        //TODO: Option to go back to earlier in the game.


        //TODO: get player's hands.
        //TODO: Compare values of hands to find the winner
        //get hand of each player
        for (int i = 0; i < players.getNumberOfPlayers(); i++){
            Player p = players.getPlayer(i);
            view.getHand(p, board);
        }

    }

}

