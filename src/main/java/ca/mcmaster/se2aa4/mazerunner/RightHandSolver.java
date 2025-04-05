package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.states.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements MazeSolver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Path solve(Maze maze) {
        Path path = new Path();
        RightHandSolverContext context = new RightHandSolverContext(maze);
        SolverState state = new CheckRightState();

        while (!context.getCurrentPosition().equals(maze.getExit())) {
            state = state.next(context, path);
            logger.debug("Current position: " + context.getCurrentPosition());
        }

        return path;
    }
}