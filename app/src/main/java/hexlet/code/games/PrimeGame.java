package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class PrimeGame {
    private static final int MIN = 1;
    private static final int MAX = 100;

    public static String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @SuppressWarnings("java:S2245")
    public static String getQuestion() {
        int number = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        return String.valueOf(number);
    }

    public static String getCorrectAnswer(String question) {
        return isPrime(Integer.parseInt(question)) ? "yes" : "no";
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
