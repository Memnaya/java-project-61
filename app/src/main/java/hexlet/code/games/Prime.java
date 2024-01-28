package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GenerateQAA;

import java.util.Random;

public class Prime {
    static final int NUMBER_OF_QAA = 3;
    private static String gameDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public static void generateGame() {
        GenerateQAA[] rightQAndA = new GenerateQAA[NUMBER_OF_QAA];
        for (int i = 0; i < NUMBER_OF_QAA; i++) {
            int question = generateRandomNumber();
            String answer = isPrime(question);

            rightQAndA[i] = new GenerateQAA(String.valueOf(question), answer);
        }
        Engine.loadingGame(gameDescription(), rightQAndA);
    }
    private static int generateRandomNumber() {
        Random random = new Random();
        final int minRange = 1;
        final int maxRange = 100;
        return random.nextInt(maxRange) + minRange;
    }

    private static String isPrime(int number) {
        if (number <= 1) {
            return "no";
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
