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
    */
    public Position findEntry() {
        Position pos = null;
        for(int row = 0; row < maze.size(); row++){
            Integer val = maze.get(row).get(0); 
            
            if(val == 1){
                pos = new Position(row,0);
                break;
            }
        }
        logger.info("Found entrance at position: (" + pos.getX() + "," + pos.getY() + ")");
        return pos;
    }

    /*  returns exit position of the maze
    */ 
    public Position findExit() {
        Position pos = null;
        int mazeWidth = maze.size()-1;
        for(int row = 0; row < maze.size(); row++){ 
            Integer val = maze.get(row).get(mazeWidth); 
            
            if(val == 1){
                pos = new Position(row,mazeWidth);
                break;
            }
        }
        logger.info("Found exit at position: (" + pos.getX() + "," + pos.getY() + ")");
        return pos;
    }

    /*  returns value at position in range of maze
        parameters - x and y coordinates
        returns - value at position (0 or 1 for wall or path)
    */
    public Integer getValue(int x, int y){
        return maze.get(x).get(y);
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
}