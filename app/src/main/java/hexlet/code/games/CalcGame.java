package hexlet.code.games;

import java.util.concurrent.ThreadLocalRandom;

public final class CalcGame implements Game {

    private static final int MIN = 1;
    private static final int MAX = 100;

    @Override
    public String getRule() {
        return "What is the result of the expression?";
    }

    @Override
    @SuppressWarnings("java:S2245")
    public String getQuestion() {
        int firstNumber = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        int secondNumber = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);

        String[] operators = { "+", "-", "*" };
        String op = operators[ThreadLocalRandom.current().nextInt(operators.length)];

        return firstNumber + " " + op + " " + secondNumber;

    }

    @Override
    public String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");

        int first = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[2]);
        String operator = parts[1];

        int result;

        switch (operator) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            default:
                throw new IllegalArgumentException("Unknown operator");
        }

        return String.valueOf(result);
    }
}
