package hexlet.code.games;

import java.util.Random;
import hexlet.code.GenerateQAA;
import  hexlet.code.Engine;

public class Calc {
    private static int num1;
    private static int num2;
    private static char operator;

    public static String gameDescription() {
        return "What is the result of the expression?";
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private static char getRandomOperator() {
        char[] operators = {'+', '-', '*'};
        Random random = new Random();
        return operators[random.nextInt(operators.length)];
    }

    private static int calculateAnswer() {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    public static void generateGame() {
        GenerateQAA[] rightQAndA = new GenerateQAA[3];
        for (int i = 0; i < 3; i++) {
            num1 = generateRandomNumber();
            num2 = generateRandomNumber();
            operator = getRandomOperator();
            String question = num1 + " " + operator + " " + num2;
            String answer = String.valueOf(calculateAnswer());
            rightQAndA[i] = new GenerateQAA(question, answer);
        }
        Engine.loadingGame(gameDescription(), rightQAndA);
    }
}
