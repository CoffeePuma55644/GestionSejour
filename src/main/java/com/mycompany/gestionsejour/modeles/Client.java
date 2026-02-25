package com.mycompany.gestionsejour.modeles;

/**
 * Représente un client de l'hôtel.
 * Correspond à la table CLIENT dans la base de données.
 */
public class Client {

    // Identifiant unique du client (clé primaire)
    private int idClient;

    // Nom de famille du client
    private String nomClient;

    // Prénom du client
    private String prenomClient;

    // Numéro de téléphone du client
    private String telClient;

    // Adresse postale du client
    private String adresseClient;

    // --- Constructeur ---

    /**
     * Crée un nouveau client avec toutes ses informations.
     */
    public Client(int idClient, String nomClient, String prenomClient, String telClient, String adresseClient) {
        this.idClient      = idClient;
        this.nomClient     = nomClient;
        this.prenomClient  = prenomClient;
        this.telClient     = telClient;
        this.adresseClient = adresseClient;
    }

    /**
     * Constructeur sans id (utile quand on crée un client avant de l'enregistrer en BDD).
     */
    public Client(String nomClient, String prenomClient, String telClient, String adresseClient) {
        this.nomClient     = nomClient;
        this.prenomClient  = prenomClient;
        this.telClient     = telClient;
        this.adresseClient = adresseClient;
    }

    // --- Getters (lire les valeurs) ---

    public int getIdClient() {
        return idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    // --- Setters (modifier les valeurs) ---

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    // --- Affichage ---

    /**
     * Affiche les infos du client sous forme de texte (utile pour déboguer).
     */
    public String toString() {
        return "Client #" + idClient + " - " + prenomClient + " " + nomClient
                + " | Tél : " + telClient + " | Adresse : " + adresseClient;
    }
}
