package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class GameUtils {

    public static final int MIN = 1;
    public static final int MAX = 100;

    @SuppressWarnings("java:S2245")
    public static int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
    }

    @SuppressWarnings("java:S2245")
    public static int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getTwoNumberQuestion() {
        return getRandomNumber() + " " + getRandomNumber();
    }
}
