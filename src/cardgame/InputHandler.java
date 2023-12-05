package src.cardgame;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] parseCoords(String input) {
        String[] parts = input.replaceAll("\\(|\\)", "").trim().split("\\s*,\\s*");
        int row = Integer.parseInt(parts[0]) - 1;
        int col = Integer.parseInt(parts[1]) - 1;
        return new int[]{row, col};
    }

    public static int[] getValidCoords() {
        int[] coords;
        do {
            System.out.print("입력 (예: 1,2): ");
            String input = scanner.nextLine();

            try {
                coords = parseCoords(input);
                if (!isValidCoords(coords)) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("유효하지 않은 입력입니다. 좌표는 1 ~ 3, 1 ~ 6 사이의 숫자여야 합니다.");
                coords = null;
            }
        } while (coords == null);

        return coords;
    }

    private static boolean isValidCoords(int[] coords) {
        return coords != null && coords[0] >= 0 && coords[0] <= 2 && coords[1] >= 0 && coords[1] <= 5;
    }
}
