package quiz;

import hangman.random_number_generator.RandomNumberGenerator;
import quiz.question.BSQuestion;
import quiz.question.Question;

import java.util.List;

public class Round {

    private int round;
    private LevelCreator levels;
    private static boolean first =true;
    private static boolean secondFirst = true;
    public Round(){
        this.round = 1;
        this.levels = new LevelCreator();
    }


    public Question getRoundQuestion(){
        List<Question> roundQuestions = levels.getRoundQuestions(round);

        if(round == 8 && first ){
            first = false;
            return  new BSQuestion("During the performance of the Orientalle, WHICH CHORD DID YOU FUCK UP GOD DAMN IT?!!",
                    "D7", new String[]{"Cm6", "Gsus#", "Amin7"});
        }else if(round == 10 && secondFirst){
            secondFirst = false;
            return new BSQuestion("Our incredible engineers here at InGen Software Engineering Tech Inc. spend a lot of time writing many questions?",
                    "To get the complete experience", new String[]{"there is no right answer here","Sorry","...Not sorry"},false);
        }
         return roundQuestions
                 .get(RandomNumberGenerator
                         .generate(0,roundQuestions.size()));
    }

    public int getRound() {
        return this.round;
    }

    public void increaseRound(){
        this.round++;
    }
    public boolean isGameWon(){
        return round == 13;
    }

    public void setRound(int roundSkipTo) {
        this.round =roundSkipTo;
    }
}
