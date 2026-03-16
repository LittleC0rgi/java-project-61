package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.Game;
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
        String gameNumber = scanner.nextLine();
        Game game = null;

        switch (gameNumber) {
            case "0":
                System.out.println("Goodbye!");
                break;

            case "1":
                game = null;
                break;

            case "2":
                game = new EvenGame();
                break;

            case "3":
                game = new CalcGame();
                break;

            case "4":
                game = new GCDGame();
                break;

            case "5":
                game = new ProgressionGame();
                break;

            case "6":
                game = new PrimeGame();
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        Engine.start(game, scanner);
        scanner.close();

    }
}
