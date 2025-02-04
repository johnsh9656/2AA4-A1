package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public Position getEntry() {
        return this.entry;
    }

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

    public boolean validatePath(Path path) {
        Position currentPos = this.entry;
        DirectionManager directionManager = new DirectionManager();

        for (char c : path.getPathInstructions().toCharArray()) {
            switch (c) {
                case 'F':
                    currentPos = currentPos.move(directionManager.getCurrentDir());

                    if (currentPos.getX() >= this.maze.getFirst().size() || 
                        currentPos.getY() >= this.maze.size() || 
                        currentPos.getX() < 0 || currentPos.getY() < 0) {
                        // out of bounds
                        return false;
                    }

                    if (isWall(currentPos)) {
                        // hit a wall
                        return false;
                    }
                    break;
                case 'R':
                    directionManager.setCurrentDir(directionManager.turnRight());
                    break;
                case 'L':
                    directionManager.setCurrentDir(directionManager.turnLeft());
                    break;
                default:
                    return false;
            }
        }
        return currentPos.equals(this.exit);
    }
}