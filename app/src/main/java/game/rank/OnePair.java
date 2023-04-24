package game.rank;

import java.util.HashMap;

public class OnePair {
    public static boolean hasOnePair(String hand) {
        String[] cards = hand.split(" ");
        if (cards.length != 5) {
            return false;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String cardTmp : cards) {
            String card = String.valueOf(cardTmp.charAt(0));
            if (map.containsKey(card)) {
                map.put(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }
        }
        int count = 0;
        for (int value : map.values()) {
            if (value == 2) {
                count++;
            }
        }
        return count == 1;
    }
}
