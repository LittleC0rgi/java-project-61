package hexlet.code.games;

public final class CalcGame {
    public static final int MIN = 1;
    public static final int MAX = 100;

    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void play() {
        Engine.start(CalcGame.getRule(), CalcGame::getQuestion, CalcGame::getCorrectAnswer);
    }

    public static String getRule() {
        return "What is the result of the expression?";
    }

    public static String getQuestion() {
        String op = OPERATORS[GameUtils.getRandomNumber(MIN, MAX) % OPERATORS.length];
        return GameUtils.getRandomNumber(MIN, MAX) + " " + op + " "
                + GameUtils.getRandomNumber(MIN, MAX);
    }

    public static String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int first = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int second = Integer.parseInt(parts[2]);

        int result = calculate(first, operator, second);

        return String.valueOf(result);
    }

    private static int calculate(int first, String operator, int second) {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

}
