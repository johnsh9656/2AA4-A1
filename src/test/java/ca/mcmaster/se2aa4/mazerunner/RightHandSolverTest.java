package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RightHandSolverTest {

    @Test
    public void testSolverReturnsNonEmptyPath() throws Exception {
        Maze maze = new Maze("./examples/large.maz.txt");
        MazeSolver solver = new RightHandSolver();
        Path path = solver.solve(maze);
        assertNotNull(path);
        assertFalse(path.getPathInstructions().isEmpty());
    }

    @Test
    public void testSolverPathIsValid() throws Exception {
        Maze maze = new Maze("./examples/medium.maz.txt");
        MazeSolver solver = new RightHandSolver();
        Path path = solver.solve(maze);
        assertTrue(maze.validatePath(path));
    }
}
