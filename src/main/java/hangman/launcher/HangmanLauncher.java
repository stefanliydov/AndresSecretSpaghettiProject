package hangman.launcher;


import andres_game.challenges.ChallengeCompletion;
import hangman.game.Game;
import hangman.game.Hangman;

public class HangmanLauncher {
    public static void main(String[] args) {
        launch(new ChallengeCompletion());
    }
    public static void launch(ChallengeCompletion challenges) {
        Game game = new Hangman(challenges);
        game.start();
    }
}
