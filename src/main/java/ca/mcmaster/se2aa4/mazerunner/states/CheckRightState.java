package ca.mcmaster.se2aa4.mazerunner.states;

import ca.mcmaster.se2aa4.mazerunner.*;
import ca.mcmaster.se2aa4.mazerunner.commands.*;

public class CheckRightState implements SolverState {
    @Override
    public SolverState next(MazeSolverContext context, Path path) {
        DirectionManager dm = context.getDirectionManager();
        Direction rightDir = dm.turnRight();
        Position right = context.getCurrentPosition().move(rightDir);

        if (!context.getMaze().isWall(right)) {
            new TurnRightCommand().execute(context);
            path.addInstruction("R");
            new MoveForwardCommand().execute(context);
            path.addInstruction("F");
            return new CheckRightState();
        }

        return new CheckForwardState();
    }
}