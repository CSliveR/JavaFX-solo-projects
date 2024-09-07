package com.example.morpion;

public class Morpion {
    /*  Numérotation des cases
     **    +---+---+---+
     **    | 0 | 1 | 2 |
     **    +---+---+---+
     **    | 3 | 4 | 5 |
     **    +---+---+---+
     **    | 6 | 7 | 8 |
     **    +---+---+---+
     */
    private String[] plateau;
    private int casesLibres = 9;

    public Morpion() {
        plateau = new String[9];
    }

    public void setCasesLibres(int casesLibres) {
        this.casesLibres += casesLibres;
    }
    public boolean isCaseOccupee(int numCase) {
        return plateau[numCase] != null;
    }
    public void setPlateau(String chaine, int numCase) {
        if(!isCaseOccupee(numCase)){
            this.plateau[numCase] = chaine;
        }
    }
    public boolean checkWin(){
        int [][] tripletsGagnants = {
                {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}
        };

        for(int [] triplet : tripletsGagnants){
            int a = triplet[0];
            int b = triplet[1];
            int c = triplet[2];

            if(plateau[a] != null && plateau[a].equals(plateau[b]) && plateau[b].equals(plateau[c])){
                return true;
            }
        }
        return false;
    }

    public boolean checkDraw(){
        return casesLibres == 0 && !checkWin();
    }
}
