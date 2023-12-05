package src.cardgame;

public class InputHandler {
    public static int[] parseCoords(String input) {
        String[] parts = input.replaceAll("\\(|\\)", "").trim().split("\\s*,\\s*");
        int row = Integer.parseInt(parts[0]) - 1;
        int col = Integer.parseInt(parts[1]) - 1;
        return new int[]{row, col};
    }

    public static boolean isValidCoords(int[] coords) {
        if(coords[0] < 0 || coords[0] > 2 || coords[1] < 0 || coords[1] > 5) {
            System.out.println("첫 번째 좌표는 1 ~ 3, 두 번째 좌표는 1 ~ 6 사이의 숫자만 입력 가능합니다.");
            return false;
        }
        return true;
    }
}
