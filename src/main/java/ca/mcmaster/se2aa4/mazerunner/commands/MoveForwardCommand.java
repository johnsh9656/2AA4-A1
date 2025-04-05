package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.*;
import ca.mcmaster.se2aa4.mazerunner.MazeSolverContext;

public class MoveForwardCommand implements Command {
    @Override
    public boolean execute(MazeSolverContext context) {
        Position next = context.getCurrentPosition().move(context.getDirectionManager().getCurrentDir());
        
        if (context.getMaze().isWall(next) || context.getMaze().isOutOfBounds(next)) {
            return false;
        }
        
        context.setCurrentPosition(next);
        return true;
    }
}
