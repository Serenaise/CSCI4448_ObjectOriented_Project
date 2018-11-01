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

        //TODO: implement betting functionality.

    }
}

