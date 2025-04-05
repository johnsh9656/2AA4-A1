package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.RightHandSolverContext;

public interface Command {
    boolean execute(RightHandSolverContext context);
}