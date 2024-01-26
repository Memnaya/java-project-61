package hexlet.code.games;

import java.util.Random;
import hexlet.code.GenerateQAA;
import hexlet.code.Engine;

public class Even {
    public static String gameDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static void generateGame() {
        GenerateQAA[] rightQAndA = new GenerateQAA[3];
        for (int i = 0; i < 3; i++) {
            int randomNumber = generateRandomNumber();
            rightQAndA[i] = new GenerateQAA(String.valueOf(randomNumber), rightAnswer(randomNumber));
        }
        Engine.loadingGame(gameDescription(), rightQAndA);
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String rightAnswer(int num) {
        return isEven(num) ? "yes" : "no";
    }
}
