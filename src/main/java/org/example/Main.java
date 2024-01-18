package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Grid grid = new Grid();
        try{
        grid.ajouterNavire(new Navire(3), new Point(1, 2), 1);}
        catch (Exception e){}
        grid.afficher();
        grid.afficherCache();
    }
}