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
            logger.info("Reading the maze from file " + filePath);

            Maze maze = new Maze(filePath);
            Solver solver = new Solver();
            Path path = solver.solve(maze);
            System.out.println("Canonical path: " + path.getCanonicalPath());

            maze.printMaze();

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.error(e.getMessage());
        }
        logger.info("**** Computing path");
        //logger.error("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
