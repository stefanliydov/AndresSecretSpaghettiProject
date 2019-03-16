package flappy_bird;

import flappy_bird.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private Game game;

    public GamePanel(JFrame frame) {
        game = new Game(frame);
        Thread thread = new Thread(this);
        try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        thread.start();
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
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Press SPACE to start", 150, 240);
            g2D.drawString("To pass this challenge ", 150, 300);
            g2D.drawString("you must score at least "+Game.TARGET_HIGHSCORE+" points", 100, 330);
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
                g2D.drawString("Congrats! Press Enter to continue!", 90, 240);
            }
        }
    }

    public void run() {
        try {
            while (true) {
                update();
                Thread.sleep(25);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
