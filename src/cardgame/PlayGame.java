package src.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1P 이름을 입력하세요: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("2P 이름을 입력하세요: ");
        Player player2 = new Player(scanner.nextLine());

        List<List<Card>> cards = Deck.deck();
        int correctNumber = correctCards(cards);
        int attempts = 0;
        int remainPairs = 8;
        int correct = 0;

        Player currentPlayer = player1;

        while (remainPairs > 0 && correct != correctNumber) {
            printBoard(cards);
            System.out.printf("<%s의 차례, 시도 %d, 남은 카드: %d> 좌표를 두 번 입력하세요.%n", currentPlayer.getName(), attempts + 1, remainPairs * 2);

            int[] firstCoords;
            do {
                System.out.print("입력 1? ");
                firstCoords = parseCoords(scanner.nextLine());
            } while (!isValidCoords(firstCoords));

            int[] secondCoords;
            do {
                System.out.print("입력 2? ");
                secondCoords = parseCoords(scanner.nextLine());
            } while (!isValidCoords(secondCoords));

            Card firstCard = cards.get(firstCoords[0]).get(firstCoords[1]);
            Card secondCard = cards.get(secondCoords[0]).get(secondCoords[1]);

            firstCard.flip();
            secondCard.flip();
            printBoard(cards);

            if (firstCard.getNumber() == secondCard.getNumber()) {
                System.out.println("일치하는 카드를 찾았습니다!");
                firstCard.remove();
                secondCard.remove();
                correct++;
                remainPairs--;

                currentPlayer.addScore();
                currentPlayer.incrementCombo();
            } else {
                System.out.println("일치하지 않는 카드입니다.");
                firstCard.flip();
                secondCard.flip();

                currentPlayer.resetCombo();
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
            attempts++;
        }

        Player winner = (player1.getScore() > player2.getScore()) ? player1 : player2;
        System.out.printf("게임 종료! %s 승리! %s: %d점, %s: %d점%n", winner.getName(), player1.getName(), player1.getScore(), player2.getName(), player2.getScore());
    }
    private static void printBoard(List<List<Card>> cards) {
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

    private static int[] parseCoords(String input) {
        String[] parts = input.replaceAll("\\(|\\)", "").trim().split("\\s*,\\s*");
        int row = Integer.parseInt(parts[0]) - 1;
        int col = Integer.parseInt(parts[1]) - 1;
        return new int[]{row, col};
    }

    private static boolean isValidCoords(int[] coords) {
        if(coords[0] < 0 || coords[0] > 2 || coords[1] < 0 || coords[1] > 5) {
            System.out.println("첫 번째 좌표는 1 ~ 3, 두 번째 좌표는 1 ~ 6 사이의 숫자만 입력 가능합니다.");
            return false;
        }
        return true;
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

