package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        Option fileOption = new Option("i", true, "File that contains maze");
        fileOption.setRequired(true);
        options.addOption(fileOption);
        options.addOption(new Option("p", true, "Maze path to be verified"));

        CommandLineParser parser = new DefaultParser();

        

        try {
            CommandLine cmd = parser.parse(options, args);
            String filePath = cmd.getOptionValue("i");
            Maze maze = new Maze(filePath);

            if (cmd.getOptionValue("p") != null) {
                // check if user input path is valid
                Path path = new Path(cmd.getOptionValue("p"));
                if (maze.validatePath(path)) {
                    System.out.println("Path is valid");
                } else {
                    System.out.println("Path is invalid");
                }
            } else {
                // provide factorized path for maze
                MazeSolver solver = new RightHandSolver();
                Path path = solver.solve(maze);
                System.out.println("Found factorized path: " + path.getFactorizedPath());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.error(e.getMessage());
        }
        
        logger.info("** End of MazeRunner");
    }
}
