package Model;

/**
 * The Dealer class has a deck from which it deals cards to the players and to the board.
 */
public class Dealer {
    private Deck deck;

    /**
     * Creates a dealer with a new deck.
     */
    public Dealer(){
        this.deck = new Deck();
    }

    /**
     * Deals cards to the board.
     * @param board board to deal cards to
     * @param round the round (used to determine how many cards to deal)
     */
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

    /**
     * Deals a personal cards to players.
     * @param playerList list of players to deal to
     */
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
