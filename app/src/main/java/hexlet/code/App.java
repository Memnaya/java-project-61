package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        String num = scanner.nextLine();
        switch (num) {
            case "1" -> Cli.greetingUser();
            case "2" -> Even.generateGame();
            case "3" -> Calc.generateGame();
            case "4" -> GCD.generateGame();
            case "5" -> Progression.generateGame();
            case "6" -> Prime.generateGame();
            case "0" -> System.exit(0);
            default -> System.out.println("Invalid number");
        }
        scanner.close();
    }
}
