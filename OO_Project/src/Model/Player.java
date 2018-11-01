package Model;

public class Player {
    private int number;
    private Card[] hand;
    private Card[] personalCards;

    public Player(int number){
        this.number = number;
        this.hand = new Card[5];
        this.personalCards = new Card[2];
    }

    public int getNumber() { return number; }

    public Card[] getHand() { return hand; }

    public void setHand(Card[] hand) { this.hand = hand; }

    public Card[] getPersonalCards() { return personalCards; }

    public Card getPersonalCard(int i){ return personalCards[i]; }

    public void setPersonalCards(Card[] personalCards) { this.personalCards = personalCards; }
}
