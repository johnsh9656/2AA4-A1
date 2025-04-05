package ca.mcmaster.se2aa4.mazerunner.states;

import ca.mcmaster.se2aa4.mazerunner.*;

public interface SolverState {
    SolverState next(RightHandSolverContext context, Path path);
}