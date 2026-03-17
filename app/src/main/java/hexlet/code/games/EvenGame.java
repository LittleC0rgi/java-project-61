package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class EvenGame {

    private static final int MIN = 1;
    private static final int MAX = 100;

    public static String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @SuppressWarnings("java:S2245")
    public static String getQuestion() {
        int number = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        return String.valueOf(number);
    }

    public static String getCorrectAnswer(String question) {
        int number = Integer.parseInt(question);
        return number % 2 == 0 ? "yes" : "no";
    }
}
