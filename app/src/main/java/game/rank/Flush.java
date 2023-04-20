package game.rank;

import java.util.HashSet;
import java.util.Set;

public class Flush {
    public static boolean hasFlush(String hand) {
        String[] cards = hand.split(" ");
        Set<Character> suits = new HashSet<>();

        for (String card : cards) {
            char suit = card.charAt(card.length() - 1);
            suits.add(suit);
        }

        return suits.size() == 1;
    }
}
