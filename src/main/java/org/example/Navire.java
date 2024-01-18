package org.example;

public class Navire {
    String name;
    int size;

    Navire(int size){
        this.size = size;
        switch(size){
            case 3:
                this.name = "";
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
}
