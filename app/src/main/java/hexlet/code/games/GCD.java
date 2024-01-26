package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GenerateQAA;
import java.util.Random;

public class GCD {
    public static String gameDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static void generateGame() {
        GenerateQAA[] rightQAndA = new GenerateQAA[3];
        for (int i = 0; i < 3; i++) {
            int randomNumber1 = generateRandomNumber();
            int randomNumber2 = generateRandomNumber();
            String question = randomNumber1 + " " + randomNumber2;
            int answer = getGCD(randomNumber1, randomNumber2);
            rightQAndA[i] = new GenerateQAA(question, String.valueOf(answer));
        }
        Engine.loadingGame(gameDescription(), rightQAndA);
    }

    private static int getGCD(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return getGCD(b, a % b);
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

}
