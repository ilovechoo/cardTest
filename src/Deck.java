package src;

import java.util.ArrayList;
import java.util.List;

public class Deck {
//    public static List<Card>> deck() {
//        List<Card> cards = initializeDeck();
//        return cards;
//    }
    private static List<Card> initializeDeck() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 9; j++) {
                cards.add(new Card(j));
            }
        }
        return cards;
    }
}
