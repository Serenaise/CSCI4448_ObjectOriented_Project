package Controller;

import Model.*;
import View.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create game.
        Screen view = new Screen();
        int numberOfPlayers = view.getNumberOfPlayers();
        PlayerList players = new PlayerList(numberOfPlayers);
        RoundOfPlay round = new RoundOfPlay();
        Dealer dealer = new Dealer();
        Pot pot = new Pot();
        Board board = new Board();
        int playersSacrificeToPot;
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        Game game = new Game(players, pot, board, round);
        originator.setState(game);


        dealer.dealPlayerCards(originator.getPlayers());

        while (originator.getRound().getRoundNumber() <= 4){
            if (originator.getRound().getRoundNumber() > 1){
                dealer.dealBoard(originator.getBoard(), originator.getRound());
            }
            playersSacrificeToPot = BettingRound.execute(originator.getState(), view);
            originator.getPot().raisePot(playersSacrificeToPot * players.getNumberOfPlayers());
            if (view.getSaveOption()){
                careTaker.add(originator.saveStateToMemento());
                System.out.println("Saved");
            }
            originator.getRound().incrementRoundNumber();
            if (!careTaker.isEmpty() && view.getRevertOption()){
                originator.getStateFromMemento(careTaker.get(view.getRevertChoice(careTaker) -1));
            }
        }

        for (int i = 0; i < players.getNumberOfPlayers(); i++){
            Player p = players.getPlayer(i);
            view.getHand(p, originator.getBoard());
        }
        view.displayWinner(WinnerDecision.excute(players));

    }

}

