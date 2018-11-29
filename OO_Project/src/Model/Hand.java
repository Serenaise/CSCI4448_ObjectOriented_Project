package Model;

import java.util.ArrayList;

/**
 * The Hand class holds the cards that the player chooses from the board and from their personal cards at the end of
 * the game.
 */
public class Hand {
    /**
     * The cards in a hand.
     */
    private ArrayList<Card> cards;
    /**
     * The rank of the hand. A higher rank means that it is a better hand. A hand with a higher rank than another hand
     * will always beat that hand.
     */
    private Integer rank;

    /**
     * Creates a new Hand object with rank 0 and an empty cards list.
     */
    public Hand(){
        this.cards = new ArrayList<>();
        this.rank = 0;
    }

    /**
     * Creates a new hand object with rank 0 and cards list as specified.
     * @param cards
     */
    public Hand(ArrayList<Card> cards){
        this.cards = cards;
        this.rank = 0;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
    }
}
