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
