package src.cardgame;

import java.util.List;

public class BoardPrinter {
    public static void printBoard(List<List<Card>> cards) {
        for (List<Card> row : cards) {
            for (Card card : row) {
                if (card.isRemoved()) {
                    System.out.print("  ");
                } else if (card.isFlipped()) {
                    System.out.print(card + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
