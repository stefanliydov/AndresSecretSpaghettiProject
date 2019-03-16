package hangman.launcher;


import hangman.game.Game;
import hangman.game.Hangman;

public class HangmanLauncher {
    public static void main(String[] args) {
        launch();
    }
    public static void launch() {
        Game game = new Hangman();
        game.start();
    }
}
