package flappy_bird;

import andres_game.challenges.ChallengeCompletion;
import andres_game.io.ConsoleIO;
import andres_game.io.IO;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Game {

    public static final int PIPE_DELAY = 100;
    public static int TARGET_HIGHSCORE = 150;
    private final IO io = new ConsoleIO(40,300);
    private Boolean paused;

    private int pauseDelay;
    private int restartDelay;
    private int pipeDelay;
    private Bird bird;
    private ArrayList<Pipe> pipes;
    private Keyboard keyboard;
    private JFrame frame;
    private ChallengeCompletion challenges;

    public int highscore;
    public int score;
    public Boolean gameover;
    public Boolean started;

    public Game(JFrame frame, ChallengeCompletion challenges) {
        keyboard = Keyboard.getInstance();
        this.frame = frame;
        this.challenges =challenges;
        restart();
    }

    public void restart() {
        paused = false;
        started = false;
        gameover = false;

        score = 0;
        pauseDelay = 0;
        restartDelay = 0;
        pipeDelay = 0;

        bird = new Bird();
        pipes = new ArrayList<Pipe>();
    }

    public void update() {
        watchForStart();

        if (!started)
            return;

        watchForPause();
        watchForReset();
        watchForContinue();
        watchForEsc();

        if (paused)
            return;

        bird.update();

        if (gameover)
            return;

        movePipes();
        checkForCollisions();
    }

    public ArrayList<Render> getRenders() {
        ArrayList<Render> renders = new ArrayList<Render>();
        renders.add(new Render(0, 0, "src/main/resources/lib/background.png"));
        for (Pipe pipe : pipes)
            renders.add(pipe.getRender());
        renders.add(new Render(0, 0, "src/main/resources/lib/foreground.png"));
        renders.add(bird.getRender());
        return renders;
    }

    private void watchForStart() {
        if (!started && keyboard.isDown(KeyEvent.VK_SPACE)) {
            started = true;
        }
    }

    private void watchForPause() {
        if (pauseDelay > 0)
            pauseDelay--;

        if (keyboard.isDown(KeyEvent.VK_P) && pauseDelay <= 0) {
            paused = !paused;
            pauseDelay = 10;
        }
    }

    private void watchForReset() {
        if (restartDelay > 0)
            restartDelay--;

        if (keyboard.isDown(KeyEvent.VK_R) && restartDelay <= 0) {
            restart();
            restartDelay = 10;
            return;
        }
    }

    private void watchForContinue() {
        if (keyboard.isDown(KeyEvent.VK_ENTER)) {

            if (highscore >= TARGET_HIGHSCORE) {
                this.challenges.bComplete();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                io.animateLine("> Well done, Andres, your patience has been tested, you're worthy!");
                io.animateLine("> Here is your digit, you deserved it!");
                io.animateLine("> > > 7 < < <");
            }
        }
    }
    private void watchForEsc(){
        if( keyboard.isDown(KeyEvent.VK_ESCAPE)){
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }


    private void movePipes() {
        pipeDelay--;

        if (pipeDelay < 0) {
            pipeDelay = PIPE_DELAY;
            Pipe northPipe = null;
            Pipe southPipe = null;

            // Look for pipes off the screen
            for (Pipe pipe : pipes) {
                if (pipe.x - pipe.width < 0) {
                    if (northPipe == null) {
                        northPipe = pipe;
                    } else if (southPipe == null) {
                        southPipe = pipe;
                        break;
                    }
                }
            }

            if (northPipe == null) {
                Pipe pipe = new Pipe("north");
                pipes.add(pipe);
                northPipe = pipe;
            } else {
                northPipe.reset();
            }

            if (southPipe == null) {
                Pipe pipe = new Pipe("south");
                pipes.add(pipe);
                southPipe = pipe;
            } else {
                southPipe.reset();
            }

            northPipe.y = southPipe.y + southPipe.height + 145;
        }

        for (Pipe pipe : pipes) {
            pipe.update();
        }
    }

    private void checkForCollisions() {

        for (Pipe pipe : pipes) {
            if (pipe.collides(bird.x, bird.y, bird.width, bird.height)) {
                gameover = true;
                bird.dead = true;
                if (highscore < score) {
                    highscore = score;
                }
            } else if (pipe.x == bird.x && pipe.orientation.equalsIgnoreCase("south")) {
                score++;
            }
        }

        // Ground + Bird collision
        if (bird.y + bird.height > FlappyBirdsLauncher.HEIGHT - 80) {
            gameover = true;
            if (highscore < score) {
                highscore = score;
            }
            bird.y = FlappyBirdsLauncher.HEIGHT - 80 - bird.height;
        }
    }

}
