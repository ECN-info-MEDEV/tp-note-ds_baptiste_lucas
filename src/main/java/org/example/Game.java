package org.example;

import java.util.Scanner;

public class Game {
    private Grid grid1;
    private Grid grid2;

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
    }
    
    /**
     * Simule un tour de jeu
     */
    public void tourDeJeu(){
        System.out.println("Joueur 1, choisissez une case à attaquer");
        
    }
}
