package com.mycompany.gestionsejour.modeles;

/**
 * Représente un séjour dans l'hôtel.
 * Un séjour est lié à UN client et à UNE chambre.
 * Correspond à la table SEJOUR dans la base de données.
 */
public class Sejour {

    // Identifiant unique du séjour (clé primaire)
    private int idSejour;

    // Date d'arrivée du client (format texte : "YYYY-MM-DD")
    private String dateArrivee;

    // Date de départ du client (format texte : "YYYY-MM-DD")
    private String dateDepart;

    // Nombre de personnes pour ce séjour
    private int nbPersonnes;

    // Statut du paiement (ex : "Payé", "En attente", "Annulé"...)
    private String statutPaiement;

    // Le client qui a réservé ce séjour
    private Client client;

    // La chambre réservée pour ce séjour
    private Chambre chambre;

    // --- Constructeur ---

    /**
     * Crée un séjour avec toutes ses informations.
     */
    public Sejour(int idSejour, String dateArrivee, String dateDepart,
                  int nbPersonnes, String statutPaiement,
                  Client client, Chambre chambre) {
        this.idSejour       = idSejour;
        this.dateArrivee    = dateArrivee;
        this.dateDepart     = dateDepart;
        this.nbPersonnes    = nbPersonnes;
        this.statutPaiement = statutPaiement;
        this.client         = client;
        this.chambre        = chambre;
    }

    /**
     * Constructeur sans id (utile avant l'enregistrement en BDD).
     */
    public Sejour(String dateArrivee, String dateDepart,
                  int nbPersonnes, String statutPaiement,
                  Client client, Chambre chambre) {
        this.dateArrivee    = dateArrivee;
        this.dateDepart     = dateDepart;
        this.nbPersonnes    = nbPersonnes;
        this.statutPaiement = statutPaiement;
        this.client         = client;
        this.chambre        = chambre;
    }

    // --- Getters (lire les valeurs) ---

    public int getIdSejour() {
        return idSejour;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public Client getClient() {
        return client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    // --- Setters (modifier les valeurs) ---

    public void setIdSejour(int idSejour) {
        this.idSejour = idSejour;
    }

    public void setDateArrivee(String dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    // --- Affichage ---

    /**
     * Affiche les infos du séjour sous forme de texte (utile pour déboguer).
     */
    public String toString() {
        return "Séjour #" + idSejour
                + " | Du " + dateArrivee + " au " + dateDepart
                + " | " + nbPersonnes + " personne(s)"
                + " | Paiement : " + statutPaiement
                + " | Client : " + (client != null ? client.getNomClient() : "?")
                + " | Chambre : " + (chambre != null ? chambre.getNumChambre() : "?");
    }
}
