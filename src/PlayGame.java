package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
    public static void playGame() {
        List<List<Card>> cards = Deck.deck();
        int correctNumber = correctCards(cards);
        int correct = 0;
    }
    public static int correctCards(List<List<Card>> cards) {
        int count = 0;

        // 모든 행을 하나의 리스트로 펼침
        List<Card> flattenedCards = new ArrayList<>();
        for (List<Card> row : cards) {
            flattenedCards.addAll(row);
        }

        // 전체 리스트에서 일치하는 숫자의 쌍을 찾음
        for (int i = 0; i < flattenedCards.size(); i++) {
            for (int j = i + 1; j < flattenedCards.size(); j++) {
                if (flattenedCards.get(i).getNumber() == flattenedCards.get(j).getNumber()) {
                    count++;
                }
            }
        }

        return count;
    }
}
