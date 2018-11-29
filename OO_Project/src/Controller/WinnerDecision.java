package Controller;

import Model.Card;
import Model.Hand;
import Model.Player;
import Model.PlayerList;

import java.util.*;

/**
 * WinnerDecision does stuff.
 *
 */
public class WinnerDecision {
    /**
     * Method description.
     * @param players
     * @return
     */
    public static Player excute(PlayerList players){
        Player winner = players.getPlayer(0);

        for(int i = 0; i < players.getNumberOfPlayers();i++){
            Player p = players.getPlayer(i);
            ArrayList<Card> handCards = p.getHand().getCards();
            Collections.sort(handCards);
            Hand hand = new Hand(handCards);
            p.setHand(hand);
            setHandRank(p.getHand());
            if (p.getHand().getRank() > winner.getHand().getRank()){
                winner = p;
            }
            else if(p.getHand().getRank().equals(winner.getHand().getRank())){
                if(getHighCardValue(p.getHand()) > getHighCardValue(winner.getHand())){
                    winner = p;
                }
            }
        }

//        for (int i = 0; i< 5; i++){
//            System.out.println(handCards.get(i));
//        }
//        System.out.println("RoyalFlush: " + isRoyalFlush(hand.getCards()));
//        System.out.println("StraightFlush: " + isStraightFlush(hand.getCards()));
//        System.out.println("Four of a Kind: " + isFourOfAKind(hand.getCards()));
//        System.out.println("Full House: " + isFullHouse(hand.getCards()));
//        System.out.println("Flush: " + isFlush(hand.getCards()));
//        System.out.println("Straight: " + isStraight(hand.getCards()));
//        System.out.println("Three of a Kind: " + isThreeOfAKind(hand.getCards()));
//        System.out.println("Two Pair: " + isTwoPair(hand.getCards()));
//        System.out.println("Pair: " + isPair(hand.getCards()));

        return winner;
    }

    private static boolean isRoyalFlush(ArrayList<Card> hand){
        boolean royalFlush = true;
        Character suit = hand.get(0).getSuit();
        for (int i = 1; i < 5;i++){
            if (!hand.get(i).getSuit().equals(suit)){royalFlush = false;}
        }
        if(hand.get(0).getValue() != 1 || hand.get(1).getValue() != 10 || hand.get(2).getValue() != 11 || hand.get(3).getValue() != 12 || hand.get(4).getValue() != 13){
            royalFlush = false;
        }
        return royalFlush;
    }

    private static boolean isStraightFlush(ArrayList<Card> hand){
        boolean straightFlush = true;
        Character suit = hand.get(0).getSuit();
        Integer cardValue = hand.get(0).getValue();
        for (int i = 1; i < 5;i++){
            if (!hand.get(i).getSuit().equals(suit)){straightFlush = false;}
            if(hand.get(i).getValue() != cardValue + 1) {straightFlush = false;}
            cardValue++;
        }
        return straightFlush;
    }

    private static boolean isFourOfAKind(ArrayList<Card> hand){
        boolean fourOfAKind = false;
        Integer cardValue = hand.get(1).getValue();
        if ( hand.get(0).getValue().equals(cardValue) && hand.get(2).getValue().equals(cardValue) && hand.get(3).getValue().equals(cardValue)){
            fourOfAKind = true;
        }
        else if (hand.get(4).getValue().equals(cardValue) && hand.get(2).getValue().equals(cardValue) && hand.get(3).getValue().equals(cardValue)){
            fourOfAKind = true;
        }
        return fourOfAKind;
    }

    private static boolean isFullHouse(ArrayList<Card> hand){
        boolean fullHouse = false;
        Integer firstCardValue = hand.get(0).getValue();
        Integer lastCardValue = hand.get(4).getValue();
        if (hand.get(1).getValue().equals(firstCardValue) && hand.get(3).getValue().equals(lastCardValue)){
            if (hand.get(2).getValue().equals(firstCardValue) || hand.get(2).getValue().equals(lastCardValue)){
                fullHouse = true;
            }
        }
        return fullHouse;
    }

    private static boolean isFlush(ArrayList<Card> hand){
        boolean flush = true;
        Character suit = hand.get(0).getSuit();
        for (int i = 1; i < 5;i++){
            if (!hand.get(i).getSuit().equals(suit)){flush = false;}
        }
        return flush;
    }

    private static boolean isStraight(ArrayList<Card> hand){
        boolean straight = true;
        Integer cardValue = hand.get(0).getValue();
        for (int i = 1; i < 5;i++){
            if(hand.get(i).getValue() != cardValue + 1) {straight = false;}
            cardValue++;
        }
        return straight;
    }

    private static boolean isThreeOfAKind(ArrayList<Card> hand){
        boolean threeOfAKind = false;
        Integer pairValue = hand.get(2).getValue();
        if(hand.get(0).getValue().equals(pairValue) && hand.get(1).getValue().equals(pairValue)){
            threeOfAKind = true;
        }
        else if (hand.get(3).getValue().equals(pairValue) && hand.get(4).getValue().equals(pairValue)){
            threeOfAKind = true;
        }
        return threeOfAKind;
    }

    private static boolean isTwoPair(ArrayList<Card> hand){
        boolean twoPair = false;
        boolean firstPairExists = false;
        boolean secondPairExists = false;
        Integer pairValue = hand.get(0).getValue();
        for (int i = 1; i < 5; i++){
            if(hand.get(i).getValue().equals(pairValue)){
                if (!firstPairExists){firstPairExists = true;}
                else{secondPairExists = true;}
            }
            pairValue = hand.get(i).getValue();
        }
        if (firstPairExists && secondPairExists){twoPair = true;}
        return twoPair;
    }

    private static boolean isPair(ArrayList<Card> hand){
        boolean pair = false;
        Set<Integer> valuesSet = new HashSet<Integer>();
        for (int i = 0; i<5; i++){
            valuesSet.add(hand.get(i).getValue());
        }
        if(valuesSet.size() == 4){pair = true;}
        return pair;
    }

    private static int getHighCardValue(Hand hand){
        return hand.getCards().get(4).getValue();
    }

    private static void setHandRank(Hand hand){
        ArrayList<Card> handCards = hand.getCards();
        if(isRoyalFlush(handCards)){hand.setRank(10);}
        else if(isStraightFlush(handCards)){hand.setRank(9);}
        else if(isFourOfAKind(handCards)){hand.setRank(8);}
        else if(isFullHouse(handCards)){hand.setRank(7);}
        else if(isFlush(handCards)){hand.setRank(6);}
        else if(isStraight(handCards)){hand.setRank(5);}
        else if(isThreeOfAKind(handCards)){hand.setRank(4);}
        else if(isTwoPair(handCards)){hand.setRank(3);}
        else if(isPair(handCards)){hand.setRank(2);}
        else {hand.setRank(1);}
    }
}
