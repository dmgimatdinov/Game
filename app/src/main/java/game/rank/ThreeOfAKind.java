package game.rank;

import java.util.HashMap;
import java.util.Map;

public class ThreeOfAKind {
    public static boolean hasThreeOfAKind(String hand) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : hand.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts.values().stream().anyMatch(count -> count >= 3);
    }
}
