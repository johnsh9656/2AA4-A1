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

    public void setX(int newX){
        this.x = newX;
    }

    public void setY(int newY){
        this.y = newY;
    }

    public boolean equals(Position pos){
        return this.x == pos.getX() && this.y == pos.getY();
    }

    public void print(){
        System.out.println("(" + this.x + ", " + this.y + ")");
    }
}