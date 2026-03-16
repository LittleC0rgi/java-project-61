package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Game;

public class Engine {

    private static final int ROUNDS = 3;

    public static void start(Game game, Scanner scanner) {
        Cli cli = new Cli();
        cli.askName(scanner);

        System.out.println(game.getRule());

        for (int i = 0; i < ROUNDS; i++) {

            String question = game.getQuestion();
            String correctAnswer = game.getCorrectAnswer(question);

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");

            String userAnswer = scanner.nextLine();

            boolean isCorrect = userAnswer.equalsIgnoreCase(correctAnswer);

            if (isCorrect) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + cli.getName() + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + cli.getName() + "!");
    }
}
