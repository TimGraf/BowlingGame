/**
 * Created by tgraf on 3/7/14.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link ScoreReporter}.
 *
 * @author user@example.com (John Doe)
 */
@RunWith(JUnit4.class)
public class ScoreReporterTest {
    private Game g;
    private String zeroScoreReport = "Roll: 01, Pins: 00\n" +
                                     "Roll: 02, Pins: 00\n" +
                                     "Roll: 03, Pins: 00\n" +
                                     "Roll: 04, Pins: 00\n" +
                                     "Roll: 05, Pins: 00\n" +
                                     "Roll: 06, Pins: 00\n" +
                                     "Roll: 07, Pins: 00\n" +
                                     "Roll: 08, Pins: 00\n" +
                                     "Roll: 09, Pins: 00\n" +
                                     "Roll: 10, Pins: 00\n" +
                                     "Roll: 11, Pins: 00\n" +
                                     "Roll: 12, Pins: 00\n" +
                                     "Roll: 13, Pins: 00\n" +
                                     "Roll: 14, Pins: 00\n" +
                                     "Roll: 15, Pins: 00\n" +
                                     "Roll: 16, Pins: 00\n" +
                                     "Roll: 17, Pins: 00\n" +
                                     "Roll: 18, Pins: 00\n" +
                                     "Roll: 19, Pins: 00\n" +
                                     "Roll: 20, Pins: 00\n";

    private String spareLastFrameReport = "Roll: 01, Pins: 00\n" +
                                          "Roll: 02, Pins: 00\n" +
                                          "Roll: 03, Pins: 00\n" +
                                          "Roll: 04, Pins: 00\n" +
                                          "Roll: 05, Pins: 00\n" +
                                          "Roll: 06, Pins: 00\n" +
                                          "Roll: 07, Pins: 00\n" +
                                          "Roll: 08, Pins: 00\n" +
                                          "Roll: 09, Pins: 00\n" +
                                          "Roll: 10, Pins: 00\n" +
                                          "Roll: 11, Pins: 00\n" +
                                          "Roll: 12, Pins: 00\n" +
                                          "Roll: 13, Pins: 00\n" +
                                          "Roll: 14, Pins: 00\n" +
                                          "Roll: 15, Pins: 00\n" +
                                          "Roll: 16, Pins: 00\n" +
                                          "Roll: 17, Pins: 00\n" +
                                          "Roll: 18, Pins: 00\n" +
                                          "Roll: 19, Pins: 05\n" +
                                          "Roll: 20, Pins: 05\n" +
                                          "Roll: 21, Pins: 04\n";

    private String strikeLastFrameReport = "Roll: 01, Pins: 00\n" +
                                           "Roll: 02, Pins: 00\n" +
                                           "Roll: 03, Pins: 00\n" +
                                           "Roll: 04, Pins: 00\n" +
                                           "Roll: 05, Pins: 00\n" +
                                           "Roll: 06, Pins: 00\n" +
                                           "Roll: 07, Pins: 00\n" +
                                           "Roll: 08, Pins: 00\n" +
                                           "Roll: 09, Pins: 00\n" +
                                           "Roll: 10, Pins: 00\n" +
                                           "Roll: 11, Pins: 00\n" +
                                           "Roll: 12, Pins: 00\n" +
                                           "Roll: 13, Pins: 00\n" +
                                           "Roll: 14, Pins: 00\n" +
                                           "Roll: 15, Pins: 00\n" +
                                           "Roll: 16, Pins: 00\n" +
                                           "Roll: 17, Pins: 00\n" +
                                           "Roll: 18, Pins: 00\n" +
                                           "Roll: 19, Pins: 10\n" +
                                           "Roll: 20, Pins: 04\n" +
                                           "Roll: 21, Pins: 04\n";
    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    private void rollMany(int n, int pins) {

        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollStrike() {
        g.roll(10);
    }

    @Test
    public void testScoreReportDoesNotReturnNullForEmptyGame() {
        String scoreReport = ScoreReporter.createScoreReport(g);

        assertNotNull("assert report is not null", scoreReport);
    }

    @Test
    public void testScoreReportForZeroPinsInGame() {
        rollMany(20, 0);

        String scoreReport = ScoreReporter.createScoreReport(g);

        assertEquals("assert zero score game report is formatted correctly", zeroScoreReport, scoreReport);
    }

    @Test
    public void testScoreReportForSpareInLastFrame() {
        rollMany(18, 0);
        rollSpare();
        g.roll(4);

        String scoreReport = ScoreReporter.createScoreReport(g);

        assertEquals("assert spare in last frame is formatted correctly", spareLastFrameReport, scoreReport);
    }

    @Test
    public void testScoreReportForStrikeInLastFrame() {
        rollMany(18, 0);
        rollStrike();
        g.roll(4);
        g.roll(4);

        String scoreReport = ScoreReporter.createScoreReport(g);

        assertEquals("assert strike in last frame is formatted correctly", strikeLastFrameReport, scoreReport);
    }
}
