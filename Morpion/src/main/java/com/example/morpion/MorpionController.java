package com.example.morpion;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MorpionController {
    /*  Numérotation des cases
     **    +---+---+---+
     **    | 0 | 1 | 2 |
     **    +---+---+---+
     **    | 3 | 4 | 5 |
     **    +---+---+---+
     **    | 6 | 7 | 8 |
     **    +---+---+---+
     */
    @FXML private GridPane zoneDeJeu;
    @FXML private Label phrase;
    private boolean joueur = true;
    Morpion morpion = new Morpion();
    @FXML
    public void handleClickButton(MouseEvent event){
        Label carreauClique = (Label) event.getSource();
        int row = GridPane.getRowIndex(carreauClique);
        int col = GridPane.getColumnIndex(carreauClique);
        int numCase = row * 3 + col;

        if (morpion.isCaseOccupee(numCase)) {
            // Ignorer les clics sur les cases déjà occupées
            return;
        }

        if(joueur){
            carreauClique.setText("X");
            morpion.setPlateau(carreauClique.getText(),numCase);
            phrase.setText("Votre adversaire est en train de jouer ...");
            if(morpion.checkWin()){
                phrase.setText("Fin de la partie: vous avez gagné");
                disableClick();
            }
        }else{
            carreauClique.setText("O");
            morpion.setPlateau("O", numCase);
            phrase.setText("A vous de jouer");
            if(morpion.checkWin()){
                phrase.setText("Fin de la partie: vous avez perdu");
                disableClick();
            }
        }

        joueur = !joueur;
        morpion.setCasesLibres(-1);

        if(morpion.checkDraw()){
            phrase.setText("Fin de la partie: match nul");
            disableClick();
        }
    }

    public void disableClick(){
        // Désactiver tous les labels après la fin du jeu
        for (Node label : zoneDeJeu.getChildren().filtered(node -> node instanceof Label)) {
            label.setDisable(true);
        }
    }
}


