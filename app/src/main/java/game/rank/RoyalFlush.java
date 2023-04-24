package game.rank;

public class RoyalFlush {
    // Check for a Royal Flush
    public static boolean hasRoyalFlush(String hand) {
        // Check if the hand contains an Ace, King, Queen, Jack and 10 of the same suit
        String[] cards = hand.split(" ");
        boolean hasAce = false;
        boolean hasKing = false;
        boolean hasQueen = false;
        boolean hasJack = false;
        boolean hasTen = false;
        String suit = null;

        for (String card : cards) {
            if (card.startsWith("A")) {
                hasAce = true;
                suit = card.substring(1);
            } else if (card.startsWith("K")) {
                hasKing = true;
                if (suit == null) {
                    suit = card.substring(1);
                } else if (!suit.equals(card.substring(1))) {
                    return false;
                }
            } else if (card.startsWith("Q")) {
                hasQueen = true;
                if (suit == null) {
                    suit = card.substring(1);
                } else if (!suit.equals(card.substring(1))) {
                    return false;
                }
            } else if (card.startsWith("J")) {
                hasJack = true;
                if (suit == null) {
                    suit = card.substring(1);
                } else if (!suit.equals(card.substring(1))) {
                    return false;
                }
            } else if (card.startsWith("T")) {
                hasTen = true;
                if (suit == null) {
                    suit = card.substring(1);
                } else if (!suit.equals(card.substring(1))) {
                    return false;
                }
            }
        }

        return hasAce && hasKing && hasQueen && hasJack && hasTen;
    }
}
