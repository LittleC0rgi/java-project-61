package hexlet.code.games;

import java.util.Map;

public final class EvenGame {
    public static final int MIN = 1;
    public static final int MAX = 100;

    public static void play() {
        var questionAndAnswer = buildQuestionAndAnswer();

        Engine.start(EvenGame.getRule(), questionAndAnswer.getKey(), questionAndAnswer.getValue());
    }

    private static String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    private static Map.Entry<String, String> buildQuestionAndAnswer() {
        int number = GameUtils.getRandomNumber(MIN, MAX);
        String question = String.valueOf(number);
        String answer = number % 2 == 0 ? "yes" : "no";

        return Map.entry(question, answer);
    }
}
