package Model;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++){
            deck.add(new Card(i,'H'));
            deck.add(new Card(i,'S'));
            deck.add(new Card(i,'C'));
            deck.add(new Card(i,'D'));
        }
    }
    public Card getCard(){
        int rand = ThreadLocalRandom.current().nextInt(0,deck.size());
        Card c = new Card(deck.get(rand).getValue(),deck.get(rand).getSuit());
        deck.remove(rand);
        return c;
    }

}
