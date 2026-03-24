package hexlet.code;

import java.util.Scanner;

public final class Cli {
    public static String askName(Scanner scanner) {
        System.out.print("May I have your name?: ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }
}
