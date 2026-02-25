package com.mycompany.gestionsejour.modeles;

/**
 * Représente une consommation de service pendant un séjour.
 * Exemple : un client a consommé 2 petits-déjeuners le 10 mars.
 * C'est la relation entre SEJOUR et SERVICE dans la base de données.
 */
public class Consommation {

    // Le séjour pendant lequel le service a été consommé
    private Sejour sejour;

    // Le service qui a été consommé
    private Service service;

    // Quantité consommée (ex : 2 petits-déjeuners)
    private int quantite;

    // Date de la consommation (format texte : "YYYY-MM-DD")
    private String dateConso;

    // --- Constructeur ---

    /**
     * Crée une consommation avec toutes ses informations.
     */
    public Consommation(Sejour sejour, Service service, int quantite, String dateConso) {
        this.sejour    = sejour;
        this.service   = service;
        this.quantite  = quantite;
        this.dateConso = dateConso;
    }

    // --- Getters (lire les valeurs) ---

    public Sejour getSejour() {
        return sejour;
    }

    public Service getService() {
        return service;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getDateConso() {
        return dateConso;
    }

    // --- Setters (modifier les valeurs) ---

    public void setSejour(Sejour sejour) {
        this.sejour = sejour;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDateConso(String dateConso) {
        this.dateConso = dateConso;
    }

    /**
     * Calcule le montant total de cette consommation.
     * Formule : quantité × prix unitaire du service.
     */
    public double getMontantTotal() {
        return quantite * service.getPrixUnitaire();
    }

    // --- Affichage ---

    /**
     * Affiche les infos de la consommation sous forme de texte (utile pour déboguer).
     */
    public String toString() {
        return "Consommation du " + dateConso
                + " | Service : " + (service != null ? service.getNomService() : "?")
                + " | Quantité : " + quantite
                + " | Total : " + getMontantTotal() + "€"
                + " | Séjour #" + (sejour != null ? sejour.getIdSejour() : "?");
    }
}
