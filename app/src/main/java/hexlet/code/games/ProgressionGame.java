package hexlet.code.games;

public final class ProgressionGame {
    private static final int MIN_START_NUMBER = 1;
    private static final int MAX_START_NUMBER = 50;
    private static final int MAX_STEP = 10;

    private static final int MAX_LENGTH_PROGRESSION = 10;
    private static final int MIN_LENGTH_PROGRESSION = 5;

    public static void play() {
        Engine.start(ProgressionGame.getRule(), ProgressionGame::getQuestion,
                ProgressionGame::getCorrectAnswer);
    }

    public static String getRule() {
        return "What number is missing in the progression?";
    }

    @SuppressWarnings("java:S2245")
    public static String getQuestion() {
        int length = GameUtils.getRandomNumber(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
        int hiddenIndex = GameUtils.getRandomNumber(0, length - 1);
        int step = GameUtils.getRandomNumber(1, MAX_STEP);
        int startNumber = GameUtils.getRandomNumber(MIN_START_NUMBER, MAX_START_NUMBER);

        String[] progression = makeProgression(startNumber, step, length);
        String answer = progression[hiddenIndex];
        progression[hiddenIndex] = "..";
        String question = String.join(" ", progression);
        return question;
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

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(first + i * step);
        }
        return progression;
    }
}
