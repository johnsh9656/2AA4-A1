package ca.mcmaster.se2aa4.mazerunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DirectionManager {
    private static final Logger logger = LogManager.getLogger();
    private final Direction startingDir = Direction.EAST; // assuming entry on always on West border, you always start facing East
    private Direction currentDir;
    public DirectionManager(){
        this.currentDir = startingDir;
    }
    public Direction turnRight(){
        switch(currentDir){
            case NORTH:
                return Direction.EAST;
            case EAST:
                return Direction.SOUTH;
            case WEST:
                return Direction.NORTH;
            case SOUTH:
                return Direction.WEST;
            default:
                throw new IllegalStateException("Unexpected value: " + currentDir);
        }
    }
    public Direction turnLeft(){
        switch(currentDir){
            case NORTH:
                return Direction.WEST;
            case EAST:
                return Direction.NORTH;
            case WEST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.EAST;
            default:
                throw new IllegalStateException("Unexpected value: " + currentDir);
        }
    }
}