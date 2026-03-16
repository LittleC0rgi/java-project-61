package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class GCDGame implements Game {
    private static final int MIN = 1;
    private static final int MAX = 100;

    @Override
    public String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    @SuppressWarnings("java:S2245")
    public String getQuestion() {
        int firstNumber = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        int secondNumber = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        return firstNumber + " " + secondNumber;
    }

    @Override
    public String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);

        return String.valueOf(gcd(a, b));
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
