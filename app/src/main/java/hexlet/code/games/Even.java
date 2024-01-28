package hexlet.code.games;

import java.util.Random;
import hexlet.code.GenerateQAA;
import hexlet.code.Engine;

public class Even {
    static final int NUMBER_OF_QAA = 3;
    public static String gameDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static void generateGame() {
        GenerateQAA[] rightQAndA = new GenerateQAA[NUMBER_OF_QAA];
        for (int i = 0; i < NUMBER_OF_QAA; i++) {
            int randomNumber = generateRandomNumber();
            rightQAndA[i] = new GenerateQAA(String.valueOf(randomNumber), rightAnswer(randomNumber));
        }
        Engine.loadingGame(gameDescription(), rightQAndA);
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        final int minRange = 1;
        final int maxRange = 100;
        return random.nextInt(maxRange) + minRange;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String rightAnswer(int num) {
        return isEven(num) ? "yes" : "no";
    }
}
