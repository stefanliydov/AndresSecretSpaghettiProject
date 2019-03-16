package quiz.question;

import hangman.random_number_generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {
    private String question;
    private int rightAnswerLetter;
    private List<String> answers;
    private boolean shuffle =true;
    public Question(String question, String correctAnswer, String[] wrongAnswers) {
        this.question = question;
        this.answers = new ArrayList<>();
        this.generateAnswerList(correctAnswer, wrongAnswers);
    }
    public Question(String question, String correctAnswer, String[] wrongAnswers, boolean shuffle) {
        this.question = question;
        this.answers = new ArrayList<>();
        this.shuffle = shuffle;
        this.generateAnswerList(correctAnswer, wrongAnswers);
    }

    private void generateAnswerList(String correctAnswer, String[] wrongAnswers) {
        answers.addAll(Arrays.asList(wrongAnswers));
        if(shuffle) {
            Collections.shuffle(answers);
            rightAnswerLetter = RandomNumberGenerator.generate(0, 4);
            answers.add(rightAnswerLetter, correctAnswer);
        }else{
            answers.add(0, correctAnswer);
        }
        for (int i = 65; i < 69; i++) {
            answers.set(i % 65, ((char) i) + ": " + answers.get(i % 65));
        }
    }

     public boolean isAnswerCorrect(String str){
        if(str.isEmpty()){
            return false;
        }
        return rightAnswerLetter == ((int) str.toUpperCase().charAt(0)-65);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(question);
        for (String answer : answers) {
            sb.append(System.lineSeparator()).append(answer);
        }
       // sb.append(System.lineSeparator());
        return sb.toString();
    }

}
