package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class PrimeGame implements Game {
    private static final int MIN = 1;
    private static final int MAX = 100;

    @Override
    public String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    @SuppressWarnings("java:S2245")
    public String getQuestion() {
        int number = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        return String.valueOf(number);
    }

    @Override
    public String getCorrectAnswer(String question) {
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
