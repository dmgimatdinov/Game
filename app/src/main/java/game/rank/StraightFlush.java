package game.rank;

import java.util.Arrays;

public class StraightFlush {
    public static boolean hasStraightFlush(String hand) {
        // Convert the string to an array of integers
        int[] cards = new int[5];
        for (int i = 0; i < 5; i++) {
            switch (hand.charAt(i)) {
                case 'A':
                    cards[i] = 0;
                    break;
                case '2':
                    cards[i] = 1;
                    break;
                case '3':
                    cards[i] = 2;
                    break;
                case '4':
                    cards[i] = 3;
                    break;
                case '5':
                    cards[i] = 4;
                    break;
                case '6':
                    cards[i] = 5;
                    break;
                case '7':
                    cards[i] = 6;
                    break;
                case '8':
                    cards[i] = 7;
                    break;
                case '9':
                    cards[i] = 8;
                    break;
                case 'T':
                    cards[i] = 9;
                    break;
                case 'J':
                    cards[i] = 10;
                    break;
                case 'Q':
                    cards[i] = 11;
                    break;
                case 'K':
                    cards[i] = 12;
                    break;
            }

            // Add the suit to the card value
            switch (hand.charAt(i + 5)) {
                case 'C':
                    cards[i] += 0;
                    break;
                case 'D':
                    cards[i] += 13;
                    break;
                case 'H':
                    cards[i] += 26;
                    break;
                case 'S':
                    cards[i] += 39;
                    break;
            }
        }

        // Call the helper function with the converted array
        return hasStraightFlush(cards);
    }

    public boolean hasStraightFlush(int[] hand) {
        // Sort the hand in ascending order
        Arrays.sort(hand);

        // Check if all five cards are of the same suit
        int suit = hand[0] / 13;
        for (int i = 1; i < 5; i++) {
            if (hand[i] / 13 != suit) {
                return false;
            }
        }

        // Check if the cards form a straight
        int prevCard = hand[0] % 13;
        for (int i = 1; i < 5; i++) {
            int currCard = hand[i] % 13;
            if (currCard - prevCard != 1) {
                return false;
            }
            prevCard = currCard;
        }

        return true;
    }
}
