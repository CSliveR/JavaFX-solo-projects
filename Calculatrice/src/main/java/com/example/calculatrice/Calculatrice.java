package com.example.calculatrice;

public class Calculatrice {
    private int operande1 = Integer.MIN_VALUE;
    private int operande2 = Integer.MIN_VALUE;
    private String operateur = null;

    public Calculatrice() {}
    public void setOperande1(int valeur){
        operande1 = valeur;
    }
    public void setOperande2(int valeur){
        operande2 = valeur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public int getResultat() {
        if (operande1 == Integer.MIN_VALUE) {
            throw new IllegalStateException("Une opérande est nécessaire.");
        }
        // Si l'opérateur nécessite deux opérandes, vérifier que le deuxième est défini
        if ((operateur.compareTo("sqrt(x)") != 0 && operateur.compareTo("x²") != 0 && operateur.compareTo("+/-") != 0)
                && operande2 == Integer.MIN_VALUE) {
            throw new IllegalStateException("Une deuxième opérande est nécessaire pour l'opération " + operateur);
        }
        switch (operateur) {
            case "+":
                return operande1 + operande2;
            case "-":
                return operande1 - operande2;
            case "*":
                return operande1 * operande2;
            case "/":
                if (operande2 != 0) {
                    return operande1 / operande2;
                } else {
                    throw new ArithmeticException("Division par zéro");
                }
            case "sqrt(x)":
                return (int) Math.sqrt(operande1);
            case "x²":
                return (int) Math.pow(operande1, 2);
            case "+/-":
                return -operande1;
            default:
                throw new IllegalArgumentException("Opérateur non valide : " + operateur);
        }
    }

    public void reinitialiser(){
        operande1 = Integer.MIN_VALUE;
        operande2 = Integer.MIN_VALUE;
        operateur = null;
    }
}