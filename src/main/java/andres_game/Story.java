package andres_game;

import andres_game.music.MusicTracks;
import flappy_bird.FlappyBirdsLauncher;

import java.util.Scanner;

import andres_game.music.MusicPlayer;

public class Story {
    private static final String EXPECTED_USER = "Andrey Ivanov Andreev";
    private int attemptsLeft = 2;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        new Story().engageStory();
    }


    public void engageStory() throws InterruptedException {
        MusicPlayer.playMusic(MusicTracks.MATRIX_TRACK);

        animateLine("> Hello, you have activated the Top Secret Diary Code Breaker(v2.213)");
        animateLine("> In order to procede, we must first confirm your identity.");
        animateLine("> Please identify yourself!");

        checkUser();


    }

    private void userAccepted(String name) throws InterruptedException {
        //TODO DOTS TO BE DISPLAYED SLOWER
        animateLine("> Fetching data...");
        displayAndresInfo();


        animateLine("> Welcome, " + name);

        System.out.println("> ");
        System.out.println("> ");
        sleep(1000);
        animateLine("> > > Press Enter to continue < < <");
        scanner.nextLine();

        animateLine("> This software has been designed to test your worth and patience");
        animateLine("> ");
        animateLine("> **We know you have a lot of the latter :)**");
        animateLine("> ");
        animateLine("> Ahead of you are three separate challenges awaiting");
        animateLine("> You can complete them in any order you wish");
        animateLine("> Successfully finishing a challenge will give you a single digit");
        animateLine("> You won't know which digit is in what position");
        animateLine("> So you have to complete all three");
        animateLine("> ");
        animateLine("> **We know you're a f*cking completionist**");
        animateLine("> ");
        animateLine("> ");
        animateLine("> You can start a challenge by entering: ");
        animateLine("> 1. \"A\"");
        animateLine("> 2. \"B\"");
        animateLine("> 3. \"C\"");
        scanner.nextLine();
        FlappyBirdsLauncher.launch();
        System.out.println("> Congrats on winning the first challenge!");
    }

    private void displayAndresInfo() {
        System.out.println(">");
        System.out.println(">");
        System.out.println("> Name:             "+ EXPECTED_USER);
        sleep(150);
        System.out.println("> Nationality:      Bulgaria, Varna, pc: 9000");
        sleep(150);
        System.out.println("> Sex:              Satisfactory");
        sleep(150);
        System.out.println("> Sex(Gender):      Male");
        sleep(150);
        System.out.println("> Marital State:    In a relationship");
        sleep(150);
        System.out.println("> Education: ");
        sleep(150);
        System.out.println(">                   NUMSI \"Hristina Morfova\",");
        sleep(150);
        System.out.println(">                   NMA \"Pancho Vladigerov\"" );
        sleep(150);
        System.out.println("> Physical\n> Characteristics:    ");
        sleep(150);
        System.out.println(">                   Hair: Bad");
        sleep(150);
        System.out.println(">                   Hair Colour: Brown-ish");
        sleep(150);
        System.out.println(">                   Eyes: Brooownn...?  (Need picture for reference)");
        sleep(150);
        System.out.println(">                   Height: 1.77m, Jumping Height: Over 2.00m");
        sleep(150);
        System.out.println(">                   Weight: 65-ish(Give or take)kg.");
        sleep(150);
        System.out.println("> Health:           Recurring Knee Problems");
        sleep(150);
        System.out.println("> ");
        sleep(150);
        System.out.println("> ");
    }



    private void checkUser() throws InterruptedException {
        System.out.print("> ");
        final String name = scanner.nextLine();
        if (!name.equals(EXPECTED_USER)) {
            if (attemptsLeft == 1) {
                initializeSelfDestruct();
            }
            attemptsLeft--;
            animateLine("> Stated name: " + name + " -does not match the database. Please check for spelling errors.");
            animateLine("> " + attemptsLeft + " attempt left before self-destruct protocols are activated!");

            checkUser();
        } else {
            //TODO Change return type
            userAccepted(name);
        }

    }

    private void initializeSelfDestruct() throws InterruptedException {
        animateLine("> ACCESS DENIED");
        animateLine("> SELF-DESTRUCT PROTOCOLS INITIATED!");
        MusicPlayer.stopMusic();
        MusicPlayer.playMusic(MusicTracks.STAR_WARS_SIRENS);
        System.out.println("> **STARTING COUNTDOWN!!** ");
        sleep(500);
        System.out.println("> 3");
        sleep(1000);
        System.out.println("> 2");
        sleep(1000);
        System.out.println("> 1");
        sleep(1100);
        System.out.println("> **BOOM**");
        sleep(2000);
        System.exit(0);
    }

    private void animateLine(String firstline) {
        for (int i = 0; i < firstline.length(); i++) {
            System.out.print(firstline.charAt(i));
            sleep(40);

        }
        sleep(300);
        System.out.println();
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
