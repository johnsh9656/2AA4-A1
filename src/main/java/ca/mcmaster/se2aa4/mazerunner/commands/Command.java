package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.MazeSolverContext;

public interface Command {
    boolean execute(MazeSolverContext context);
}