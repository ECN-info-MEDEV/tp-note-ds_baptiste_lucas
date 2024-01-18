package org.example;

import java.util.ArrayList;

public class Point {
    private int x;
    private int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Verifie si le point est dans un ArrayList
     */
    public Boolean isInArray(ArrayList<Point> array){
        Boolean bool = false;
        for(Point p : array){
            if ((p.getX()==x)&&(p.getY()==y)){bool = true;}
        }
        return bool;
    }
}
