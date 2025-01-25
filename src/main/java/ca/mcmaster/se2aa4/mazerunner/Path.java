package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    private StringBuilder path;

    public Path(){
        this.path = new StringBuilder();
    }

    public void addInstruction(String instruct){
        path.append(instruct);
    }

    public StringBuilder getCanonicalPath(){
        return this.path;
    }

    public StringBuilder getFactorizedPath(){
        return this.path;
    }
}