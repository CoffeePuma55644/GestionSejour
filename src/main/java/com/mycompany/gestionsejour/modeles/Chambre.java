package com.mycompany.gestionsejour.modeles;

/**
 * Une chambre. Elle a un numéro, un type, un prix et un état.
 * Table CHAMBRE en BDD.
 */
public class Chambre {

    // Son numéro (genre 101, 202...)
    private int numChambre;

    // Simple, Double, Suite... au choix
    private String typeChambre;

    // Ce que ça coûte la nuit
    private double prixNuit;

    // Disponible ? Occupée ? En nettoyage ?
    private String etatChambre;

    // --- Constructeur ---

    /**
     * Tout en un seul coup.
     */
    public Chambre(
        int numChambre,
        String typeChambre,
        double prixNuit,
        String etatChambre
    ) {
        this.numChambre = numChambre;
        this.typeChambre = typeChambre;
        this.prixNuit = prixNuit;
        this.etatChambre = etatChambre;
    }

    // --- Getters ---

    public int getNumChambre() {
        return numChambre;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public double getPrixNuit() {
        return prixNuit;
    }

    public String getEtatChambre() {
        return etatChambre;
    }

    // --- Setters ---

    public void setNumChambre(int numChambre) {
        this.numChambre = numChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    public void setPrixNuit(double prixNuit) {
        this.prixNuit = prixNuit;
    }

    public void setEtatChambre(String etatChambre) {
        this.etatChambre = etatChambre;
    }

    // --- Affichage ---

    /**
     * Pour afficher ou déboguer.
     */
    public String toString() {
        return (
            "Chambre #" +
            numChambre +
            " - " +
            typeChambre +
            " | Prix/nuit : " +
            prixNuit +
            "$ | État : " +
            etatChambre
        );
    }
}
