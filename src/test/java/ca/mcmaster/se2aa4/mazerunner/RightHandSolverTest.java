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
        MazeSolver solver = new RightHandSolver();

        Maze m1 = new Maze("./examples/medium.maz.txt");
        Path p1 = solver.solve(m1);
        assertTrue(m1.validatePath(p1));

        Maze m2 = new Maze("./examples/rectangle.maz.txt");
        Path p2 = solver.solve(m2);
        assertTrue(m2.validatePath(p2));

        Maze m3 = new Maze("./examples/large.maz.txt");
        Path p3 = solver.solve(m3);
        assertTrue(m3.validatePath(p3));
    }
}
