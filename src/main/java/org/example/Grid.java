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
        return matrix[point.getY()][point.getX()];
    }

    void AjouterNavire(Navire navire, Point point, int orientation){
        int sens = -1;
        int x = point.getX();
        int y = point.getY();
        if (orientation<3){sens=1;}
        for (int i=0; i< navire.getSize(); i++){
            if (orientation%2 == 0){matrix[y+sens*i][x] = navire;}
            else {matrix[y][x+sens*i] = navire;}
        }
    }
}
