package Model;
import java.util.*;

public class Dealer {
    private Deck deck;

    public Dealer(){
        this.deck = new Deck();
    }

    public void dealBoard(Board board, RoundOfPlay round){
        int roundNumber = round.getRoundNumber();
        if(roundNumber == 1){
            this.dealFlop(board);
            round.incrementRoundNumber();
        }
        else if(roundNumber == 2) {
            this.dealTurn(board);
            round.incrementRoundNumber();
        } else {
            this.dealRiver(board);
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
