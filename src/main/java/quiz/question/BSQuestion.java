package quiz.question;

public class BSQuestion extends Question {

    public BSQuestion(String question, String correctAnswer, String[] wrongAnswers) {
        super(question, correctAnswer, wrongAnswers);
    }
    public BSQuestion(String question, String correctAnswer, String[] wrongAnswers, boolean shuffle) {
        super(question, correctAnswer, wrongAnswers, shuffle);
    }

    @Override
    public boolean isAnswerCorrect(String str) {
        return false;
    }
}
