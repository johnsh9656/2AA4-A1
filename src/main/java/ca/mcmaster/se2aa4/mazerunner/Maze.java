package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.commands.*;
import ca.mcmaster.se2aa4.mazerunner.states.*;

public class Maze  {
    private static final Logger logger = LogManager.getLogger(Maze.class);

    private ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
    private final Position entry;
    private final Position exit;

    /*  constructor for Maze class
        parameters - file path
        returns - none
    */
    public Maze(String filePath) throws Exception{
        this.maze = parseMaze(filePath);
        this.entry = findEntry();
        this.exit = findExit();
    }

    /*  parses maze from file and stores it in a 2D arraylist
        parameters - file path
        returns - 2D arraylist of maze
    */
    public ArrayList<ArrayList<Integer>> parseMaze(String filePath) throws Exception{
        logger.info("**** Reading the maze from file " + filePath);  
        BufferedReader reader = new BufferedReader(new FileReader(filePath)); // reads from retreived file
        String line;
        while ((line = reader.readLine()) != null) {
            ArrayList<Integer> mazeRow = new ArrayList<>();
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    mazeRow.add(0); // wall
                } else if (line.charAt(idx) == ' ') {
                    mazeRow.add(1); // passage
                }
            }
            maze.add(mazeRow);
        }
        return maze;
    }

    /*  returns entry position of the maze
     * throws exception if no entrance found
     */
    public Position findEntry() throws Exception {
        for(int row = 0; row < maze.size(); row++){
            Position pos = new Position(0, row);
            
            if (!isWall(pos)) {
                return pos;
            }
        }
        throw new Exception("No entrance found in maze");
    }

    /*  returns exit position of the maze
     * throws exception if no exit found
     */ 
    public Position findExit() throws Exception {
        for(int row = 0; row < maze.size(); row++){
            Position pos = new Position(maze.getFirst().size() - 1, row);
            
            if (!isWall(pos)) {
                return pos;
            }
        }
        throw new Exception("No entrance found in maze");
    }

    /*  returns maze entry position
    */
    public Position getEntry() {
        return this.entry;
    }

    /*  returns maze exit position
    */
    public Position getExit() {
        return this.exit;
    }

    /*  returns value at position in range of maze
        parameters - x and y coordinates
        returns - value at position (0 or 1 for wall or path)
    */
    public Integer getValue(int x, int y){
        return maze.get(x).get(y);
    }

    /*  returns if position is a wall
        parameters - position
        returns - true if wall, false if path
    */
    public boolean isWall(Position pos) {
        return maze.get(pos.getY()).get(pos.getX()) == 0;
    }

    /*  prints maze in 2d format
     */
    public void printMaze(){
        for(ArrayList<Integer> rows : maze){
            for(Integer val : rows){
                System.out.print(val + " ");
            }
            System.out.println(); 
        } 
    }

    public boolean isOutOfBounds(Position pos) {
        return (pos.getX() >= this.maze.getFirst().size() || 
            pos.getY() >= this.maze.size() || 
            pos.getX() < 0 || pos.getY() < 0);
    }

    /*  validates path for maze
        parameters - path
        returns - true if path is valid, false if invalid
    */
    public boolean validatePath(Path path) {
        MazeSolverContext context = new MazeSolverContext(this);
        context.setCurrentPosition(this.entry);
        
        for (char c : path.getPathInstructions().toCharArray()) {
            Command command = switch (c) {
                case 'F' -> new MoveForwardCommand();
                case 'L' -> new TurnLeftCommand();
                case 'R' -> new TurnRightCommand();
                default -> null;
            };
    
            if ((command == null || !command.execute(context)) || context.hitWall()) {
                return false;
            }
        }
    
        return context.getCurrentPosition().equals(this.getExit());
    }
}