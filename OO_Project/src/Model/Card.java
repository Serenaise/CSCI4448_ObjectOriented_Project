package Model;

import java.util.Comparator;

/**
 * A Card object that has a suit and a numerical value.
 */
public class Card implements Cloneable, Comparable<Card> {
    /**
     * The numerical value of the Card as an Integer. It is an integer between 1 and 13. Face cards are represented
     * numerically as follows: Jack = 11, Queen = 12, King = 13 and an Ace has a value of 1.
     */
    private Integer value;
    /**
     * The suit of the card as a Character.
     */
    private Character suit;

    /**
     * Constructs a Card with the value and suit values specified.
     * @param value the integer value of the card.
     * @param suit the suit of the card as a char.
     */
    public Card(int value, char suit){
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString(){
        String retVal = "(";
        retVal = retVal + this.getValue();
        retVal = retVal + ", ";
        retVal = retVal + this.getSuit();
        retVal = retVal + ")";
        return retVal;
    }

    public Integer getValue() { return value; }
    public Character getSuit() { return suit; }

    @Override
    public Card clone(){
        return  new Card(this.value,this.suit);
    }


//    public int compare(Card a, Card b){
//        return Integer.compare(a.getValue(), b.getValue());
//    }
    @Override
    public int compareTo(Card c){
        return Integer.compare(this.value, c.getValue());
    }
}
