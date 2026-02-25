package com.mycompany.gestionsejour.database;

import com.mycompany.gestionsejour.modeles.Chambre;
import com.mycompany.gestionsejour.modeles.Client;
import com.mycompany.gestionsejour.modeles.Consommation;
import com.mycompany.gestionsejour.modeles.Sejour;
import com.mycompany.gestionsejour.modeles.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Toutes les requêtes SQL au même endroit, c'est plus rangé.
 * Chaque méthode ouvre et ferme sa connexion toute seule.
 * PreparedStatement partout : pas de SQL injection chez nous.
 */
public class RequetesSQL {

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //  les clients
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * Envoie un nouveau client en BDD.
     */
    public static void ajouterClient(Client client) {
        String sql = "INSERT INTO client (nom_client, prenom_client, tel_client, adresse_client) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, client.getNomClient());
            stmt.setString(2, client.getPrenomClient());
            stmt.setString(3, client.getTelClient());
            stmt.setString(4, client.getAdresseClient());

            stmt.executeUpdate();
            System.out.println("Client ajouté : " + client.getNomClient());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
        }
    }

    /**
     * Tous les clients d'un coup.
     */
    public static List<Client> listerClients() {
        List<Client> liste = new ArrayList<>();
        String sql = "SELECT * FROM client";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // On lit ligne par ligne ce que la BDD nous renvoie
            while (rs.next()) {
                Client c = new Client(
                    rs.getInt("id_client"),
                    rs.getString("nom_client"),
                    rs.getString("prenom_client"),
                    rs.getString("tel_client"),
                    rs.getString("adresse_client")
                );
                liste.add(c);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des clients : " + e.getMessage());
        }

        return liste;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //  les chambres
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * Envoie une nouvelle chambre en BDD.
     */
    public static void ajouterChambre(Chambre chambre) {
        String sql = "INSERT INTO chambre (num_chambre, type_chambre, prix_nuit, etat_chambre) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, chambre.getNumChambre());
            stmt.setString(2, chambre.getTypeChambre());
            stmt.setDouble(3, chambre.getPrixNuit());
            stmt.setString(4, chambre.getEtatChambre());

            stmt.executeUpdate();
            System.out.println("Chambre ajoutée : #" + chambre.getNumChambre());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la chambre : " + e.getMessage());
        }
    }

    /**
     * Toutes les chambres de l'hôtel.
     */
    public static List<Chambre> listerChambres() {
        List<Chambre> liste = new ArrayList<>();
        String sql = "SELECT * FROM chambre";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Chambre c = new Chambre(
                    rs.getInt("num_chambre"),
                    rs.getString("type_chambre"),
                    rs.getDouble("prix_nuit"),
                    rs.getString("etat_chambre")
                );
                liste.add(c);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des chambres : " + e.getMessage());
        }

        return liste;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //  les services
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * Envoie un nouveau service en BDD.
     */
    public static void ajouterService(Service service) {
        String sql = "INSERT INTO service (nom_service, categorie, prix_unitaire) VALUES (?, ?, ?)";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, service.getNomService());
            stmt.setString(2, service.getCategorie());
            stmt.setDouble(3, service.getPrixUnitaire());

            stmt.executeUpdate();
            System.out.println("Service ajouté : " + service.getNomService());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du service : " + e.getMessage());
        }
    }

    /**
     * Tous les services disponibles.
     */
    public static List<Service> listerServices() {
        List<Service> liste = new ArrayList<>();
        String sql = "SELECT * FROM service";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Service s = new Service(
                    rs.getInt("id_service"),
                    rs.getString("nom_service"),
                    rs.getString("categorie"),
                    rs.getDouble("prix_unitaire")
                );
                liste.add(s);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des services : " + e.getMessage());
        }

        return liste;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //  les séjours
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * Enregistre un séjour en BDD.
     * Le client et la chambre doivent déjà exister.
     */
    public static void ajouterSejour(Sejour sejour) {
        String sql = "INSERT INTO sejour (date_arrivee, date_depart, nb_personnes, statut_paiement, id_client, num_chambre) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, sejour.getDateArrivee());
            stmt.setString(2, sejour.getDateDepart());
            stmt.setInt(3, sejour.getNbPersonnes());
            stmt.setString(4, sejour.getStatutPaiement());
            stmt.setInt(5, sejour.getClient().getIdClient());
            stmt.setInt(6, sejour.getChambre().getNumChambre());

            stmt.executeUpdate();
            System.out.println("Séjour ajouté pour le client : " + sejour.getClient().getNomClient());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du séjour : " + e.getMessage());
        }
    }

    /**
     * Tous les séjours enregistrés.
     * Attention : les objets Client/Chambre n'ont que l'id, pas toutes les infos.
     */
    public static List<Sejour> listerSejours() {
        List<Sejour> liste = new ArrayList<>();
        String sql = "SELECT * FROM sejour";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Client et Chambre "vides", juste l'id pour faire le lien
                Client client = new Client(rs.getInt("id_client"), "", "", "", "");
                Chambre chambre = new Chambre(rs.getInt("num_chambre"), "", 0, "");

                Sejour s = new Sejour(
                    rs.getInt("id_sejour"),
                    rs.getString("date_arrivee"),
                    rs.getString("date_depart"),
                    rs.getInt("nb_personnes"),
                    rs.getString("statut_paiement"),
                    client,
                    chambre
                );
                liste.add(s);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des séjours : " + e.getMessage());
        }

        return liste;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //  les consommations
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /**
     * Enregistre ce qu'un client a consommé pendant son séjour.
     */
    public static void ajouterConsommation(Consommation conso) {
        String sql = "INSERT INTO consommer (id_sejour, id_service, quantite, date_conso) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, conso.getSejour().getIdSejour());
            stmt.setInt(2, conso.getService().getIdService());
            stmt.setInt(3, conso.getQuantite());
            stmt.setString(4, conso.getDateConso());

            stmt.executeUpdate();
            System.out.println("Consommation ajoutée : " + conso.getService().getNomService());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la consommation : " + e.getMessage());
        }
    }
}
