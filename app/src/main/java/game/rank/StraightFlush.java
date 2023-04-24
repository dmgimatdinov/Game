package game.rank;

import java.util.Arrays;

public class StraightFlush {
    public static boolean hasStraightFlush(String hand) {
        // Convert the string to an array of integers
        int[] cards = new int[5];
        String[] strCards = hand.split(" ");
        for (int i = 0; i < 5; i++) {
            switch (strCards[i].substring(0).charAt(0)) {
                case '2':
                    cards[i] = 2;
                    break;
                case '3':
                    cards[i] = 3;
                    break;
                case '4':
                    cards[i] = 4;
                    break;
                case '5':
                    cards[i] = 5;
                    break;
                case '6':
                    cards[i] = 6;
                    break;
                case '7':
                    cards[i] = 7;
                    break;
                case '8':
                    cards[i] = 8;
                    break;
                case '9':
                    cards[i] = 9;
                    break;
                case 'T':
                    cards[i] = 10;
                    break;
                case 'J':
                    cards[i] = 11;
                    break;
                case 'Q':
                    cards[i] = 12;
                    break;
                case 'K':
                    cards[i] = 13;
                    break;
                case 'A':
                    cards[i] = 14;
                    break;
            }

            // Add the suit to the card value
            switch (strCards[i].substring(1).charAt(0)) {
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

    public static boolean hasStraightFlush(int[] hand) {
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
