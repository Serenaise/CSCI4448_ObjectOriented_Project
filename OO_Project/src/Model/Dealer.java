package Model;
import java.util.*;

public class Dealer {
    private Deck deck;

    public Dealer(){
        this.deck = new Deck();
    }

    public void dealBoard(Board board, RoundOfPlay round){
        int roundNumber = round.getRoundNumber();
        if(roundNumber == 2){
            this.dealFlop(board);
        }
        else if(roundNumber == 3) {
            this.dealTurn(board);
        } else {
            this.dealRiver(board);
        }
    }
    public void dealPlayerCards(PlayerList playerList){
        int playerListSz = playerList.getNumberOfPlayers();
        for (int i = 0; i < playerListSz; i++){
            Card playerCards[] = new Card[2];
            playerCards[0] = deck.getCard();
            playerCards[1] = deck.getCard();
            playerList.getPlayer(i).setPersonalCards(playerCards);
        }
    }
    private void dealFlop(Board board){
        board.updateBoard(deck.getCard());
        board.updateBoard(deck.getCard());
        board.updateBoard(deck.getCard());
    }
    private void dealTurn(Board board){
        board.updateBoard(deck.getCard());
    }
    private void dealRiver(Board board){
        board.updateBoard(deck.getCard());
    }
}
