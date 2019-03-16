package andres_game.game;

import andres_game.challenges.ChallengeCompletion;
import andres_game.io.ConsoleIO;
import andres_game.io.IO;
import andres_game.music.MusicPlayer;
import andres_game.music.MusicTracks;
import flappy_bird.FlappyBirdsLauncher;
import flappy_bird.Game;
import hangman.game.Hangman;
import hangman.launcher.HangmanLauncher;
import quiz.QuizGame;

import java.time.LocalDateTime;

public class Story {
    private static final String EXPECTED_USER = "Andrey Ivanov Andreev";
    private static final String BOJKO_USER = "Bozhidar Rahnev Rahnev";
    private static final String STEFKO_USER = "Stefan Doychinov Lyudov";
    private static final String CHEAT_COMMAND = "hesoyam";
    private static final String CRY_BABY = "Cry Baby";
    private static final String SURPRISE = "SURPRISE";
    private static final String SKIP_TO_END_GAME = "//devSkipEndGame";
    private int attemptsLeft = 2;
    private IO io = new ConsoleIO(40, 300);
    private ChallengeCompletion challenges = new ChallengeCompletion();

    public static void main(String[] args) {
        new Story().playCredits();
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
        fetchData("> Fetching data");
        displayAndresInfo();


        animateLine("> Welcome, " + name);

        io.write("> ");
        io.write("> ");
        sleep(1000);
        animateLine("> > > Press Enter to continue < < <\n>");

        io.read();
        writeGameRules();

        choseGameMessage();

    }

    private void choseGameMessage() {
        boolean first = true;
        while (!challenges.areChallengesComplete()) {
            if (first) {
                animateLine("> You can start a challenge by entering: ");
                first = false;
            } else {
                animateLine("> You can choose a different challenge");
            }
            if (!challenges.isAChallengeIsCompleted()) {
                animateLine("> 1. \"A\"");
            }
            if (!challenges.isBChallengeIsCompleted()) {
                animateLine("> 2. \"B\"");
            }
            if (!challenges.isCChallengeIsCompleted()) {
                animateLine("> 3. \"C\"");
            }
            String chosenGame = io.read().trim();
            selectGame(chosenGame);
        }
    }

