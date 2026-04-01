package hexlet.code.games;

import java.util.Map;

public final class ProgressionGame {
    private static final int MIN_START_NUMBER = 1;
    private static final int MAX_START_NUMBER = 50;
    private static final int MAX_STEP = 10;

    private static final int MAX_LENGTH_PROGRESSION = 10;
    private static final int MIN_LENGTH_PROGRESSION = 5;

    public static void play() {
        var questionAndAnswer = buildQuestionAndAnswer();

        Engine.start(ProgressionGame.getRule(), questionAndAnswer.getKey(),
                questionAndAnswer.getValue());
    }

    private static String getRule() {
        return "What number is missing in the progression?";
    }

    private static Map.Entry<String, String> buildQuestionAndAnswer() {
        int length = GameUtils.getRandomNumber(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
        int hiddenIndex = GameUtils.getRandomNumber(0, length - 1);
        int step = GameUtils.getRandomNumber(1, MAX_STEP);
        int startNumber = GameUtils.getRandomNumber(MIN_START_NUMBER, MAX_START_NUMBER);

        String[] progression = makeProgression(startNumber, step, length);
        String answer = progression[hiddenIndex];
        progression[hiddenIndex] = "..";
        String question = String.join(" ", progression);

        return Map.entry(question, answer);
    }

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(first + i * step);
        }
        return progression;
    }
}
