package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    private StringBuilder path;

    public Path(){
        this.path = new StringBuilder();
    }

    public Path(String path) {
        this.path = new StringBuilder(path);
    }

    public void addInstruction(String instruct){
        path.append(instruct);
    }

    public String getPathInstructions() {
        return path.toString();
    }

    public String getCanonicalPath(){
        if (path == null || path.length() == 0) {
            return "";
        }

        StringBuilder canonicalPath = new StringBuilder();
        char currentChar = path.charAt(0);

        for (int i = 1; i < path.length(); i++) {
            canonicalPath.append(currentChar);
            if (path.charAt(i) != currentChar) {
                canonicalPath.append(' ');
            }
            currentChar = path.charAt(i);
        }
        
        canonicalPath.append(currentChar);

        return canonicalPath.toString();
    }

    public String getFactorizedPath(){
        if (path == null || path.length() == 0) {
            return "";
        }

        StringBuilder factorizedPath = new StringBuilder();
        char currentChar = path.charAt(0);
        int count = 1;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == currentChar) {
                count++;
            } else {
                if (count > 1) {
                    factorizedPath.append(count);
                }
                factorizedPath.append(currentChar);
                factorizedPath.append(' ');
                currentChar = path.charAt(i);
                count = 1;
            }
        }

        if (count > 1) {
            factorizedPath.append(count);
        }
        factorizedPath.append(currentChar);

        return factorizedPath.toString();
    }
}