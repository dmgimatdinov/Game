package game.rank;

import java.util.HashSet;
import java.util.Set;

public class Straight {
    public static boolean hasStraight(String hand) {
        String[] cards = hand.split(" ");
        // Use a set to store the values of each card in the hand
        Set<Integer> values = new HashSet<>();
        for (String card : cards) {
            // Get the value of the card
            int value = getValue(card);
            // Add the value to the set
            values.add(value);
        }
        // Check if there is a straight by looping through all possible starting points
        for (int start = 1; start <= 10; start++) {
            // Check if the set contains all five values from the starting point
            boolean isStraight = true;
            for (int i = 0; i < 5; i++) {
                if (!values.contains(start + i)) {
                    isStraight = false;
                    break;
                }
            }
            if (isStraight) {
                return true;
            }
        }
        return false;
    }

    // Helper function to get the value of a card
    private static int getValue(String card) {
        switch (card.charAt(0)) {
            case 'T':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;

            case 'A':
                return 14;
            default:
                return Integer.parseInt(card.substring(0, card.length() - 1));
        }
    }
}
