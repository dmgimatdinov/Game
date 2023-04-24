package game.rank;

import java.util.HashMap;
import java.util.Map;

public class ThreeOfAKind {
    public static boolean hasThreeOfAKind(String hand) {
        String[] cards = hand.split(" "); // split the hand into individual cards

        // check if there are 5 cards in the hand
        if (cards.length != 5) {
            return false;
        }

        // create a map to store the count of each card rank
        Map<String, Integer> rankCount = new HashMap<>();
        for (String card : cards) {
            String rank = card.substring(0, 1); // get the rank of the card
            int count = rankCount.getOrDefault(rank, 0); // get the current count or default to 0
            rankCount.put(rank, count + 1); // update the count
        }

        boolean threeOfAKind = false;
        for (int count : rankCount.values()) {
            if (count == 3) {
                threeOfAKind = true;
            }
        }

        return threeOfAKind;
    }
}
