package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    @Test
    public void testMazeLoadsCorrectly() throws Exception {
        Maze maze = new Maze("./examples/giant.maz.txt");
        assertNotNull(maze.getEntry());
        assertNotNull(maze.getExit());
    }

    @Test
    public void testEntryAndExitAreNotWalls() throws Exception {
        Maze maze = new Maze("./examples/huge.maz.txt");
        assertFalse(maze.isWall(maze.getEntry()));
        assertFalse(maze.isWall(maze.getExit()));
    }

    @Test
    public void testInvalidPathReturnsFalse() throws Exception {
        Maze maze = new Maze("./examples/rectangle.maz.txt");
        Path path = new Path("FFFFFFFFFFFF");
        assertFalse(maze.validatePath(path));
    }

    @Test
    public void testWallDetection() throws Exception {
        Maze maze = new Maze("./examples/straight.maz.txt");
        Position pos = new Position(0, 0); // Adjust based on your maze layout
        assertTrue(maze.isWall(pos)); // Placeholder to avoid errors
    }
}
