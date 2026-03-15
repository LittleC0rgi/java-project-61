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

        switch (gameNumber) {
            case "0":
                System.out.println("Goodbye!");
                break;

            case "1":
                var cli = new Cli();
                cli.askName(scanner);
                break;

            case "2":
                Game evenGame = new EvenGame();
                Engine.start(evenGame, scanner);
                break;

            case "3":
                Game calcGame = new CalcGame();
                Engine.start(calcGame, scanner);
                break;

            case "4":
                Game gcdGame = new GCDGame();
                Engine.start(gcdGame, scanner);
                break;

            case "5":
                Game progressionGame = new ProgressionGame();
                Engine.start(progressionGame, scanner);
                break;

            case "6":
                Game primeGame = new PrimeGame();
                Engine.start(primeGame, scanner);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        scanner.close();

    }
}
