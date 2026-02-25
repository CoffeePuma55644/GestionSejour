package com.mycompany.gestionsejour.modeles;

/**
 * Un service proposé par l'hôtel (petit-déj, spa, parking...).
 * Table SERVICE en BDD.
 */
public class Service {

    // Son id en BDD
    private int idService;

    // Le nom du service (Spa, Petit-déjeuner, Parking...)
    private String nomService;

    // Dans quelle catégorie il tombe
    private String categorie;

    // Son prix à l'unité
    private double prixUnitaire;

    // --- Constructeur ---

    /**
     * Constructeur complet.
     */
    public Service(int idService, String nomService, String categorie, double prixUnitaire) {
        this.idService    = idService;
        this.nomService   = nomService;
        this.categorie    = categorie;
        this.prixUnitaire = prixUnitaire;
    }

    /**
     * Sans id : pour avant l'insertion en BDD.
     */
    public Service(String nomService, String categorie, double prixUnitaire) {
        this.nomService   = nomService;
        this.categorie    = categorie;
        this.prixUnitaire = prixUnitaire;
    }

    // --- Getters ---

    public int getIdService() {
        return idService;
    }

    public String getNomService() {
        return nomService;
    }

    public String getCategorie() {
        return categorie;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    // --- Setters ---

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    // --- Affichage ---

    /**
     * Pour afficher ou déboguer.
     */
    public String toString() {
        return "Service #" + idService + " - " + nomService
                + " | Catégorie : " + categorie
                + " | Prix unitaire : " + prixUnitaire + "€";
    }
}
