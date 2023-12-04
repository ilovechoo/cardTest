package src.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    // 셔플된 카드 덱을 반환하는 메소드
    public static List<List<Card>> deck() {
        // 카드 덱 초기화
        List<Card> cards = initializeDeck();

        // 카드 덱 셔플
        shuffleDeck(cards);

        // 2차원 배열로 정리된 카드 덱 반환
        return arrangeCards(cards);
    }

    // 초기화된 카드 덱을 반환하는 메소드
    private static List<Card> initializeDeck() {
        List<Card> cards = new ArrayList<>();

        // 1부터 8까지의 숫자를 각각 3번씩 가지고 있는 카드 덱 생성
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 9; j++) {
                cards.add(new Card(j));
            }
        }

        return cards;
    }

    // 카드 덱을 셔플하는 메소드
    private static List<Card> shuffleDeck(List<Card> cards) {
        // Collections 클래스의 shuffle 메소드를 이용하여 카드 덱을 섞음
        Collections.shuffle(cards);
        return cards;
    }

    // 섞인 카드 덱을 2차원 배열로 정리하는 메소드
    private static List<List<Card>> arrangeCards(List<Card> cards) {
        // 2차원 배열로 정리된 카드 덱을 저장할 리스트
        List<List<Card>> arrangedCards = new ArrayList<>();
        int index = 0;

        // 3행 6열의 형태로 카드를 정리
        for (int i = 0; i < 3; i++) {
            List<Card> row = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                // 셔플된 카드 덱에서 순서대로 카드를 가져와 행에 추가
                row.add(cards.get(index++));
            }
            // 현재 행을 2차원 배열에 추가
            arrangedCards.add(row);
        }

        return arrangedCards;
    }
}
