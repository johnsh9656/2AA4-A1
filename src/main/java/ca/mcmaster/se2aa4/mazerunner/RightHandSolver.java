package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements MazeSolver {
    private static final Logger logger = LogManager.getLogger();
    
    /*  solves the maze using the right hand rule
        parameters - maze
        returns - path from maze entry to exit
    */
    @Override
    public Path solve(Maze maze){
        Path path = new Path();
        Position currentPos = maze.getEntry();
        DirectionManager directionManager = new DirectionManager();

        while (!currentPos.equals(maze.getExit())) {
            if (!maze.isWall(currentPos.move(directionManager.turnRight()))) {
                // turn right and move forward if no wall to right
                directionManager.setCurrentDir(directionManager.turnRight());
                path.addInstruction("R");
                currentPos = currentPos.move(directionManager.getCurrentDir());
                path.addInstruction("F");
            } else {
                if (!maze.isWall(currentPos.move(directionManager.getCurrentDir()))) {
                    // move forward if wall to right and no wall in front
                    currentPos = currentPos.move(directionManager.getCurrentDir());
                    path.addInstruction("F");
                } else if (!maze.isWall(currentPos.move(directionManager.turnLeft()))) {
                    // turn left if wall in front and right
                    directionManager.setCurrentDir(directionManager.turnLeft());
                    path.addInstruction("L");
                    currentPos = currentPos.move(directionManager.getCurrentDir());
                    path.addInstruction("F");
                }
                else {
                    // turn around if wall in front, right, and left
                    directionManager.setCurrentDir(directionManager.turnRight());
                    directionManager.setCurrentDir(directionManager.turnRight());
                    path.addInstruction("R");
                    path.addInstruction("R");
                    currentPos = currentPos.move(directionManager.getCurrentDir());
                    path.addInstruction("F");
                }
            }
            logger.debug("Current position: " + currentPos);
        }

        return path;
    }
}