package flappy_bird;


import javax.swing.*;

public class FlappyBirdsLauncher {

    public static int WIDTH = 500;
    public static int HEIGHT = 540;

    public static void main(String[] args) {
        launch();
    }


    public static void launch() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        Keyboard keyboard = Keyboard.getInstance();
        frame.addKeyListener(keyboard);

        GamePanel panel = new GamePanel(frame);
        frame.add(panel);

    }
}
