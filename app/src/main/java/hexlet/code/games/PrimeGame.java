package hexlet.code.games;

import java.util.Map;

public final class PrimeGame {
    public static final int MIN = 1;
    public static final int MAX = 100;

    public static void play() {
        var questionAndAnswer = buildQuestionAndAnswer();

        Engine.start(PrimeGame.getRule(), questionAndAnswer.getKey(), questionAndAnswer.getValue());
    }

    private static String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    private static Map.Entry<String, String> buildQuestionAndAnswer() {
        int number = GameUtils.getRandomNumber(MIN, MAX);
        String question = String.valueOf(number);
        String answer = isPrime(number) ? "yes" : "no";

        return Map.entry(question, answer);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
