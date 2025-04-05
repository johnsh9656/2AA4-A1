package ca.mcmaster.se2aa4.mazerunner.states;

import ca.mcmaster.se2aa4.mazerunner.*;
import ca.mcmaster.se2aa4.mazerunner.commands.*;

public class CheckForwardState implements SolverState {
    @Override
    public SolverState next(RightHandSolverContext context, Path path) {
        Position forward = context.getCurrentPosition().move(context.getDirectionManager().getCurrentDir());

        if (!context.getMaze().isWall(forward)) {
            new MoveForwardCommand().execute(context);
            path.addInstruction("F");
            return new CheckRightState();
        }

        return new CheckLeftState();
    }
}