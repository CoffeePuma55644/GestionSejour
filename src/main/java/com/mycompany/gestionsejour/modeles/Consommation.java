package com.mycompany.gestionsejour.modeles;

/**
 * Ce que le client a consommé pendant son séjour (spa, petits-déj, etc.).
 * C'est la table de liaison entre SEJOUR et SERVICE.
 */
public class Consommation {

    // Le séjour concerné
    private Sejour sejour;

    // Le service consommé
    private Service service;

    // Combien de fois (ex : 2 petits-déj)
    private int quantite;

    // Le jour où c'est arrivé (YYYY-MM-DD)
    private String dateConso;

    // --- Constructeur ---

    /**
     * Tout en une fois.
     */
    public Consommation(Sejour sejour, Service service, int quantite, String dateConso) {
        this.sejour    = sejour;
        this.service   = service;
        this.quantite  = quantite;
        this.dateConso = dateConso;
    }

    // --- Getters ---

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

    // --- Setters ---

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
     * quantite × prix du service = le montant à payer pour cette conso.
     */
    public double getMontantTotal() {
        return quantite * service.getPrixUnitaire();
    }

    // --- Affichage ---

    /**
     * Pour afficher ou déboguer.
     */
    public String toString() {
        return "Consommation du " + dateConso
                + " | Service : " + (service != null ? service.getNomService() : "?")
                + " | Quantité : " + quantite
                + " | Total : " + getMontantTotal() + "€"
                + " | Séjour #" + (sejour != null ? sejour.getIdSejour() : "?");
    }
}
