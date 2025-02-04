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

    /* returns the raw path instructions, without spaces, numbers, or any other characters
     */
    public String getPathInstructions() {
        if (path == null || path.length() == 0) {
            return "";
        }

        StringBuilder instructions = new StringBuilder();
        int count = 0;

        for (int i = 0; i< path.length(); i++) {
            char currentChar = path.charAt(i);

            if (Character.isDigit(currentChar)) {
                count = count * 10 + (currentChar - '0');
            } else if (currentChar == 'F' || currentChar == 'R' || currentChar == 'L' || currentChar == 'R') {
                int repeatCount = count == 0 ? 1 : count;
                for (int j = 0; j < repeatCount; j++) {
                    instructions.append(currentChar);
                }
                count = 0;
            }

            // all other characters are ignored
        }
        return instructions.toString();
    }

    /* 
     * returns the canonical path, where each new character is preceded by a space
     */
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

    /* 
     * returns the factorized path, where each character is preceded by 
     * the number of times it is repeated, and followed by a space
     */
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