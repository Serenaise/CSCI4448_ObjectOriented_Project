package Model;

import java.util.ArrayList;

public class Board {
    private ArrayList<Card> board;

    public Board(){
        this.board = new ArrayList<Card>();
    }

    public ArrayList<Card> updateBoard(Card c){
        this.board.add(c);
        return this.board;

    }
    public ArrayList<Card> getBoard() {
        return board;
    }

}
