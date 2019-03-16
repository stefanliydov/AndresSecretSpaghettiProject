package quiz.question;

public class AlwaysTrueQuestion extends Question {

    public
    AlwaysTrueQuestion(String question, String correctAnswer, String[] wrongAnswers) {
        super(question, correctAnswer, wrongAnswers);
    }

    @Override
    public boolean isAnswerCorrect(String str) {
        return true;
    }
}
