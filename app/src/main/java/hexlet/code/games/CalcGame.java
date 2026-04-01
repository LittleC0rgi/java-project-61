package hexlet.code.games;

import java.util.Map;

public final class CalcGame {
    public static final int MIN = 1;
    public static final int MAX = 100;

    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void play() {
        var questionAndAnswer = buildQuestionAndAnswer();
        Engine.start(CalcGame.getRule(), questionAndAnswer.getKey(), questionAndAnswer.getValue());
    }


    public static String getRule() {
        return "What is the result of the expression?";
    }

    private static Map.Entry<String, String> buildQuestionAndAnswer() {
        String op = OPERATORS[GameUtils.getRandomNumber(MIN, MAX) % OPERATORS.length];
        int first = GameUtils.getRandomNumber(MIN, MAX);
        int second = GameUtils.getRandomNumber(MIN, MAX);

        String question = first + " " + op + " " + second;
        String answer = String.valueOf(calculate(first, op, second));

        return Map.entry(question, answer);
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
