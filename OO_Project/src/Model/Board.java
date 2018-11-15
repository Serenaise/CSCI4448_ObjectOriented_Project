package Model;

import java.util.ArrayList;

public class Board {
    private ArrayList<Card> board;

    public Board(){
        this.board = new ArrayList<Card>();
    }

    public void updateBoard(Card c){
        this.board.add(c);

    }
    public ArrayList<Card> getBoard() {
        return board;
    }

    public String toString(){
        //TODO: Make sure this works.
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

}
