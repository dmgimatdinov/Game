package game.rank;

import java.util.HashMap;

public class OnePair {
    public static boolean hasOnePair(String hand) {
        String[] cardArray = hand.split(" "); // get array of cards
        HashMap<Integer, Integer> mapOfCards = new HashMap<>(); // map to store rank and count
        // go through the cards and record their rank in the map
        for (String card : cardArray) {
            int rank = Integer.parseInt(card.substring(0, card.length() - 1));
            if (mapOfCards.containsKey(rank)) {
                int count = mapOfCards.get(rank);
                mapOfCards.put(rank, count + 1);
            } else {
                mapOfCards.put(rank, 1);
            }
        }
        // check if any of the ranks appears 2 times
        for (int rank : mapOfCards.keySet()) {
            if (mapOfCards.get(rank) == 2) {
                return true;
            }
        }
        return false;
    }
}
