package hexlet.code.games;

import java.util.Map;

public final class GCDGame {
    public static final int MIN = 1;
    public static final int MAX = 100;

    public static void play() {
        var questionAndAnswer = buildQuestionAndAnswer();

        Engine.start(GCDGame.getRule(), questionAndAnswer.getKey(), questionAndAnswer.getValue());
    }

    public static String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    private static Map.Entry<String, String> buildQuestionAndAnswer() {
        int a = GameUtils.getRandomNumber(MIN, MAX);
        int b = GameUtils.getRandomNumber(MIN, MAX);

        String question = a + " " + b;
        String answer = String.valueOf(gcd(a, b));

        return Map.entry(question, answer);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
