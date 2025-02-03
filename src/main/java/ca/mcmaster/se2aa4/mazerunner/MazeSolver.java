package ca.mcmaster.se2aa4.mazerunner;

public interface MazeSolver {
    /*
     * Solve the maze and return the path to be taken
     *
     * @param maze The maze to be solved
     * @return The path to be taken
     */    

    Path solve(Maze maze);
}
