package com.mycompany.gestionsejour.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitaire pour se connecter à la base de données MySQL.
 *
 * IMPORTANT : avant d'utiliser l'application, il faut modifier les 3 lignes
 * ci-dessous avec tes propres informations de connexion MySQL.
 */
public class ConnexionBDD {

    // Adresse de la base de données (localhost = sur ton propre PC)
    // "gestion_sejour" est le nom de la base à créer dans MySQL
    private static final String URL      = "jdbc:mysql://localhost:3306/gestion_sejour";

    // Ton nom d'utilisateur MySQL (souvent "root" en local)
    private static final String USER     = "root";

    // Ton mot de passe MySQL (à remplacer par le tien)
    private static final String PASSWORD = "motdepasse";

    /**
     * Ouvre et retourne une connexion à la base de données.
     *
     * Exemple d'utilisation :
     *   Connection conn = ConnexionBDD.getConnexion();
     *
     * Pense à fermer la connexion après utilisation :
     *   conn.close();
     */
    public static Connection getConnexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Teste si la connexion à la base de données fonctionne.
     * Affiche un message dans la console selon le résultat.
     * Utile pour vérifier que tout est bien configuré.
     */
    public static void testerConnexion() {
        try {
            Connection conn = getConnexion();
            System.out.println("Connexion à la base de données réussie !");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            System.out.println("Vérifie l'URL, le nom d'utilisateur et le mot de passe dans ConnexionBDD.java");
        }
    }
}
