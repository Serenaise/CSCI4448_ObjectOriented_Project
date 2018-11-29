package Model;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The Deck class hold a stockpile of cards from which the players personal cards and the board cards can be dealt.
 */
public class Deck {
    /**
     * An ArrayList of the cards currently in the deck.
     */
    private ArrayList<Card> deck;

    /**
     * Creates a standard 52 card deck. The cards have values in [1,13] and the suits are 'H', 'S', 'C', and 'D'.
     */
    public Deck(){
        this.deck = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++){
            deck.add(new Card(i,'H'));
            deck.add(new Card(i,'S'));
            deck.add(new Card(i,'C'));
            deck.add(new Card(i,'D'));
        }
    }

    /**
     * Gets a randomly selected card from the deck and removes it from the deck.
     * @return the card pulled from the deck
     */
    public Card getCard(){
        int rand = ThreadLocalRandom.current().nextInt(0,deck.size());
        Card c = new Card(deck.get(rand).getValue(),deck.get(rand).getSuit());
        deck.remove(rand);
        return c;
    }

}