    private void fetchData(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            sleep(70);
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            sleep(330);
        }
        sleep(500);
        System.out.println();
    }

    private void writeGameRules() {
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
    }

    private void selectGame(String chosenGame) {
        if (chosenGame.equalsIgnoreCase("A") && !challenges.isAChallengeIsCompleted()) {
            animateLine("> For this challenge you need to reach " + Hangman.TARGET_SCORE + " points.");
            animateLine("> For every failed attempt you lose 1 point.");
            animateLine("> First you choose a category.");
            animateLine("> That is done by writing the category name, case doesn't matter. ");
            animateLine("> You can end the game by writing \"Exit\" in the category menu. But you will lose your score.");
            animateLine("> Good luck!");
            animateLine("> > > Press Enter to start! < < <");
            io.write("");
            io.read();
            MusicPlayer.stopMusic();
            MusicPlayer.loopGameSong(MusicTracks.HANGMAN_MUSIC);
            HangmanLauncher.launch(challenges);
            MusicPlayer.stopGameLoopSong();
            if (challenges.isAChallengeIsCompleted()) {
                playVictoryMusic();
            }
        } else if (chosenGame.equalsIgnoreCase("B") && !challenges.isBChallengeIsCompleted()) {
            MusicPlayer.stopMusic();
            MusicPlayer.loopGameSong(MusicTracks.NYAN_CAT);
            FlappyBirdsLauncher.launch(challenges);
            MusicPlayer.stopGameLoopSong();
            if (challenges.isBChallengeIsCompleted()) {
                playVictoryMusic();
            }

        } else if (chosenGame.equalsIgnoreCase("C") && !challenges.isCChallengeIsCompleted()) {
            MusicPlayer.stopMusic();
            MusicPlayer.playSound(MusicTracks.QUIZ_MAIN, false);
            try {
                Thread.sleep(2900);
                io.write("> ");
                animateTextWithDelay("> For this challenge you'd have to consult your inner knowledge.");
                animateTextWithDelay("> As of now, you've just earned your spot on the hot seat.");
                animateTextWithDelay("> The rules are simple and are as follows:");
                animateTextWithDelay("> There are 12 questions with increasing difficulty ahead of you.");
                animateTextWithDelay("> Each question has 4 possible answers - A B C or D");
                animateTextWithDelay("> You must write the corresponding letter in the console as your final answer.");
                animateTextWithDelay("> Only one of the 4 possible answers is correct. ");
                animateTextWithDelay("> (Unlike a Marcheva Biology test.)");
                animateTextWithDelay("> Be careful because you don't have lifelines or safe milestones!");
                animateTextWithDelay("> (because we couldn't be bothered with coding those in)");
                animateTextWithDelay("> If you answer incorrectly you will go right back to the start!");
                Thread.sleep(900);
                animateTextWithDelay("> Are you ready to play?");
                Thread.sleep(3500);
                animateTextWithDelay("> > > Press Enter to start! < < <");
                io.write("");
                Thread.sleep(2500);
                io.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            QuizGame.launch(challenges);
            MusicPlayer.stopGameLoopSong();
            if (challenges.isCChallengeIsCompleted()) {
                playVictoryMusic();
            }
        }
        if (challenges.areChallengesComplete()) {
            displayEndGameText();
            playCredits();
        }
        MusicPlayer.continueMusic();
    }

    private void playVictoryMusic() {
        try {
            Thread.sleep(2000);
            IO io = new ConsoleIO(110, 500);
            MusicPlayer.playSound(MusicTracks.QUEST_COMPLETE, false);
            io.write("");
            io.animateLine("Mission PASSED!");
            io.animateLine("RESPECT +");
            io.write("");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void displayAndresInfo() {
        delayWriteText(">");
        delayWriteText(">");
        delayWriteText("> Name:             " + EXPECTED_USER);
        delayWriteText("> Nationality:      Bulgaria, Varna, pc: 9000");
        delayWriteText("> Sex:              Satisfactory");
        delayWriteText("> Sex(Gender):      Male");
        delayWriteText("> Marital State:    In a relationship");
        delayWriteText("> Education: ");
        delayWriteText(">                   NUMSI \"Hristina Morfova\",");
        delayWriteText(">                   NMA \"Pancho Vladigerov\"");
        delayWriteText("> Physical\n> Characteristics:    ");
        delayWriteText(">                   Hair: Bad");
        delayWriteText(">                   Hair Colour: Brown-ish");
        delayWriteText(">                   Eyes: Brooownn...?  (Need picture for reference)");
        delayWriteText(">                   Height: 1.77m, Jumping Height: Over 2.00m");
        delayWriteText(">                   Weight: 65-ish(Give or take)kg.");
        delayWriteText("> Health:           Recurring Knee Problems");
        delayWriteText("> ");
        delayWriteText("> ");
    }

    private void delayWriteText(String str) {
        io.write(str);
        sleep(250);
    }

    private void animateTextWithDelay(String str) {
        io.animateLine(str);
        sleep(350);
    }

    private void checkUser() throws InterruptedException {
        System.out.print("> ");
        final String name = io.read().trim();
        if (name.equals(CHEAT_COMMAND)) {
            choseGameMessage();
        } else if (name.equalsIgnoreCase(CRY_BABY)) {
            Game.TARGET_HIGHSCORE = 40;
            userAccepted(name + " (" + EXPECTED_USER + ")");
        } else if (name.equalsIgnoreCase(SURPRISE)) {
            happyBirthday();

        } else if (name.equals(BOJKO_USER)) {
            displayBobeInfo();
        } else if (name.equals(STEFKO_USER)) {
            displayStefInfo();
        } else if (name.equalsIgnoreCase(SKIP_TO_END_GAME)) {
            MusicPlayer.stopMusic();
            displayEndGameText();
            playCredits();
        } else if (!name.equals(EXPECT

                ED_USER)) {
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


    private void happyBirthday() {
        io.write("");
        io.write("");
        io.write("");
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonth().getValue();
        int dayOfMonth = now.getDayOfMonth();
        if (month == 12 && dayOfMonth == 3) {
            MusicPlayer.stopMusic();
            try {
                Thread.sleep(1500);
                MusicPlayer.playMusic(MusicTracks.HAPPY_BIRTHDAY);
                Thread.sleep(2000);
                io.animateLine("> Happy Birthday, Andres!!");
                io.animateLine("> We love you and wish you all the best.");
                io.animateLine("> And since we're not very good at this, especially in english.");
                io.animateLine("> Just sit back and enjoy Stefko's glorious musical cover.");
                io.animateLine("> Cheers!");
                while (true) {

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            io.animateLine("The time is not yet right. Please try again later.");
        }


    }

    private void initializeSelfDestruct() {
        animateLine("> ACCESS DENIED");
        animateLine("> SELF-DESTRUCT PROTOCOLS INITIATED!");
        MusicPlayer.stopMusic();
        MusicPlayer.playMusic(MusicTracks.STAR_WARS_SIRENS);
        io.write("> **STARTING COUNTDOWN!!** ");
        sleep(500);
        io.write("> 3");
        sleep(1000);
        io.write("> 2");
        sleep(1000);
        io.write("> 1");
        sleep(1100);
        io.write("> **BOOM**");
        sleep(2000);
        System.exit(0);
    }

    private void animateLine(String firstline) {
        io.animateLine(firstline);
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayEndGameText() {
        try {
            MusicPlayer.playSound(MusicTracks.END_GAME_OUTRO, false);
            io.write("");
            io.write("");
            io.animateLine("> VICTORY!");
            io.animateLine("> *DRAMATIC PAUSE*");
            Thread.sleep(5000);
            animateTextWithDelay("> You have completed all challenges successfully!");
            Thread.sleep(350);
            animateTextWithDelay("> We knew you would make it!");
            Thread.sleep(350);
            animateTextWithDelay("> And we hope you had fun along the way.");
            Thread.sleep(350);
            animateTextWithDelay("> Because we certainly had a lot of fun creating it.");
            Thread.sleep(350);
            animateTextWithDelay("> The dairy and this \"software\" have been created with a lot of love (#nohomo)");
            Thread.sleep(350);
            animateTextWithDelay("> The correct positioning of the digits is: >>>674<<<");
            Thread.sleep(350);
            animateTextWithDelay("> ");
            Thread.sleep(350);
            animateTextWithDelay("> We have another secret hidden in here.");
            Thread.sleep(350);
            animateTextWithDelay("> When the time is right, don't forget to come back to the game.");
            Thread.sleep(350);
            animateTextWithDelay("> On the identity verification panel, enter \"SURPRISE\"");
            Thread.sleep(350);
            animateTextWithDelay("> :)");
            io.write("");
            io.write("");
            io.write("");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playCredits() {
        MusicPlayer.playSound(MusicTracks.END_CREDITS, false);
        try {
            io.animateLine("> Developed by:     Bozhidar Rahnev");
            io.animateLine(">                   Stefan Lyudov");
            io.write(">");
            io.animateLine("> Story by:         Stefan Lyudov");
            io.animateLine(">                   Bozhidar Rahnev");
            io.write(">");
            io.animateLine("> Lead programmer:  Stefan Lyudov");
            io.write(">");
            io.animateLine("> Sr. programmer:   Stefan Lyudov");
            io.write(">");
            io.animateLine("> Reg. programmer:  Stefan Lyudov");
            io.write(">");
            io.animateLine("> Jr. programmer:   Stefan Lyudov");
            io.write(">");
            io.animateLine("> Build engineer:   Stefan Lyudov");
            io.write(">");
            io.animateLine("> Intern coder:     Bozhidar Rahnev");
            io.write(">");
            io.animateLine("> Lines of code:    2615");
            io.animateLine(">                   2616");
            io.animateLine(">                   2617");
            io.animateLine(">                   2618");
            io.animateLine(">                   etc..");
            io.write(">");
            io.animateLine("> Music design:     Bozhidar Rahnev");
            io.animateLine(">                   Stefan Lyudov");
            io.write(">");
            io.animateLine("> Sound effects:    Bozhidar Rahnev");
            io.write(">");
            io.animateLine("> Music license:    Tritone Music");
            io.write(">");
            io.animateLine("> QA testing team:  Bozhidar Rahnev");
            io.animateLine(">                   Stefan Lyudov");
            io.write(">");
            io.animateLine("> Surveying team:   Bozhidar Rahnev");
            io.animateLine(">                   Stefan Lyudov");
            io.write(">");
            io.animateLine("> Surveyed people:  Bohidar Srahnev");
            io.animateLine(">                   Stephen Lyutov");
            io.write(">");
            io.animateLine("> Finance team:     Stefan Lyudov");
            io.animateLine(">                   Bozhidar Rahnev");
            io.write(">");
            io.animateLine("> Marketing team:   Bozhidar Rahnev");
            io.animateLine(">                   Stefan Lyudov");
            io.write(">");
            io.animateLine("> Project leads:    Bozhidar Rahnev");
            io.animateLine(">                   Stefan Lyudov");
            io.write(">");
            io.animateLine("> Director of InGen    ");
            io.animateLine("> Soft. division:   Stefan Lyudov");
            io.write(">");
            io.animateLine("> CEO of InGen:     Bozhidar Rahnev");
            io.write(">");
            io.write(">");
            Thread.sleep(1000);
            io.animateLine("> A project by InGen Software Engineering Tech.");
            io.animateLine("> Licensed under InGen Company Inc.");
            io.animateLine("> Not for sale.");

            Thread.sleep(25000);
            io.write("");
            io.animateLine("Still here?");
            io.write("");
            Thread.sleep(1000);
            io.animateLine("But why..?");
            io.write("");
            Thread.sleep(2000);
            io.animateLine("Shoo!");
            io.write("");
            Thread.sleep(3000);
            io.animateLine("There is nothing left to see.");
            io.write("");
            Thread.sleep(2000);
            io.animateLine("Was this not enough for you??");
            io.write("");
            Thread.sleep(2500);
            io.animateLine("I told you.. there is nothing more!");
            io.write("");
            Thread.sleep(2500);
            io.animateLine("Okay.. you want more?");
            io.write("");
            Thread.sleep(2000);
            io.animateLine("I'll give you more!");
            io.write("");
            Thread.sleep(3000);
            io.animateLine("For your entertainment we will read from Stefko's 9th grade history notebook");
            io.write("");
            io.animateLine("Here we go...");
            io.write("");
            Thread.sleep(1000);
            int counter = 1;
            while (true) {
                io.write("Page: " + counter);
                for (int i = 1; i <= 50; i++) {
                    System.out.print("IM BORED ");
                    if (i % 5 == 0) {
                        System.out.println();
                    }
                }
                System.out.println();
                counter++;
                Thread.sleep(700);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void displayBobeInfo() {
        System.out.println(">");
        System.out.println(">");
        System.out.println("> Name:             Bozhidar Rahnev Rahnev");
        this.sleep(150);
        System.out.println("> Nationality:      Bulgaria, Stara Zagora, pc: 6000");
        this.sleep(150);
        System.out.println("> Sex:              No Sex... No Sex at all");
        this.sleep(150);
        System.out.println("> Sex(Gender):      Male");
        this.sleep(150);
        System.out.println("> Marital State:    It's Complicated");
        this.sleep(150);
        System.out.println("> Education: ");
        this.sleep(150);
        System.out.println(">                   NUMSI \"Hristina Morfova\",");
        this.sleep(150);
        System.out.println(">                   NMA \"Pancho Vladigerov\"");
        this.sleep(150);
        System.out.println("> Physical\n> Characteristics:    ");
        this.sleep(150);
        System.out.println(">                   Hair: Woosh");
        this.sleep(150);
        System.out.println(">                   Hair Colour: Brown");
        this.sleep(150);
        System.out.println(">                   Eyes: Dark Brown");
        this.sleep(150);
        System.out.println(">                   Height: 1.86m,");
        this.sleep(150);
        System.out.println(">                   Weight: 76 kg.");
        this.sleep(150);
        System.out.println("> Health:           Fractured Lower Costal Cartilage and Ribs");
        this.sleep(150);
        System.out.println("> ");
        this.sleep(150);
        System.out.println("> ");
    }

    private void displayStefInfo() {
        System.out.println(">");
        System.out.println(">");
        System.out.println("> Name:             Stefan Doychinov Liudov");
        this.sleep(150);
        System.out.println("> Nationality:      Bulgaria, Stara Zagora, pc: 6000");
        this.sleep(150);
        System.out.println("> Sex:              Pressumed Satisfactory");
        this.sleep(150);
        System.out.println("> Sex(Gender):      Male");
        this.sleep(150);
        System.out.println("> Marital State:    In a relationship");
        this.sleep(150);
        System.out.println("> Education: ");
        this.sleep(150);
        System.out.println(">                   NUMSI \"Hristina Morfova\",");
        this.sleep(150);
        System.out.println(">                   UNWE Sofia -Canceled");
        this.sleep(150);
        System.out.println("> Physical\n> Characteristics:    ");
        this.sleep(150);
        System.out.println(">                   Hair: Floof or Palm");
        this.sleep(150);
        System.out.println(">                   Hair Colour: Brown");
        this.sleep(150);
        System.out.println(">                   Eyes: Dark Brown");
        this.sleep(150);
        System.out.println(">                   Height: 1.82m,");
        this.sleep(150);
        System.out.println(">                   Weight: 70 kg.");
        this.sleep(150);
        System.out.println("> Health:           Healthy");
        this.sleep(150);
        System.out.println("> ");
        this.sleep(150);
        System.out.println("> ");
    }
}
