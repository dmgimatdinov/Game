package game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PokerHandTest {
    @Test
    void testCalculateRank() {
        PokerHand hand1 = new PokerHand("KS AS QS JS TS");
        assertEquals(10, hand1.calculateRank(), "Royal Flush should have rank 10");

        PokerHand hand2 = new PokerHand("5H 6H 7H 8H 9H");
        assertEquals(9, hand2.calculateRank(), "Straight Flush should have rank 9");

        PokerHand hand3 = new PokerHand("AC AD AH AS 2D");
        assertEquals(8, hand3.calculateRank(), "Four of a Kind should have rank 8");

        PokerHand hand4 = new PokerHand("AC AD AH 2S 2D");
        assertEquals(7, hand4.calculateRank(), "Fool House should have rank 7");

        PokerHand hand5 = new PokerHand("AD JD AD 4D 2D");
        assertEquals(6, hand5.calculateRank(), "Flush should have rank 6");

        PokerHand hand6 = new PokerHand("5H 6H 7H 8H 9S");
        assertEquals(5, hand6.calculateRank(), "Straight should have rank 5");

        PokerHand hand7 = new PokerHand("QD QC QH 9S 7C");
        assertEquals(4, hand7.calculateRank(), "Three of a Kind should have rank 4");

        PokerHand hand8 = new PokerHand("QD AC QH 9S 9C");
        assertEquals(3, hand8.calculateRank(), "Two Pair should have rank 3");

        PokerHand hand9 = new PokerHand("AS AC TH 9C 8D");
        assertEquals(2, hand9.calculateRank(), "One Pair should have rank 2");

        PokerHand hand10 = new PokerHand("QH JD 9C 7S 5H");
        assertEquals(1, hand10.calculateRank(), "Hiqh Card should have rank 1");

        // Add more test cases for other ranks
    }

    @Test
    void testCompareHands() {
        PokerHand hand1 = new PokerHand("KS AS QS JS TS");
        PokerHand hand2 = new PokerHand("5H 6H 7H 8H 9H");

        assertEquals(1, PokerHand.compareHands(hand1, hand2), "Royal Flush should beat a Straight");

        hand1 = new PokerHand("AC AD AH 2S 2D");
        hand2 = new PokerHand("KC KD KS 7C 8H");

        assertEquals(1, PokerHand.compareHands(hand1, hand2), "Three of a Kind should beat a Pair");

        // Add more test cases for comparing hands
    }

    @Test
     void testHigherRank() {
        PokerHand hand1 = new PokerHand("10C JS QS KS AS");
        PokerHand hand2 = new PokerHand("9C JC QC KC AC");
        PokerHandComparator comparator = new PokerHandComparator();
        int result = comparator.compare(hand1, hand2);
        assertTrue(result < 0);
    }
    
    @Test
    public void testLowerRank() {
        PokerHand hand1 = new PokerHand("3D 4H 5C 6S 7H");
        PokerHand hand2 = new PokerHand("4C 5D 6H 7C TD");
        PokerHandComparator comparator = new PokerHandComparator();
        int result = comparator.compare(hand1, hand2);
        assertTrue(result > 0);
    }
    
    @Test
    public void testEqualRank() {
        PokerHand hand1 = new PokerHand("10S JS QS KS AS");
        PokerHand hand2 = new PokerHand("10C JC QC KC AC");
        PokerHandComparator comparator = new PokerHandComparator();
        int result = comparator.compare(hand1, hand2);
        assertTrue(result == 0);
    }

}

