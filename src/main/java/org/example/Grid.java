package org.example;

import java.util.ArrayList;

public class Grid {
    private int size = 5;
    private Navire[][] matrix;
    private ArrayList<Point> strikes;

    Grid(){
        matrix = new Navire[size][size];
        strikes = new ArrayList<Point>();
    }

    Navire findNavire(Point point){
        return matrix[point.getX()][point.getY()];
    }
}
