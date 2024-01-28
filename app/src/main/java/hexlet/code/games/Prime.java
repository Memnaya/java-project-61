package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GenerateQAA;

import java.util.Random;

public class Prime {
    private static String gameDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public static void generateGame() {
        GenerateQAA[] rightQAndA = new GenerateQAA[3];
        for (int i = 0; i < 3; i++) {
            int question = generateRandomNumber();
            String answer = isPrime(question);

            rightQAndA[i] = new GenerateQAA(String.valueOf(question), answer);
        }
        Engine.loadingGame(gameDescription(), rightQAndA);
    }
    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(90) + 10;
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
