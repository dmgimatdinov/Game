package game;

import java.util.Comparator;

public class PokerHandComparator implements Comparator<PokerHand> {
    @Override
    public int compare(PokerHand hand1, PokerHand hand2) {
        return hand1.getRank() < hand2.getRank() ? -1 : hand1.getRank() == hand2.getRank() ? 0 : 1;
    }
}

/*public class PokerHandComparator implements Comparator<PokerHand> {

    // Define the order of the suits
    private final String SUIT_ORDER = "CDHS";

    // Compare two cards and return their relative order
    private int compareCards(Card left, Card right) {
        if (left.getValue() < right.getValue()) {
            return -1;
        } else if (left.getValue() > right.getValue()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int compare(PokerHand left, PokerHand right) {
        // Sort the cards in each hand
        left.sort();
        right.sort();

        // Check for royal flush
        boolean leftRoyalFlush = left.getCards().get(0).getValue() == 10;
        boolean rightRoyalFlush = right.getCards().get(0).getValue() == 10;
        if (leftRoyalFlush && rightRoyalFlush) {
            // Both hands have a royal flush, so they are tied
            return 0;
        } else if (leftRoyalFlush) {
            // Left hand has a royal flush, so it wins
            return 1;
        } else if (rightRoyalFlush) {
            // Right hand has a royal flush, so it wins
            return -1;
        }

        // Check for straight flush
        boolean leftStraightFlush = left.isFlush() && left.isStraight();
        boolean rightStraightFlush = right.isFlush() && right.isStraight();
        if (leftStraightFlush && rightStraightFlush) {
            // Both hands have a straight flush, so compare their highest card
            return compareCards(left.getCards().get(4), right.getCards().get(4));
        } else if (leftStraightFlush) {
            // Left hand has a straight flush, so it wins
            return 1;
        } else if (rightStraightFlush) {
            // Right hand has a straight flush, so it wins
            return -1;
        }

        // Check for four of a kind
        boolean leftFourOfAKind = left.hasFourOfAKind();
        boolean rightFourOfAKind = right.hasFourOfAKind();
        if (leftFourOfAKind && rightFourOfAKind) {
            // Both hands have four of a kind, so compare their ranks
            int leftRank = left.getFourOfAKindRank();
            int rightRank = right.getFourOfAKindRank();
            return Integer.compare(leftRank, rightRank);
        } else if (leftFourOfAKind) {
            // Left hand has four of a kind, so it wins
            return 1;
        } else if (rightFourOfAKind) {
            // Right hand has four of a kind, so it wins
            return -1;
        }

        // Check for full house
        boolean leftFullHouse = left.hasFullHouse();
        boolean rightFullHouse = right.hasFullHouse();
        if (leftFullHouse && rightFullHouse) {
            // Both hands have full house, so compare their ranks
            int leftRank = left.getThreeOfAKindRank();
            int rightRank = right.getThreeOfAKindRank();
            return Integer.compare(leftRank, rightRank);
        } else if (leftFullHouse) {
            // Left hand has full house, so it wins
            return 1;
        } else if (rightFullHouse) {
            // Right hand has full house, so it wins
            return -1;
        }

        // Check for flush
        boolean leftFlush = left.isFlush();
        boolean rightFlush = right.isFlush();
        if (leftFlush && rightFlush) {
            // Both hands have a flush, so compare their highest cards
            return compareCards(left.getCards().get(4), right.getCards().get(4));
        } else if (leftFlush) {
            // Left hand has a flush, so it wins
            return 1;
        } else if (rightFlush) {
            // Right hand has a flush, so it wins
            return -1;
        }

        // Check for straight
        boolean leftStraight = left.isStraight();
        boolean rightStraight = right.isStraight();
        if (leftStraight && rightStraight) {
            // Both hands have a straight, so compare their highest cards
            return compareCards(left.getCards().get(4), right.getCards().get(4));
        } else if (leftStraight) {
            // Left hand has a straight, so it wins
            return 1;
        } else if (rightStraight) {
            // Right hand has a straight, so it wins
            return -1;
        }

        // Check for three of a kind
        boolean leftThreeOfAKind = left.hasThreeOfAKind();
        boolean rightThreeOfAKind = right.hasThreeOfAKind();
        if (leftThreeOfAKind && rightThreeOfAKind) {
            // Both hands have three of a kind, so compare their ranks
            int leftRank = left.getThreeOfAKindRank();
            int rightRank = right.getThreeOfAKindRank();
            return Integer.compare(leftRank, rightRank);
        } else if (leftThreeOfAKind) {
            // Left hand has three of a kind, so it wins
            return 1;
        } else if (rightThreeOfAKind) {
            // Right hand has three of a kind, so it wins
            return -1;
        }

        // Check for two pairs
        boolean leftTwoPairs = left.hasTwoPairs();
        boolean rightTwoPairs = right.hasTwoPairs();
        if (leftTwoPairs && rightTwoPairs) {
            // Both hands have two pairs, so compare their pairs and kicker
            int leftPair1Rank = left.getPair1Rank();
            int leftPair2Rank = left.getPair2Rank();
            int rightPair1Rank = right.getPair1Rank();
            int rightPair2Rank = right.getPair2Rank();
            if (leftPair1Rank != rightPair1Rank) {
                return Integer.compare(leftPair1Rank, rightPair1Rank);
            } else if (leftPair2Rank != rightPair2Rank) {
                return Integer.compare(leftPair2Rank, rightPair2Rank);
            } else {
                Card leftKicker = left.getKicker();
                Card rightKicker = right.getKicker();
                return compareCards(leftKicker, rightKicker);
            }
        } else if (leftTwoPairs) {
            // Left hand has two pairs, so it wins
            return 1;
        } else if (rightTwoPairs) {
            // Right hand has two pairs, so it wins
            return -1;
        }

        // Check for one pair
        boolean leftOnePair = left.hasOnePair();
        boolean rightOnePair = right.hasOnePair();
        if (leftOnePair && rightOnePair) {
            // Both hands have one pair, so compare their ranks and kickers
            int leftPairRank = left.getPair1Rank();
            int rightPairRank = right.getPair1Rank();
            if (leftPairRank != rightPairRank) {
                return Integer.compare(leftPairRank, rightPairRank);
            } else {
                Card leftKicker1 = left.getKicker1();
                Card rightKicker1 = right.getKicker1();
                if (leftKicker1.getValue() != rightKicker1.getValue()) {
                    return compareCards(leftKicker1, rightKicker1);
                } else {
                    Card leftKicker2 = left.getKicker2();
                    Card rightKicker2 = right.getKicker2();
                    return compareCards(leftKicker2, rightKicker2);
                }
            }
        } else if (leftOnePair) {
            // Left hand has one pair, so it wins
            return 1;
        } else if (rightOnePair) {
            // Right hand has one pair, so it wins
            return -1;
        }

        // Neither hand has any pairs or better, so compare their highest cards
        return compareCards(left.getCards().get(4), right.getCards().get(4));
    }
}*/

