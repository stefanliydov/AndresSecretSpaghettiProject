package flappy_bird;


import andres_game.challenges.ChallengeCompletion;
import andres_game.music.MusicPlayer;
import andres_game.music.MusicTracks;

import javax.swing.*;

public class FlappyBirdsLauncher {

    public static int WIDTH = 500;
    public static int HEIGHT = 540;

    public static void main(String[] args) {
        launch(new ChallengeCompletion());
    }


    public static void launch(ChallengeCompletion challenges) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        Keyboard keyboard = Keyboard.getInstance();
        frame.addKeyListener(keyboard);
        GamePanel panel = new GamePanel(frame, challenges);
        frame.add(panel);
        panel.run();

    }
}
