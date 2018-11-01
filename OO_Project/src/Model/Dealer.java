package Model;
import java.util.*;

public class Dealer {
    private Deck deck;

    public Dealer(){
        this.deck = new Deck();
    }

    public void dealBoard(RoundOfPlay round){
        int roundNumber = round.getRoundNumber();
        if(roundNumber == 1){
            this.dealFlop();
            round.incrementRoundNumber();
        }
        else if(roundNumber == 2) {
            this.dealTurn();
            round.incrementRoundNumber();
        } else {
            this.dealRiver();
            round.incrementRoundNumber();
        }
    }
    public void dealPlayerCards(PlayerList playerList, RoundOfPlay round){
        int playerListSz = playerList.getNumberOfPlayers();
        for (int i = 0; i < playerListSz; i++){
            Card playerCards[] = new Card[2];
            playerCards[0] = deck.getCard();
            playerCards[1] = deck.getCard();
            playerList.getPlayer(i).setPersonalCards(playerCards);
        }
        round.incrementRoundNumber();

    }
    private void dealFlop(){

    }
    private void dealTurn(){

    }
    private void dealRiver(){

    }
}
