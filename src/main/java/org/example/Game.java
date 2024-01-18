package org.example;

import java.util.Scanner;

/**
 * Classe de jeu
 * @author lucas
 */
public class Game {
    private Grid grid1;
    private Grid grid2;
    private boolean findepartie=false;
    private int n1=3;
    private int n2=3;

    Game(){
        grid1 = new Grid();
        grid2 = new Grid();
    }
    
  
    /**
     * Permet de jouer une partie
     */
    public void jouer(){
        System.out.println("Joueur 1, placez vos navires");
        grid1.initializeGrid();
        System.out.println("Joueur 2, placez vos navires");
        grid2.initializeGrid();
        
        while (!findepartie){
            this.tourDeJeu();
        }
    }
    
    /**
     * Simule un tour de jeu
     */
    public void tourDeJeu(){
        Scanner sc = new Scanner(System.in);
        int x;
        int y;
        
        System.out.println("Joueur 1, choisissez une case à attaquer (x puis y)");
        x = sc.nextInt();
        y = sc.nextInt();
        Point p = new Point (x,y);
        while (grid2.getStrikes().contains(p)){
            System.out.println("Vous avez déjà attaqué ce point !");
            System.out.println("Choisissez une case à attaquer (x puis y)");
            x = sc.nextInt();
            y = sc.nextInt();
            p = new Point (x,y);
        }
        grid2.setStrikes(grid2.getStrikes(),p);
        if (grid2.findNavire(p)==null){
            System.out.println("Vous n'avez rien touché");
        }
        else{
            System.out.println("Vous avez touché le "+grid2.findNavire(p).getName()+" !");
            grid2.findNavire(p).setVie(grid2.findNavire(p).getVie()-1);
        }
        if (grid2.findNavire(p).getVie()==0){
            System.out.println("Vous avez coulé le " + grid2.findNavire(p).getName()+" !");
            n2 = n2-1;
        }
        
        if (n2==0){
            System.out.println("Le joueur 1 a gagné !");
            findepartie=true;
        }
  
        
        
        System.out.println("Joueur 2, choisissez une case à attaquer (x puis y)");
        x = sc.nextInt();
        y = sc.nextInt();
        Point p1 = new Point (x,y);
        while (grid1.getStrikes().contains(p1)){
            System.out.println("Vous avez déjà attaqué ce point !");
            System.out.println("Choisissez une case à attaquer (x puis y)");
            x = sc.nextInt();
            y = sc.nextInt();
            p1 = new Point (x,y);
        }
        grid1.setStrikes(grid2.getStrikes(),p1);
        if (grid1.findNavire(p1)==null){
            System.out.println("Vous n'avez rien touché");
        }
        else{
            System.out.println("Vous avez touché le "+grid1.findNavire(p1).getName()+" !");
            grid1.findNavire(p1).setVie(grid1.findNavire(p1).getVie()-1);
        }
        if (grid1.findNavire(p1).getVie()==0){
            System.out.println("Vous avez coulé le " + grid1.findNavire(p1).getName()+" !");
            n1 = n1-1;
        }
        
        if (n1==0){
            System.out.println("Le joueur 2 a gagné !");
            findepartie=true;
        }
    }
}
