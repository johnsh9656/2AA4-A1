package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    /*
     * returns the position after moving in the given direction
     */
    public Position move(Direction direction) {
        switch(direction){
            case NORTH:
                return new Position(this.x, this.y - 1);
            case EAST:
                return new Position(this.x + 1, this.y);
            case WEST:
                return new Position(this.x - 1, this.y);
            case SOUTH:
                return new Position(this.x, this.y + 1);
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    /*
     * checks if two positions are equal (have the same x and y coordinates)
     */
    public boolean equals(Position pos){
        return this.x == pos.getX() && this.y == pos.getY();
    }

    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }
}