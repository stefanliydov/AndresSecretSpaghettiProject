package quiz;

import andres_game.challenges.ChallengeCompletion;
import andres_game.io.ConsoleIO;
import andres_game.io.IO;
import andres_game.music.MusicPlayer;
import andres_game.music.MusicTracks;
import hangman.random_number_generator.RandomNumberGenerator;
import quiz.question.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizGame {


    private static IO io;
    private static final List<String> correctAnswers;
    private static final List<String> wrongAnswers;
    private static boolean isFirst = true;
    private static Round round = new Round();

    static {
        correctAnswers = new ArrayList<>();
        wrongAnswers = new ArrayList<>();

        correctAnswers.add("Your answer is correct!");
        correctAnswers.add("That is correct!");
        correctAnswers.add("You're right, brilliant indeed!");
        correctAnswers.add("Gg,wp Andres, correct!");
        correctAnswers.add("Correct, what an amazing game, Andres, keep it up!");
        correctAnswers.add("You chose correctly!");
        correctAnswers.add("That is indeed correct, mr. Andres!");
        correctAnswers.add("Wow, you are right!");
        correctAnswers.add("Amazing, how did you know that?!");
        correctAnswers.add("Awesome, that was actually tricky!");
        correctAnswers.add("Damn it! I was sure you wouldn't know that one! Congrats");
        correctAnswers.add("Did you really know that or was it luck? Either way you're correct!");
        correctAnswers.add("Pff, just a lucky guess!");


        wrongAnswers.add("How do you not know that? WRONG!");
        wrongAnswers.add("WRONG!");
        wrongAnswers.add("I'm sorry, but you gotta start over :/. Incorrect!");
        wrongAnswers.add("Your answer was incorrect!");
        wrongAnswers.add("This is not the right answer!");
        wrongAnswers.add("That was actually an easy one.. SHAME!");

    }

    public static void launch(ChallengeCompletion challenges) {

        MusicPlayer.stopGameLoopSong();
        io = new ConsoleIO(28, 600);

        while (true) {
            final int roundCount = round.getRound();


            if (roundCount == 1) {
                playBackGroundOne();
            } else if (roundCount == 6) {
                playBackGroundSix();
            } else if (roundCount == 9) {
                playBackGroundNine();
            } else if (roundCount == 12) {
                playBackGroundTwelve();
            }
            Question question = round.getRoundQuestion();
            io.animateLineBySeparatingIt(roundCount + ". " + question.toString());
            io.write("");
            String answer = io.read();
            round.increaseRound();

            if (roundCount >= 9) {
                playSelectSound(roundCount);
            } else {
                try {
                    Thread.sleep(roundCount * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            if (roundCount == 11) {
                playAd();
            }
            if (question.isAnswerCorrect(answer)) {
                playCorrectAnswerSound(roundCount);
                if (round.isGameWon()) {
                    displayEndGameText(challenges);
                    return;
                }
                io.animateLine(getCorrectAnswerResponse());
            } else {

                gameOver(challenges);
                break;
            }
        }


    }

    private static void displayEndGameText(ChallengeCompletion challenges) {
        challenges.cComplete();
        playCorrectAnswerSound(12);
        io.write("");
        try {
            io.animateLine("> Well done, Andres, you've successfully climbed the ladder of our quiz.");
            Thread.sleep(100);
            io.animateLine("> That last question was tough, a?");
            Thread.sleep(100);
            io.animateLine("> I mean.. we certainly didn't know the answer.");
            Thread.sleep(100);
            io.animateLine("> We just guessed.");
            Thread.sleep(100);
            io.animateLine("> Honestly, they were all correct (in reality- all, probably, wrong).");
            Thread.sleep(100);
            io.animateLine("> We pulled a sneaky on you too, there were questions with only wrong answers. ");
            Thread.sleep(100);
            io.animateLine("> ");
            Thread.sleep(500);


            io.animateLine("> Congratulations on your victory, Andres, you're truly all knowing.");
            Thread.sleep(400);
            io.animateLine("> (Knowing useless info that is)");
            Thread.sleep(400);
            io.animateLine("> Here is your digit, you deserved it!");
            Thread.sleep(500);
            io.animateLine("> > > 6 < < <");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void playSelectSound(final int roundCount) {
        MusicPlayer.stopGameLoopSong();
        switch (roundCount) {
            case 9:
                MusicPlayer.playSound(MusicTracks.QUIZ_SELECT_NINE, true);
                break;
            case 10:
                MusicPlayer.playSound(MusicTracks.QUIZ_SELECT_TEN, true);
                break;
            case 11:
                MusicPlayer.playSound(MusicTracks.QUIZ_SELECT_ELEVEN, true);
                break;
            case 12:
                MusicPlayer.playSound(MusicTracks.QUIZ_SELECT_TWELVE, true);
                break;
            default:
                break;
        }
        playOnlyBackGroundNine();
    }

    private static void playOnlyBackGroundNine() {
        MusicPlayer.loopGameSong(MusicTracks.BACKGROUND_NINE_TO_ELEVEN);
    }

    private static void playLoseSound() {
        MusicPlayer.stopGameLoopSong();
        MusicPlayer.playSound(MusicTracks.QUIZ_LOSE, false);
    }

    private static void playCorrectAnswerSound(int roundCount) {
        if (roundCount <= 8) {
            MusicPlayer.playSound(MusicTracks.QUIZ_CORRECT_ONE_TO_EIGTH, false);
        } else if (roundCount <= 11) {
            MusicPlayer.playSound(MusicTracks.QUIZ_CORRECT_NINE_TO_ELEVEN, false);
        } else {
            MusicPlayer.stopGameLoopSong();
            MusicPlayer.playSound(MusicTracks.QUIZ_CORRECT_TWELVE,false);
        }
    }

    private static void playBackGroundTwelve() {
        playBetweenBackGround();
        displayTextBeforeTwelve();
        MusicPlayer.loopGameSong(MusicTracks.BACKGROUND_TWELVE);
    }

    private static void playBackGroundNine() {
        playBetweenBackGround();
        displayTextBeforeNine();
        MusicPlayer.loopGameSong(MusicTracks.BACKGROUND_NINE_TO_ELEVEN);
    }

    private static void playBackGroundSix() {
        playBetweenBackGround();
        displayTextBeforeSix();
        MusicPlayer.loopGameSong(MusicTracks.BACKGROUND_SIX_TO_EIGTH);
    }

    private static void playBackGroundOne() {
        MusicPlayer.loopGameSong(MusicTracks.BACKGROUND_ONE_TO_FIVE);
    }

    private static void playAd() {
        if (isFirst) {
            MusicPlayer.stopGameLoopSong();
            MusicPlayer.playSound(MusicTracks.QUIZ_BEFORE_AD, false);
            displayBeforeAdText();
            MusicPlayer.playSound(MusicTracks.ANDRES_AD, true);
            isFirst = false;
        }

    }

    private static void displayBeforeAdText() {
        io.animateLine("Stay tuned to find out if Andres was correct.");
        io.animateLine("Right after the break!");
        try {
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void displayTextBeforeTwelve() {
        io.animateLine("Alright!! You climbed the ladder");
        io.animateLine("Although we expected it would take you just one attempt...");
        io.animateLine("Anyway...");
        io.animateLine("Congratulations are in order.");
        io.animateLine("BUT.");
        io.animateLine("Are you ready to take the final question?");
        io.write("\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void displayTextBeforeSix() {
        io.animateLine("Alright, Good job!");
        io.animateLine("You passed through a the first few questions.");
        io.animateLine("You are showing remarkable wit and knowledge, congratulations!");
        io.animateLine("The following questions will get harder as you go.");
        io.animateLine("Feel ready?");
        io.write("\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void displayTextBeforeNine() {
        io.animateLine("Amazing work!");
        io.animateLine("Your knowledge is remarkable!");
        io.animateLine("You are plowing through the questions with ease!");
        io.animateLine("Beware though... It will get even harder.");
        io.animateLine("Think carefully before you answer!");
        io.animateLine("Ready to begin?");
        io.write("\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void gameOver(ChallengeCompletion challenges) {
        playLoseSound();
        io.animateLine(getWrongAnswerResponse());
        round = new Round();
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            io.animateLine("Press Enter to restart or type B to go back!");
            String read = io.read().trim();
            if (read.toUpperCase().equals("B")) {
                return;
            } else if (read.equals("")) {
                launch(challenges);
                return;
            } else if (read.startsWith("//devSkipCheat")) {
                int roundSkipTo = Integer.parseInt(read.split(" ")[1]);
                round.setRound(roundSkipTo);
                launch(challenges);
                return;
            }
        }
    }

    private static String getCorrectAnswerResponse() {
        int generate = RandomNumberGenerator.generate(0, correctAnswers.size());
        return correctAnswers.get(generate) + "\n\n";
    }

    private static String getWrongAnswerResponse() {
        int generate = RandomNumberGenerator.generate(0, wrongAnswers.size());
        return wrongAnswers.get(generate) + "\n\n";
    }

    private static void playBetweenBackGround() {
        MusicPlayer.stopGameLoopSong();
        MusicPlayer.playSound(MusicTracks.QUIZ_BETWEEN_BACKGROUND_CHANGE, false);
    }

    public static void disableAd() {
        isFirst = false;
    }

}
