package org.example;

public class Navire {
    private String name;
    private int size;

    Navire(int size){
        this.size = size;
        switch(size){
            case 3:
                this.name = "Destroyer";
                break;
            case 4:
                this.name = "Cuirassé";
                break;
            case 5:
                this.name = "Porte-avions";
                break;
            default:
                System.out.println("Taille incorrecte !");
        }
    }

    public int getSize() {
        return size;
    }

    public String getName(){ return name; }

    public String toString(){
        String letter = " ";
        switch(size){
            case 3:
                letter = "D";
                break;
            case 4:
                letter = "C";
                break;
            case 5:
                letter = "P";
                break;
            default:
                System.out.println("Taille incorrecte !");
        }
        return letter;
    }
}
