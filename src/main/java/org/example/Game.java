package org.example;

import java.util.Scanner;

public class Game {
    private Grid grid1;
    private Grid grid2;

    Game(){
        grid1 = new Grid();
        grid2 = new Grid();
    }
    
    public Grid initializeGrid(Grid grid){
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
        if (grid.verifierNavire(5,x,y,o)){
            try {
                grid.ajouterNavire(n, p, o);
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
        System.out.println("Où voulez-vous placer le cuirassé ? (entrez x puis y puis l'orientation)");
        x = sc.nextInt();
        y = sc.nextInt();
        System.out.println("Orientation: \n 1:haut \n 2:droite \n 3:bas \n 4:gauche");
        o = sc.nextInt();
        Point p = new Point(x,y);
        Navire n = new Navire (5);
        if (grid.verifierNavire(4,x,y,o)){
            try {
                grid.ajouterNavire(n, p, o);
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
        if (grid.verifierNavire(3,x,y,o)){
            try {
                grid.ajouterNavire(n, p, o);
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
        
        return grid;
    }
}
