package com.mycompany.gestionsejour.modeles;

/**
 * Un séjour : un client + une chambre + des dates.
 * Table SEJOUR en BDD.
 */
public class Sejour {

    // Son id en BDD
    private int idSejour;

    // Quand le client arrive (YYYY-MM-DD)
    private String dateArrivee;

    // Quand il se barre (YYYY-MM-DD)
    private String dateDepart;

    // Combien de personnes dans la chambre
    private int nbPersonnes;

    // Payé ? Pas encore ? Annulé ?
    private String statutPaiement;

    // Le client qui a réservé
    private Client client;

    // La chambre qu'il a prise
    private Chambre chambre;

    // --- Constructeur ---

    /**
     * Sejour complet, avec l'id.
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
     * Sans id : pour avant l'insertion en BDD.
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

    // --- Getters ---

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

    // --- Setters ---

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
     * Pour afficher ou déboguer.
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
