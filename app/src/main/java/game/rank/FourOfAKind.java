package game.rank;

public class FourOfAKind {
    public static boolean hasFourOfAKind(String hand) {
        String[] cards = hand.split(" ");
        int[] cardValues = new int[cards.length];

        for (int i = 0; i < cards.length; i++) {
            cardValues[i] = getCardValue(cards[i]);
        }

        for (int i = 0; i < cardValues.length; i++) {
            int count = 0;
            for (int j = 0; j < cardValues.length; j++) {
                if (cardValues[i] == cardValues[j]) {
                    count++;
                }
            }
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    private static int getCardValue(String card) {
        switch (card.charAt(0)) {
            case 'A':
                return 14;
            case 'K':
                return 13;
            case 'Q':
                return 12;
            case 'J':
                return 11;
            default:
                return Integer.parseInt(card.substring(0, 1));
        }
    }
}
