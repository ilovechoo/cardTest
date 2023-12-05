package src.main;

import src.cardgame.GameController;

public class MainGame {
    public static void main(String[] args) {
        GameController game = new GameController(); // PlayGame 객체 생성
        game.playGame(); // 객체를 통해 playGame 메소드 호출
    }
}
