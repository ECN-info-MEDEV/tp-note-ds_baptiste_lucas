package org.example;

import java.util.ArrayList;

public class Grid {
    int size = 5;
    Navire[][] matrix;
    ArrayList<Point> strikes;

    Grid(){
        matrix = new Navire[size][size];
        strikes = new ArrayList<Point>();
    }
}
