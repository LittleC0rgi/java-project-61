package hexlet.code.games;

public final class GCDGame {

    public static String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static String getQuestion() {
        return GameUtils.getTwoNumberQuestion();
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
