package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class GCDGame {
    private static final int MIN = 1;
    private static final int MAX = 100;

    public static String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    @SuppressWarnings("java:S2245")
    public static String getQuestion() {
        int firstNumber = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        int secondNumber = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        return firstNumber + " " + secondNumber;
    }

    public static String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);

        return String.valueOf(gcd(a, b));
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
