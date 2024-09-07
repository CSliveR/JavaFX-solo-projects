package com.example.calculatrice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatriceController {
    @FXML private Button sqrtBtn;
    @FXML private Button squareBtn;
    @FXML private Button CBtn;
    @FXML private Button CEBtn;
    @FXML private Button sevenBtn;
    @FXML private Button eightBtn;
    @FXML private Button nineBtn;
    @FXML private Button divideBtn;
    @FXML private Button fourBtn;
    @FXML private Button fiveBtn;
    @FXML private Button sixBtn;
    @FXML private Button multiplyBtn;
    @FXML private Button oneBtn;
    @FXML private Button twoBtn;
    @FXML private Button threeBtn;
    @FXML private Button subtractBtn;
    @FXML private Button signBtn;
    @FXML private Button zeroBtn;
    @FXML private Button equalBtn;
    @FXML private Button addBtn;
    @FXML private TextField screen;
    private final Calculatrice calculatrice = new Calculatrice();
    private boolean saisieOperande2 = false;

    @FXML
    private void handleButtonClick(ActionEvent event){
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();

        switch(buttonText){
            case "C":
                calculatrice.reinitialiser();
                screen.clear();
                saisieOperande2 = false;
                break;
            case "CE":
                screen.clear();
                break;
            case "=":
                int resultat = calculatrice.getResultat();
                screen.setText(String.valueOf(resultat));
                calculatrice.setOperande1(resultat);
                saisieOperande2 = false;
                break;
            case "+", "-", "*", "/":
                if (!screen.getText().isEmpty() && !saisieOperande2) {
                    // Sauvegarder la valeur actuelle dans operande1
                    calculatrice.setOperande1(Integer.parseInt(screen.getText().trim()));
                    // Définir l'opérateur
                    calculatrice.setOperateur(buttonText);
                    screen.appendText(" " + buttonText + " ");  // Afficher l'opérateur
                    saisieOperande2 = true;  // Le prochain nombre saisi sera operande2
                }
                break;
            case "sqrt(x)", "x²", "+/-":
                calculatrice.setOperateur(buttonText);
                calculatrice.setOperande1(Integer.parseInt(screen.getText()));
                int fonctionResultat = calculatrice.getResultat();
                screen.setText(String.valueOf(fonctionResultat));
                calculatrice.setOperande1(fonctionResultat);
                saisieOperande2 = false;
                break;
            default:  //"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
                screen.appendText(buttonText);
                String[] parts = screen.getText().split(" ");  // Séparer les parties par l'espace
                if (parts.length == 3) {
                    calculatrice.setOperande2(Integer.parseInt(parts[2]));  // Prendre la troisième partie comme operande2
                }
                saisieOperande2 = false;
                break;
        }
    }
}