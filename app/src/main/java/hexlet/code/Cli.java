package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private String name;

    public void askName(Scanner scanner) {
        System.out.print("May I have your name?: ");
        String userName = scanner.nextLine();
        name = userName;
        System.out.println("Hello, " + name + "!");
    }

    public String getName() {
        return name;
    }
}
