package game;

import game.rank.*;

public class PokerHand {
    private String hand;
    private int rank;

    // Constructor
    public PokerHand(String hand) {
        this.hand = hand;
        this.rank = calculateRank();
    }

    // Calculate the rank of the hand
    public int calculateRank() {
        int rank = 0;

        if (RoyalFlush.hasRoyalFlush(hand)) {
            rank = 10;
        } else if (StraightFlush.hasStraightFlush(hand)) {
            rank = 9;
        } else if (FourOfAKind.hasFourOfAKind(hand)) {
            rank = 8;
        } else if (FullHouse.hasFullHouse(hand)) {
            rank = 7;
        } else if (Flush.hasFlush(hand)) {
            rank = 6;
        } else if (Straight.hasStraight(hand)) {
            rank = 5;
        } else if (ThreeOfAKind.hasThreeOfAKind(hand)) {
            rank = 4;
        } else if (TwoPair.hasTwoPair(hand)) {
            rank = 3;
        } else if (OnePair.hasOnePair(hand)) {
            rank = 2;
        } else {
            rank = 1;
        }

        return rank;
    }

    // Compare two hands
    public static int compareHands(PokerHand h1, PokerHand h2) {
        if (h1.rank > h2.rank) {
            return 1;
        } else if (h1.rank < h2.rank) {
            return -1;
        } else {
            return 0;
        }
    }
}

/*public class PokerHand {
    private List<Card> hand; // List of cards in the Hand

    // Constructor for two-card poker hands
    public PokerHand(Card c1, Card c2) {
        this.hand = new ArrayList<Card>(Arrays.asList(c1, c2));
    }

    // Constructor for larger Texas Holdem hands
    public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
        this.hand = new ArrayList<Card>(Arrays.asList(c1, c2, c3, c4, c5));
    }

    // Getter to return the hand's card array
    public List<Card> getHand() {
        return this.hand;
    }
}*/