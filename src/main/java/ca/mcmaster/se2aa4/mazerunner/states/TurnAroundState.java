package ca.mcmaster.se2aa4.mazerunner.states;

import ca.mcmaster.se2aa4.mazerunner.*;
import ca.mcmaster.se2aa4.mazerunner.commands.*;

public class TurnAroundState implements SolverState {
    @Override
    public SolverState next(RightHandSolverContext context, Path path) {
        new TurnRightCommand().execute(context);
        path.addInstruction("R");
        new TurnRightCommand().execute(context);
        path.addInstruction("R");
        new MoveForwardCommand().execute(context);
        path.addInstruction("F");
        return new CheckRightState();
    }
}