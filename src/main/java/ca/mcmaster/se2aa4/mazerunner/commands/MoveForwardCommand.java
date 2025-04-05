package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.*;
import ca.mcmaster.se2aa4.mazerunner.RightHandSolverContext;

public class MoveForwardCommand implements Command {
    @Override
    public boolean execute(RightHandSolverContext context) {
        Position next = context.getCurrentPosition().move(context.getDirectionManager().getCurrentDir());
        context.setCurrentPosition(next);
        return true;
    }
}
