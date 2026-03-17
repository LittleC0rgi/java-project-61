package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class ProgressionGame {
    private static final int MIN_START_NUMBER = 1;
    private static final int MAX_START_NUMBER = 50;
    private static final int MAX_STEP = 10;

    private static final int MAX_LENGTH_PROGRESSION = 10;
    private static final int MIN_LENGTH_PROGRESSION = 5;

    public static String getRule() {
        return "What number is missing in the progression?";
    }

    @SuppressWarnings("java:S2245")
    public static String getQuestion() {
        int length = ThreadLocalRandom.current().nextInt(MIN_LENGTH_PROGRESSION,
                MAX_LENGTH_PROGRESSION + 1);

        int hiddenIndex = ThreadLocalRandom.current().nextInt(length);
        int step = ThreadLocalRandom.current().nextInt(MIN_START_NUMBER, MAX_STEP + 1);
        int number = ThreadLocalRandom.current().nextInt(MIN_START_NUMBER, MAX_START_NUMBER + 1);

        var progression = new StringBuilder();

        for (int i = 0; i < length; i++) {

            if (i > 0) {
                progression.append(" ");
            }

            if (i == hiddenIndex) {
                progression.append("..");
            } else {
                progression.append(number);
            }

            number += step;
        }

        return progression.toString();
    }

    public static String getCorrectAnswer(String question) {
        String[] numbers = question.split(" ");

        int hiddenIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals("..")) {
                hiddenIndex = i;
                break;
            }
        }

        int step;
        if (hiddenIndex >= 2) {
            int a = Integer.parseInt(numbers[hiddenIndex - 1]);
            int b = Integer.parseInt(numbers[hiddenIndex - 2]);
            step = a - b;
        } else {
            int a = Integer.parseInt(numbers[hiddenIndex + 2]);
            int b = Integer.parseInt(numbers[hiddenIndex + 1]);
            step = a - b;
        }

        int result;
        if (hiddenIndex > 0) {
            int prevNumber = Integer.parseInt(numbers[hiddenIndex - 1]);
            result = prevNumber + step;
        } else {
            int nextNumber = Integer.parseInt(numbers[hiddenIndex + 1]);
            result = nextNumber - step;
        }

        return String.valueOf(result);
    }
}
