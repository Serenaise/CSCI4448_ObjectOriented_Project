package Model;

import java.util.ArrayList;

/**
 * The Player class represents a player of the game.
 */
public class Player {
    /**
     * The number of the player. Used for identification purposes.
     */
    private int number;
    /**
     * The hand that the player plays at the end of the game.
     */
    private Hand hand;
    /**
     * The cards that the player is dealt.
     */
    private Card[] personalCards;

    /**
     * Constructs a Player with the number specified.
     * @param number the number to create the player with
     */
    public Player(int number){
        this.number = number;
        this.hand = new Hand();
        this.personalCards = new Card[2];
    }

    public int getNumber() { return number; }

    public Hand getHand() { return hand; }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Card[] getPersonalCards() { return personalCards; }

    public Card getPersonalCard(int i){ return personalCards[i]; }

    public void setPersonalCards(Card[] personalCards) { this.personalCards = personalCards; }
}
