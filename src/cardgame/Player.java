package src.cardgame;

public class Player {
    private String name;
    private int score;
    private int combo;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.combo = 1;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementCombo() {
        this.combo *= 2;
    }

    public void resetCombo() {
        this.combo = 1;
    }

    public void addScore() {
        this.score += (10 * this.combo);
    }
}
