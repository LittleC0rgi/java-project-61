package hexlet.code.games;

public interface Game {
    String getRule();

    String getQuestion();

    String getCorrectAnswer(String question);
}
