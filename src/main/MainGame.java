package src.main;

import src.cardgame.PlayGame;

public class MainGame {
    public static void main(String[] args) {
        PlayGame game = new PlayGame(); // PlayGame 객체 생성
        game.playGame(); // 객체를 통해 playGame 메소드 호출
    }
}
