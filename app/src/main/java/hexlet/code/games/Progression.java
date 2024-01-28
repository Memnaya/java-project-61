package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GenerateQAA;
import java.util.Random;

public class Progression {
    static final int NUMBER_OF_QAA = 3;
    public static String gameDescription() {
        return "What number is missing in the progression?";
    }

    public static void generateGame() {
        GenerateQAA[] rightQAndA = new GenerateQAA[NUMBER_OF_QAA];
        for (int i = 0; i < NUMBER_OF_QAA; i++) {
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
        final int minRange = 5;
        final int maxRange = 6;
        int length = random.nextInt(maxRange) + minRange;

        final int maxInitialTerm = 101;
        int initialTerm = random.nextInt(maxInitialTerm);

        final int minRangeCommonDiff = 1;
        final int maxRangeCommonDiff = 11;
        int commonDifference = random.nextInt(maxRangeCommonDiff) + minRangeCommonDiff;

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
