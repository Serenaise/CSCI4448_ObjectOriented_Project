package Contoller;

import Model.*;
import View.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // Create game.
        Screen v = new Screen();
        int numberOfPlayers = v.getNumberOfPlayers();
        PlayerList players = new PlayerList(numberOfPlayers);
        RoundOfPlay round = new RoundOfPlay();
        Dealer d = new Dealer();

        // First round (Pre-Flop).
        // Players are dealt cards and given the opportunity to bet.
        d.dealPlayerCards(players, round);

        for (int i = 0; i < players.getNumberOfPlayers(); i++){
            Player p = players.getPlayer(i);
            System.out.println("Player " + p.getNumber() + " has cards: " + p.getPersonalCard(0) + " and " + p.getPersonalCard(1));
        }

        //TODO: Get players bets.
        //TODO: Place bets. (Note that this involves revisiting players who bet earlier in the round when someone raises)
        //TODO: Deal flop.
        //TODO: Betting round after flop.
        //TODO: Deal turn.
        //TODO: Betting round after turn.
        //TODO: Deal river.
        //TODO: Betting round after river.
        //TODO: Compare values of hands to find the winner

    }
}

