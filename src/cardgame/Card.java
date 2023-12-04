package src.cardgame;

public class Card {
    private final int number;
    private boolean isFlipped;
    private boolean isRemoved;

    public Card(int number) {
        this.number = number;
        this.isFlipped = false;
        this.isRemoved = false;
    }

    public int getNumber() {
        return number;
    }

    public void flip() {
        this.isFlipped = !this.isFlipped;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void remove() {
        this.isRemoved = true;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
