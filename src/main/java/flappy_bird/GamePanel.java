package flappy_bird;

import andres_game.challenges.ChallengeCompletion;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Game game;
    private JFrame frame;

    public GamePanel(JFrame frame, ChallengeCompletion challenges) {
        this.frame = frame;
        game = new Game(frame, challenges);
    }

    public void update() {
        game.update();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        for (Render r : game.getRenders())
            if (r.transform != null)
                g2D.drawImage(r.image, r.transform, null);
            else
                g.drawImage(r.image, r.x, r.y, null);


        g2D.setColor(Color.BLACK);

        if (!game.started) {
            g2D.setFont(new Font("Courier New", Font.BOLD, 30));
            g2D.drawString("Welcome",190, 70 );
            g2D.drawString("To", 230, 110);
            g2D.drawString("Flappy Andres", 140, 150);
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Press SPACE to start", 150, 240);
            g2D.drawString("To pass this challenge ", 150, 300);
            g2D.drawString("you must score at least "+Game.TARGET_HIGHSCORE+" points", 110, 330);
            g2D.setFont(new Font("Courier New", Font.BOLD, 13));
            g2D.drawString("InGen™ Software Engineering Tech Inc. ©", 165, 475);
            g2D.drawString("Build 1410 All Rights Reserved ®", 221, 485);
        } else {
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 24));
            g2D.drawString(Integer.toString(game.score), 10, 465);
            g2D.drawString("Highscore: ", 270, 465);
            g2D.drawString(Integer.toString(game.highscore), 400, 465);
        }

        if (game.gameover) {
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Press R to restart", 150, 260);
            if(game.highscore>=Game.TARGET_HIGHSCORE){
                g2D.setFont(new Font("TimesRoman", Font.BOLD, 30));
                g2D.drawString("Congrats!", 165, 150);
                g2D.drawString("Press Enter to continue!", 70, 190);
            }
        }
    }

    public void run() {
        try {
            while (true) {
                if(!frame.isActive()){
                    return;
                }
                update();
                Thread.sleep(15);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
