package hexlet.code;

import java.util.Scanner;

public class Engine {
    static final int MAX_STEPS = 3;
    public static void loadingGame(String gameDescription, GenerateQAA[] rightQAndA) {
        System.out.println("Welcome to the Brain Games!");
        Cli.greetingUser();
        System.out.println(gameDescription);
        Scanner answer = new Scanner(System.in);
        String playerName = Cli.getName();
        for (int i = 0; i < MAX_STEPS; i++) {
            System.out.println("Question: " + rightQAndA[i].getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = answer.nextLine();
            boolean isCorrect = rightQAndA[i].getAnswer().equals(userAnswer);
            if (!isCorrect) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + rightQAndA[i].getAnswer() + "'.");
                System.out.println("Let's try again, " + playerName + "!");
                return;
            } else {
                System.out.println("Correct!");
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
