package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testMoveEastIncreasesX() {
        Position p = new Position(1, 1);
        Position moved = p.move(Direction.EAST);
        assertEquals(2, moved.getX());
        assertEquals(1, moved.getY());
    }

    @Test
    public void testEqualsSameCoordinates() {
        Position p1 = new Position(2, 3);
        Position p2 = new Position(2, 3);
        Position p3 = new Position(3, 2);
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
    }

    @Test
    public void testToStringOutput() {
        Position p = new Position(4, 5);
        assertEquals("(4, 5)", p.toString());
    }
}
