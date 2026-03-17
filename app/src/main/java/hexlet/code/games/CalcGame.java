package hexlet.code.games;

public final class CalcGame {

    private static final String[] OPERATORS = {"+", "-", "*"};

    public static String getRule() {
        return "What is the result of the expression?";
    }

    public static String getQuestion() {
        String op = OPERATORS[GameUtils.getRandomNumber() % OPERATORS.length];
        return GameUtils.getRandomNumber() + " " + op + " " + GameUtils.getRandomNumber();
    }

    public static String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int first = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int second = Integer.parseInt(parts[2]);

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
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }

        return String.valueOf(result);
    }
}
