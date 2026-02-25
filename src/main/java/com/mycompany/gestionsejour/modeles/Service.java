package com.mycompany.gestionsejour.modeles;

/**
 * Représente un service proposé par l'hôtel.
 * Exemples : petit-déjeuner, spa, room service, parking...
 * Correspond à la table SERVICE dans la base de données.
 */
public class Service {

    // Identifiant unique du service (clé primaire)
    private int idService;

    // Nom du service (ex : "Petit-déjeuner", "Spa", "Parking"...)
    private String nomService;

    // Catégorie du service (ex : "Restauration", "Bien-être", "Transport"...)
    private String categorie;

    // Prix unitaire du service en euros
    private double prixUnitaire;

    // --- Constructeur ---

    /**
     * Crée un service avec toutes ses informations.
     */
    public Service(int idService, String nomService, String categorie, double prixUnitaire) {
        this.idService    = idService;
        this.nomService   = nomService;
        this.categorie    = categorie;
        this.prixUnitaire = prixUnitaire;
    }

    /**
     * Constructeur sans id (utile avant l'enregistrement en BDD).
     */
    public Service(String nomService, String categorie, double prixUnitaire) {
        this.nomService   = nomService;
        this.categorie    = categorie;
        this.prixUnitaire = prixUnitaire;
    }

    // --- Getters (lire les valeurs) ---

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

    // --- Setters (modifier les valeurs) ---

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
     * Affiche les infos du service sous forme de texte (utile pour déboguer).
     */
    public String toString() {
        return "Service #" + idService + " - " + nomService
                + " | Catégorie : " + categorie
                + " | Prix unitaire : " + prixUnitaire + "€";
    }
}
