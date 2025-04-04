package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.*;
import ca.mcmaster.se2aa4.mazerunner.MazeSolverContext;

public class TurnRightCommand implements Command {
    @Override
    public boolean execute(MazeSolverContext context) {
        DirectionManager dm = context.getDirectionManager();
        dm.setCurrentDir(dm.turnRight());
        return true;
    }
}