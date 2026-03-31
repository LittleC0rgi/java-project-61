package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class GameUtils {
    @SuppressWarnings("java:S2245")
    public static int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getTwoNumberQuestion(int min, int max) {
        return getRandomNumber(min, max) + " " + getRandomNumber(min, max);
    }
}
