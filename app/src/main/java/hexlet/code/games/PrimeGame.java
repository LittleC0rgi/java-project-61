package hexlet.code.games;

import java.util.Scanner;

public final class PrimeGame {

    public static void play(Scanner scanner) {
        Engine.start(PrimeGame.getRule(), PrimeGame::getQuestion, PrimeGame::getCorrectAnswer,
                scanner);
    }

    public static String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static String getQuestion() {
        return String.valueOf(GameUtils.getRandomNumber());
    }

    public static String getCorrectAnswer(String question) {
        return isPrime(Integer.parseInt(question)) ? "yes" : "no";
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
