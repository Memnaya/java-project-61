package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {
    public static void isEvenGame() {
        System.out.println("Welcome to the Brain Games!");
        Cli.greetingUser();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Scanner answer = new Scanner(System.in);
        String playerName = Cli.getName();

        int correctAnswersCount = 0;

        while (correctAnswersCount < 3) {
            int number = generateRandomNumber();
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = answer.nextLine().toLowerCase();
            boolean isCorrect = isEven(number) && userAnswer.equals("yes")
                    || !isEven(number) && userAnswer.equals("no");

            if (isCorrect) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + (isEven(number) ? "no" : "yes") + "'.");
                System.out.println("Let's try again, " + playerName + "!");
                break;
            }
            System.out.println("Congratulations, " + playerName + "!");
        }
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
