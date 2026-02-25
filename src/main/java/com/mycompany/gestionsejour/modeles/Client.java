package com.mycompany.gestionsejour.modeles;

/**
 * Un client. Il vient, il dort, il paye, il repart.
 * Table CLIENT en BDD.
 */
public class Client {

    // Son id en BDD
    private int idClient;

    // Son nom de famille
    private String nomClient;

    // Son prénom
    private String prenomClient;

    // Son numéro de tel
    private String telClient;

    // Où il habite
    private String adresseClient;

    // --- Constructeur ---

    /**
     * Le grand constructeur, avec tout.
     */
    public Client(int idClient, String nomClient, String prenomClient, String telClient, String adresseClient) {
        this.idClient      = idClient;
        this.nomClient     = nomClient;
        this.prenomClient  = prenomClient;
        this.telClient     = telClient;
        this.adresseClient = adresseClient;
    }

    /**
     * Sans id : pour quand le client n'est pas encore en BDD.
     */
    public Client(String nomClient, String prenomClient, String telClient, String adresseClient) {
        this.nomClient     = nomClient;
        this.prenomClient  = prenomClient;
        this.telClient     = telClient;
        this.adresseClient = adresseClient;
    }

    // --- Getters ---

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

    // --- Setters ---

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
     * Pour afficher ou déboguer.
     */
    public String toString() {
        return "Client #" + idClient + " - " + prenomClient + " " + nomClient
                + " | Tél : " + telClient + " | Adresse : " + adresseClient;
    }
}
