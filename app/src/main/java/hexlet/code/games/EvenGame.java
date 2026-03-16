package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class EvenGame implements Game {

    private static final int MIN = 1;
    private static final int MAX = 100;

    @Override
    public String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    @SuppressWarnings("java:S2245")
    public String getQuestion() {
        int number = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        return String.valueOf(number);
    }

    @Override
    public String getCorrectAnswer(String question) {
        int number = Integer.parseInt(question);
        return number % 2 == 0 ? "yes" : "no";
    }
}
