package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathTest {

    @Test
    public void testPathInstructionsExpansion() {
        Path p1 = new Path("2F1R");
        Path p2 = new Path("1F 2L 3R 4F");
        Path p3 = new Path("ffF 2L l r    3R");
        Path p4 = new Path("f f l rrr    f xf  f mmm abcdefg");

        assertEquals("FFR", p1.getPathInstructions());
        assertEquals("FLLRRRFFFF", p2.getPathInstructions());
        assertEquals("FLLRRR", p3.getPathInstructions());
        assertEquals("", p4.getPathInstructions());
    }

    @Test
    public void testCanonicalPath() {
        Path p1 = new Path("");
        Path p2 = new Path("RRLLRFF");

        assertEquals("", p1.getCanonicalPath());
        assertEquals("RR LL R FF", p2.getCanonicalPath());
    }

    @Test
    public void testFactorizedPath() {
        Path p1 = new Path("FFFRF");
        Path p2 = new Path("FRFFFFFLLLR");

        assertEquals("3F R F", p1.getFactorizedPath());
        assertEquals("F R 5F 3L R", p2.getFactorizedPath());
    }

    @Test
    public void testNullHandling() {
        Path path = new Path(null);
        assertEquals("", path.getPathInstructions());
        assertEquals("", path.getCanonicalPath());
        assertEquals("", path.getFactorizedPath());
    }
}
