package com.company;

public class Point {
    private int x;
    private  int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Formulae for finding the distance between 2 points
    // d(A,B) = Sqrt ((xB-xA) * (xB-XA) + (yB-yA) * (yB-yA))
    // Math.sqrt( (this.x - 0.0) * ( this.x - 0)  + (this.y - 0) * (this.y - 0));
    // return Math.sqrt( (getX() - x) * ( getX() - x)  + (getY() - y ) * (getY() - y));
    // return Math.sqrt( (getX() - xy.getX()) * ( getX() - xy.getX())  + (getY() - xy.getY() ) * (getY() - xy.getY()));

    public double distance(){
        // return the distance between Point and Point 0.0
        return Math.sqrt((getX()-0.0)*(getX()-0.0)+(getY()-0.0)*(getY()-0.0));

    }

    public double distance(int x, int y){
        // return distance between Point and point x,y as double
        return Math.sqrt((getX() - x)*(getX()- x) + (getY()-y)*(getY()-y));

    }

    public double distance(Point another){
        // return distance between this point and another point as double
        return Math.sqrt((getX() - another.getX())*(getX() - another.getX()) + (getY() - another.getY()) * (getY() - another.getY()));
    }
}
