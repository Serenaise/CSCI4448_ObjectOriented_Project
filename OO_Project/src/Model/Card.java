package Model;
public class Card {
    private int value;
    private char suit;

    public Card(int value, char suit){
        this.value = value;
        this.suit = suit;
    }

    public String toString(){
        String retVal = "(";
        retVal = retVal + this.getValue();
        retVal = retVal + ", ";
        retVal = retVal + this.getSuit();
        retVal = retVal + ")";
        return retVal;
    }

    public int getValue() { return value; }
    public char getSuit() { return suit; }
}
