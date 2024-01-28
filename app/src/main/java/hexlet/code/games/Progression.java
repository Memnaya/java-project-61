package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GenerateQAA;
import java.util.Random;

public class Progression {
    public static String gameDescription() {
        return "What number is missing in the progression?";
    }

    public static void generateGame() {
        GenerateQAA[] rightQAndA = new GenerateQAA[3];
        for (int i = 0; i < 3; i++) {
            int[] progression = generateProgression();

            Random random = new Random();
            int hiddenIndex = random.nextInt(progression.length);

            String question = formatProgressionWithHiddenElement(progression, hiddenIndex);
            int answer = progression[hiddenIndex];

            rightQAndA[i] = new GenerateQAA(question, String.valueOf(answer));
        }
        Engine.loadingGame(gameDescription(), rightQAndA);
    }

    private static int[] generateProgression() {
        Random random = new Random();

        int length = random.nextInt(6) + 5;

        int initialTerm = random.nextInt(101);
        int commonDifference = random.nextInt(11) + 1;

        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = initialTerm + i * commonDifference;
        }

        return progression;
    }
    private static String formatProgressionWithHiddenElement(int[] progression, int hiddenIndex) {
        StringBuilder formattedProgression = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                formattedProgression.append("..");
            } else {
                formattedProgression.append(progression[i]);
            }

            if (i < progression.length - 1) {
                formattedProgression.append(" ");
            }
        }

        return formattedProgression.toString();
    }
}
