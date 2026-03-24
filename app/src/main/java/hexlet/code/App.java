package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

public class App {
    public static void main(String[] args) {

        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        switch (userChoice) {
            case "0":
                System.out.println("Goodbye!");
                break;

            case "1":
                Engine.start(null, null, null, scanner);
                break;

            case "2":
                Engine.start(EvenGame.getRule(), EvenGame::getQuestion, EvenGame::getCorrectAnswer,
                        scanner);
                break;

            case "3":
                Engine.start(CalcGame.getRule(), CalcGame::getQuestion, CalcGame::getCorrectAnswer,
                        scanner);
                break;

            case "4":
                Engine.start(GCDGame.getRule(), GCDGame::getQuestion, GCDGame::getCorrectAnswer,
                        scanner);
                break;

            case "5":
                Engine.start(ProgressionGame.getRule(), ProgressionGame::getQuestion,
                        ProgressionGame::getCorrectAnswer, scanner);
                break;

            case "6":
                Engine.start(PrimeGame.getRule(), PrimeGame::getQuestion,
                        PrimeGame::getCorrectAnswer, scanner);
                break;

            default:
                System.out.println("Unknown user choice" + userChoice);
                break;
        }

        scanner.close();
    }
}
