/**
 * Created by tgraf on 3/7/14.
 */
public class Game {
    private int rolls[] = new int[21];
    private int currentRollIndex = 0;
    private int maxFrames = 10;
    private int maxPins = 10;

    public void roll(int pins) {
        rolls[currentRollIndex++] = pins;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < maxFrames; frame++) {

            if (isStrike(rollIndex)) {
                score += maxPins + strikeBonus(rollIndex);
                rollIndex++;
            } else if (isSpare(rollIndex)) {
                score += maxPins + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += sumOfBallsInFrame(rollIndex);
                rollIndex += 2;
            }
        }

        return score;
    }

    public int[] getPinsPerRoll() {
        return rolls;
    }

    public boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == maxPins;
    }

    public boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == maxPins;
    }

    private int sumOfBallsInFrame(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }
}
