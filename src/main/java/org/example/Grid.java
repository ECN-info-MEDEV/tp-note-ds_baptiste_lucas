package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Représente une grille de jeu
 * @author lucas
 */
public class Grid {
    private int size = 5;
    private Navire[][] matrix;
    private ArrayList<Point> strikes;

    /**
     * Constructeur de la grille
     */
    Grid(){
        matrix = new Navire[size][size];
        strikes = new ArrayList<Point>();
    }

    /**
     * Permet de trouver si un point est occupé par un navire
     * @param point 
     * @return null s'il n'est pas occupé, le navire occupant le point sinon
     */
    Navire findNavire(Point point){
        return matrix[point.getY()][point.getX()];
    }

    /**
     * Ajoute un navire à une grille
     * @param navire navire à ajouter
     * @param point position de la "tête" du navire
     * @param orientation orientation du navire (1: haut, 2: droite, 3: bas, 4: gauche)
     * @throws Exception 
     */
    void ajouterNavire(Navire navire, Point point, int orientation) throws Exception{
        int sens = -1;
        int x = point.getX();
        int y = point.getY();
        if (orientation<3){sens=1;}
        for (int i=0; i< navire.getSize(); i++){
            if (orientation%2 != 0){
                if(matrix[y+sens*i-1][x-1]!=null){throw new Exception("Collision navire");}
            }
        
            else {
                if(matrix[y-1][x+sens*i-1]!=null){throw new Exception("Collision navire");}
            }
        }
        for (int i=0; i< navire.getSize(); i++){
            if (orientation%2 == 0){matrix[y+sens*i-1][x-1] = navire;}
            else {matrix[y-1][x+sens*i-1] = navire;}
        }
    }
    
    /**
     * Vérifie si un tel navire rentre bien dans la grille
     * @param size longeur du navire
     * @param x abcisse du navire
     * @param y ordonnée du navire
     * @param orientation orientation du navire
     * @return vrai s'il rentre dans la grille, faux sinon
     */
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


    void afficher(){
        System.out.println("   1 2 3 4 5");
        for (int i=0; i<size; i++){
            System.out.print(i+1 + "  ");
            for (int j=0; j<size; j++){
                if (matrix[i][j] == null){System.out.print("x");}
                else{System.out.print(matrix[i][j]);}
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    void afficherCache(){
        System.out.println("   1 2 3 4 5");
        for (int i=0; i<size; i++){
            System.out.print(i+1 + "  ");
            for (int j=0; j<size; j++){
                if (new Point(i+1, j+1).isInArray(strikes)){System.out.print("S");}
                else{System.out.print("x");}
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    
    
    
    public void initializeGrid(){
    boolean done=false;        
    int x;
    int y;
    int o;
    Scanner sc = new Scanner(System.in);
    while (done!=true){
        done=true;
        System.out.println("Où voulez-vous placer le porte-avion ? (entrez x puis y puis l'orientation)");
        x = sc.nextInt();
        y = sc.nextInt();
        System.out.println("Orientation: \n 1:haut \n 2:droite \n 3:bas \n 4:gauche");
        o = sc.nextInt();
        Point p = new Point(x,y);
        Navire n = new Navire (5);
        if (this.verifierNavire(5,x,y,o)){
            try {
                this.ajouterNavire(n, p, o);
            }
            catch (Exception e){
                System.out.println("Collision");
                System.out.println(e);
                done=false;
            }
        }
        else {
            System.out.println("En dehors de la grille");
            done=false;
        }
    }
        
        
    done=false;
    while (done!=true){
        done=true;
        System.out.println("Où voulez-vous placer le cuirassé ? (entrez x puis y puis l'orientation)");
        x = sc.nextInt();
        y = sc.nextInt();
        System.out.println("Orientation: \n 1:haut \n 2:droite \n 3:bas \n 4:gauche");
        o = sc.nextInt();
        Point p = new Point(x,y);
        Navire n = new Navire (5);
        if (this.verifierNavire(4,x,y,o)){
            try {
                this.ajouterNavire(n, p, o);
            }
            catch (Exception e){
                System.out.println("Collision");
                done=false;
            }
        }
        else {
            System.out.println("En dehors de la grille");
            done=false;
        }
    }
        
        
    done=false;
    while (done!=true){
        done=true;
        System.out.println("Où voulez-vous placer le destroyer ? (entrez x puis y puis l'orientation)");
        x = sc.nextInt();
        y = sc.nextInt();
        System.out.println("Orientation: \n 1:haut \n 2:droite \n 3:bas \n 4:gauche");
        o = sc.nextInt();
        Point p = new Point(x,y);
        Navire n = new Navire (5);
        if (this.verifierNavire(3,x,y,o)){
            try {
                this.ajouterNavire(n, p, o);
            }
            catch (Exception e){
                System.out.println("Collision");
                done=false;
            }
        }
        else {
            System.out.println("En dehors de la grille");
            done=false;
        }
    }
        
}
    
}
