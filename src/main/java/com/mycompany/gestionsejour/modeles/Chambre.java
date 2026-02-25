package com.mycompany.gestionsejour.modeles;

/**
 * Représente une chambre de l'hôtel.
 * Correspond à la table CHAMBRE dans la base de données.
 */
public class Chambre {

    // Numéro de la chambre (clé primaire, ex : 101, 202...)
    private int numChambre;

    // Type de chambre (ex : "Simple", "Double", "Suite"...)
    private String typeChambre;

    // Prix par nuit en euros
    private double prixNuit;

    // État de la chambre (ex : "Disponible", "Occupée", "En nettoyage"...)
    private String etatChambre;

    // --- Constructeur ---

    /**
     * Crée une chambre avec toutes ses informations.
     */
    public Chambre(int numChambre, String typeChambre, double prixNuit, String etatChambre) {
        this.numChambre  = numChambre;
        this.typeChambre = typeChambre;
        this.prixNuit    = prixNuit;
        this.etatChambre = etatChambre;
    }

    // --- Getters (lire les valeurs) ---

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

    // --- Setters (modifier les valeurs) ---

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
     * Affiche les infos de la chambre sous forme de texte (utile pour déboguer).
     */
    public String toString() {
        return "Chambre #" + numChambre + " - " + typeChambre
                + " | Prix/nuit : " + prixNuit + "€ | État : " + etatChambre;
    }
}
