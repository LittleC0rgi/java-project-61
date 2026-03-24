package hexlet.code.games;

import java.util.Scanner;

public final class ProgressionGame {
    private static final int MIN_START_NUMBER = 1;
    private static final int MAX_START_NUMBER = 50;
    private static final int MAX_STEP = 10;

    private static final int MAX_LENGTH_PROGRESSION = 10;
    private static final int MIN_LENGTH_PROGRESSION = 5;

    public static void play(Scanner scanner) {
        Engine.start(ProgressionGame.getRule(), ProgressionGame::getQuestion,
                ProgressionGame::getCorrectAnswer, scanner);
    }

    public static String getRule() {
        return "What number is missing in the progression?";
    }

    @SuppressWarnings("java:S2245")
    public static String getQuestion() {
        int length = GameUtils.getRandomNumber(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
        int hiddenIndex = GameUtils.getRandomNumber(0, length - 1);
        int step = GameUtils.getRandomNumber(1, MAX_STEP);
        int number = GameUtils.getRandomNumber(MIN_START_NUMBER, MAX_START_NUMBER);

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
        int length = GameUtils.getRandomNumber(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
        int hiddenIndex = GameUtils.getRandomNumber(0, length - 1);
        int step = GameUtils.getRandomNumber(1, MAX_STEP);
        int startNumber = GameUtils.getRandomNumber(MIN_START_NUMBER, MAX_START_NUMBER);

        return buildProgression(length, startNumber, step, hiddenIndex);
    }

    private static String buildProgression(int length, int startNumber, int step, int hiddenIndex) {
        var progression = new StringBuilder();
        int current = startNumber;

        for (int i = 0; i < length; i++) {
            if (i > 0) {
                progression.append(" ");
            }

            if (i == hiddenIndex) {
                progression.append("..");
            } else {
                progression.append(current);
            }

            current += step;
        }

        return progression.toString();
    }
}
