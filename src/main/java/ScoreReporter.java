/**
 * Created by tgraf on 3/7/14.
 */
import java.util.Formatter;

public class ScoreReporter {
    public static String createScoreReport(Game g) {
        StringBuffer scoreReport = new StringBuffer();
        int[] rolls = g.getPinsPerRoll();
        int firstRollIndexLastFrame = 18;
        int maxRolls = 20;

        if (g.isSpare(firstRollIndexLastFrame) || g.isStrike(firstRollIndexLastFrame)) {
            maxRolls++;
        }

        for (int i = 0; i < maxRolls; i++) {
            String roll = String.format("%02d", (i +1));
            String pins = String.format("%02d", rolls[i]);
            scoreReport.append("Roll: " + roll + ", Pins: " + pins + "\n");
        }

        return scoreReport.toString();
    }
}
