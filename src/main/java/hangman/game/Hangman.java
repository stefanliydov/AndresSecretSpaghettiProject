package hangman.game;

import andres_game.challenges.ChallengeCompletion;
import andres_game.io.ConsoleIO;
import andres_game.io.IO;
import hangman.word_loader.FileWordLoader;
import hangman.word_loader.WordLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Hangman implements Game {

    private final WordLoader wordReader;
    public final static int TARGET_SCORE = 10;
    private final IO io;
    private int score;
    private ChallengeCompletion challenges;

    public Hangman(ChallengeCompletion challenges) {
        this(new ConsoleIO(10, 30));
        this.challenges = challenges;
    }

    public Hangman(IO io) {
        this.wordReader = new FileWordLoader();
        this.io = io;
    }

    @Override
    public void start() {
        if (score == TARGET_SCORE) {
            challenges.aComplete();
            io.write("");
            try {
                Thread.sleep(800);
                io.animateLine("> Well done, Andres, you passed successfully!");
                Thread.sleep(600);
                io.animateLine("> Here is your digit, you deserved it!");
                Thread.sleep(1000);
                io.animateLine("> > > 4 < < <");
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            io.write("");
            return;
        }
        showAvailableCategories();

        final String word = getRandomWord();
        if (word == null) {
            return;
        }
        final Map<Character, Integer> letterCount = new HashMap<>();
        int totalLetters = findLettersCounts(word, letterCount);

        playWord(word, letterCount, totalLetters);

        io.animateLine("Current score: " + score + System.lineSeparator());
        this.start();
    }

    //TODO implement an exit
    private String getRandomWord() {
        String category = io.read();
        if(category.equalsIgnoreCase("exit")){
            return null;
        }
        String word = wordReader.getRandomWordByCategory(category);
        if (Objects.isNull(word)) {
            io.animateLine("Category not found!");
            this.start();
        }
        return word;
    }

    private void playWord(String word, Map<Character, Integer> letterCount, int totalLetters) {
        final String[] result = word.replaceAll("\\w", "_").split("");
        int attemptsLeft = 6;
        while (true) {
            io.animateLine("Attempts left: " + attemptsLeft);
            io.animateLine("Current word/phrase: " + joinWord(result));
            io.animateLine("Please enter a letter:");
            final String input = io.read().trim();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                io.animateLine("Invalid Character!");
                continue;
            }

            final char letter = Character.toLowerCase(input.charAt(0));

            if (letterCount.containsKey(letter)) {
                replaceFoundLetter(word, result, letter);
                totalLetters -= letterCount.remove(letter);

                if (totalLetters == 0) {
                    io.animateLine("Congratulations you have revealed the word/phrase:");
                    io.animateLine(joinWord(result));
                    score++;
                    break;
                }
            } else {
                io.animateLine("The word/phrase doesn't have this letter.");

                if (--attemptsLeft == 0) {
                    io.animateLine("You have lost, please try again!");
                    if (score >= 1) {
                        score--;
                    }
                    break;
                }
            }
        }
    }

    private void showAvailableCategories() {
        io.animateLine("Please choose a category:");
        for (String category : wordReader.getCategories()) {
            io.animateLine(category);
        }
    }

    private String joinWord(String[] result) {
        return String.join(" ", result);
    }

    private void replaceFoundLetter(String word, String[] result, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) == letter) {
                result[i] = String.valueOf(word.charAt(i));
            }
        }
    }

    private int findLettersCounts(String word, Map<Character, Integer> letterCount) {
        int totalLetters = 0;

        for (int i = 0; i < word.length(); i++) {
            final char letter = Character.toLowerCase(word.charAt(i));
            if (letter != ' ') {
                totalLetters++;
                if (!letterCount.containsKey(letter)) {
                    letterCount.put(letter, 1);
                } else {
                    letterCount.put(letter, letterCount.get(letter) + 1);
                }
            }
        }
        return totalLetters;
    }


}
