package game;

import game.rank.RoyalFlush;
import game.rank.StraightFlush;

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
        } else if (hasFourOfAKind()) {
            rank = 8;
        } else if (hasFullHouse()) {
            rank = 7;
        } else if (hasFlush()) {
            rank = 6;
        } else if (hasStraight()) {
            rank = 5;
        } else if (hasThreeOfAKind()) {
            rank = 4;
        } else if (hasTwoPair()) {
            rank = 3;
        } else if (hasOnePair()) {
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
