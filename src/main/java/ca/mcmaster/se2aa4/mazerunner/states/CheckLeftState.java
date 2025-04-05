package ca.mcmaster.se2aa4.mazerunner.states;

import ca.mcmaster.se2aa4.mazerunner.*;
import ca.mcmaster.se2aa4.mazerunner.commands.*;

public class CheckLeftState implements SolverState {
    @Override
    public SolverState next(MazeSolverContext context, Path path) {
        DirectionManager dm = context.getDirectionManager();
        Direction leftDir = dm.turnLeft();
        Position left = context.getCurrentPosition().move(leftDir);

        if (!context.getMaze().isWall(left)) {
            new TurnLeftCommand().execute(context);
            path.addInstruction("L");
            new MoveForwardCommand().execute(context);
            path.addInstruction("F");
            return new CheckRightState();
        }

        return new TurnAroundState();
    }
}