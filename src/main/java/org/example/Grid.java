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

    void ajouterNavire(Navire navire, Point point, int orientation) throws Exception{
        int sens = -1;
        int x = point.getX();
        int y = point.getY();
        if (orientation<3){sens=1;}
        for (int i=0; i< navire.getSize(); i++){
            if (orientation%2 == 0){
                if(matrix[y+sens*i][x]!=null){throw new Exception("Collision navire");}
            }
        
            else {
                if(matrix[y][x+sens*i]!=null){throw new Exception("Collision navire");}
            }
        }
        for (int i=0; i< navire.getSize(); i++){
            if (orientation%2 == 0){matrix[y+sens*i][x] = navire;}
            else {matrix[y][x+sens*i] = navire;}
        }
    }
    
    public boolean verifierNavire(int size, int x, int y, int orientation){
        boolean estdedans = true;
        if ((orientation == 1) && (y+size-1>5)){
            estdedans=false;
        }
        else if ((orientation == 2) && (x+size-1>5)){
            estdedans=false;
        }
        else if ((orientation == 3) && (y-size<0)){
            estdedans=false;
        }
        else if ((orientation == 4) && (x-size<0)){
            estdedans=false;
        }
        return estdedans;
    }
}
