package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolverContext {
    private final Maze maze;
    private Position currentPosition;
    private DirectionManager directionManager;

    public MazeSolverContext(Maze maze) {
        this.maze = maze;
        this.currentPosition = maze.getEntry();
        this.directionManager = new DirectionManager();
    }

    public Maze getMaze() { return maze; }
    public Position getCurrentPosition() { return currentPosition; }
    public void setCurrentPosition(Position pos) { this.currentPosition = pos; }
    public DirectionManager getDirectionManager() { return directionManager; }
    public boolean hitWall() { return maze.isWall(currentPosition); }
    public boolean outOfBounds() { return maze.isOutOfBounds(currentPosition); }
}