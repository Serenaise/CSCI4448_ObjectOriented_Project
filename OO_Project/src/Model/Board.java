package Model;

import java.util.ArrayList;

/**
 * Board holds the community cards that are dealt to the table and can be viewed by all players.
 */
public class Board implements Cloneable {
    /**
     * Keeps track of cards on board.
     */
    private ArrayList<Card> board;

    /**
     * Creates an empty board.
     */
    public Board(){
        this.board = new ArrayList<Card>();
    }

    /**
     * Adds a card to the board.
     * @param c Card to add to the board.
     */
    public void updateBoard(Card c){
        this.board.add(c);

    }

    /**
     * Returns the current board.
     * @return an ArrayList of the cards on the board.
     */
    public ArrayList<Card> getBoard() {
        return this.board;
    }

    /**
     * Returns a String representation of the board. Utilizes the toString method for Card.
     * @return "Empty" if there are no cards on the board and a string of the form "(0,N)(0,N)...(0,N)" where 0 is the
     * number of the card and N is the suit.
     */
    public String toString(){
        StringBuilder retVal = new StringBuilder();
        if (board.size() == 0){
            retVal.append("Empty");
        }
        else {
            for (Card aBoard : board) {
                retVal.append(aBoard.toString());
            }
        }
        return retVal.toString();
    }

    @Override
    public Board clone(){
        Board boardClone = new Board();
        for (int i = 0; i < board.size(); i++){
            boardClone.updateBoard(board.get(1));
        }
        return boardClone;
    }

}
