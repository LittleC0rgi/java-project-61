package hexlet.code.games;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import hexlet.code.Cli;

public class Engine {

    private static final int ROUNDS = 3;

    public static void start(String rule, Supplier<String> questionSupplier,
            UnaryOperator<String> answerProvider) {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");

        Scanner scanner = new Scanner(System.in);

        var userName = Cli.askName(scanner);
        if (rule == null || questionSupplier == null || answerProvider == null) {
            return;
        }

        System.out.println(rule);

        for (int i = 0; i < ROUNDS; i++) {

            String question = questionSupplier.get();
            String correctAnswer = answerProvider.apply(question);

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");

            String userAnswer = scanner.nextLine();

            boolean isCorrect = userAnswer.equalsIgnoreCase(correctAnswer);

            if (isCorrect) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
