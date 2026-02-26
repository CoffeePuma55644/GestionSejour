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

    /**
     * Met à jour un client existant en BDD.
     */
    public static void modifierClient(Client client) {
        String sql = "UPDATE client SET nom_client = ?, prenom_client = ?, tel_client = ?, adresse_client = ? WHERE id_client = ?";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, client.getNomClient());
            stmt.setString(2, client.getPrenomClient());
            stmt.setString(3, client.getTelClient());
            stmt.setString(4, client.getAdresseClient());
            stmt.setInt(5, client.getIdClient());

            stmt.executeUpdate();
            System.out.println("Client modifié : #" + client.getIdClient());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du client : " + e.getMessage());
        }
    }

    /**
     * Supprime un client de la BDD par son id.
     */
    public static void supprimerClient(int idClient) {
        String sql = "DELETE FROM client WHERE id_client = ?";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idClient);

            stmt.executeUpdate();
            System.out.println("Client supprimé : #" + idClient);

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du client : " + e.getMessage());
        }
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

    /**
     * Met à jour une chambre existante en BDD.
     */
    public static void modifierChambre(Chambre chambre) {
        String sql = "UPDATE chambre SET type_chambre = ?, prix_nuit = ?, etat_chambre = ? WHERE num_chambre = ?";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, chambre.getTypeChambre());
            stmt.setDouble(2, chambre.getPrixNuit());
            stmt.setString(3, chambre.getEtatChambre());
            stmt.setInt(4, chambre.getNumChambre());

            stmt.executeUpdate();
            System.out.println("Chambre modifiée : #" + chambre.getNumChambre());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la chambre : " + e.getMessage());
        }
    }

    /**
     * Supprime une chambre de la BDD par son numéro.
     */
    public static void supprimerChambre(int numChambre) {
        String sql = "DELETE FROM chambre WHERE num_chambre = ?";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, numChambre);

            stmt.executeUpdate();
            System.out.println("Chambre supprimée : #" + numChambre);

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la chambre : " + e.getMessage());
        }
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

    /**
     * Met à jour un service existant en BDD.
     */
    public static void modifierService(Service service) {
        String sql = "UPDATE service SET nom_service = ?, categorie = ?, prix_unitaire = ? WHERE id_service = ?";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, service.getNomService());
            stmt.setString(2, service.getCategorie());
            stmt.setDouble(3, service.getPrixUnitaire());
            stmt.setInt(4, service.getIdService());

            stmt.executeUpdate();
            System.out.println("Service modifié : #" + service.getIdService());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du service : " + e.getMessage());
        }
    }

    /**
     * Supprime un service de la BDD par son id.
     */
    public static void supprimerService(int idService) {
        String sql = "DELETE FROM service WHERE id_service = ?";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idService);

            stmt.executeUpdate();
            System.out.println("Service supprimé : #" + idService);

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du service : " + e.getMessage());
        }
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

            stmt.setDate(1, java.sql.Date.valueOf(sejour.getDateArrivee()));
            stmt.setDate(2, java.sql.Date.valueOf(sejour.getDateDepart()));
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

    /**
     * Met à jour un séjour existant en BDD.
     */
    public static void modifierSejour(Sejour sejour) {
        String sql = "UPDATE sejour SET date_arrivee = ?, date_depart = ?, nb_personnes = ?, statut_paiement = ?, id_client = ?, num_chambre = ? WHERE id_sejour = ?";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setDate(1, java.sql.Date.valueOf(sejour.getDateArrivee()));
            stmt.setDate(2, java.sql.Date.valueOf(sejour.getDateDepart()));
            stmt.setInt(3, sejour.getNbPersonnes());
            stmt.setString(4, sejour.getStatutPaiement());
            stmt.setInt(5, sejour.getClient().getIdClient());
            stmt.setInt(6, sejour.getChambre().getNumChambre());
            stmt.setInt(7, sejour.getIdSejour());

            stmt.executeUpdate();
            System.out.println("Séjour modifié : #" + sejour.getIdSejour());

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du séjour : " + e.getMessage());
        }
    }

    /**
     * Supprime un séjour de la BDD par son id.
     */
    public static void supprimerSejour(int idSejour) {
        String sql = "DELETE FROM sejour WHERE id_sejour = ?";

        try {
            Connection conn = ConnexionBDD.getConnexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idSejour);

            stmt.executeUpdate();
            System.out.println("Séjour supprimé : #" + idSejour);

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du séjour : " + e.getMessage());
        }
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
