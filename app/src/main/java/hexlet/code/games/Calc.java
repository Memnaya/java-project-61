package hexlet.code.games;

import java.util.Random;
import hexlet.code.GenerateQAA;
import  hexlet.code.Engine;

public class Calc {
    static final int NUMBER_OF_QAA = 3;
    private static int num1;
    private static int num2;
    private static char operator;

    public static String gameDescription() {
        return "What is the result of the expression?";
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        final int minRange = 1;
        final int maxRange = 100;
        return random.nextInt(maxRange) + minRange;
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
        GenerateQAA[] rightQAndA = new GenerateQAA[NUMBER_OF_QAA];
        for (int i = 0; i < NUMBER_OF_QAA; i++) {
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
