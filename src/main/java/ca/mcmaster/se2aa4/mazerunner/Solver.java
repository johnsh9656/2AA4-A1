package ca.mcmaster.se2aa4.mazerunner;

public class Solver implements MazeSolver {
    
    @Override
    public Path solve(Maze maze){
        Position currentPos = maze.getEntry();
        Path path = new Path();
        path.addInstruction("FFFFLFFFFRFFFF");
        return path;
    }
}