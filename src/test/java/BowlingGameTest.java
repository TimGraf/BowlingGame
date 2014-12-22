/**
 * Created by tgraf on 3/7/14.
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link Game}.
 *
 * @author user@example.com (John Doe)
 */
@RunWith(JUnit4.class)
public class BowlingGameTest {
    private Game g;

    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    private void rollMany(int n, int pins) {

        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    private void rollStrike() {
        g.roll(10);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    @Test
    public void testGutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals("assert score is 0 for gutter game", 0, g.score());
    }

    @Test
    public void testAllOnes() throws Exception {
        rollMany(20, 1);
        assertEquals("assert score is 20 for a single pin for each roll", 20, g.score());
    }

    @Test
    public void testOneSpare() throws Exception {
        rollSpare();
        g.roll(3);
        rollMany(17 ,0);
        assertEquals("assert one spare and 3 pins is score of 16", 16, g.score());
    }

    @Test
    public void testOneStrike() throws Exception {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals("assert one strike and roll 3 pins then 4 pins is score of 24", 24, g.score());
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals("assert perfect game score is 300", 300, g.score());
    }
}
