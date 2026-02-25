package com.mycompany.gestionsejour.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * YEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH
 */
public class ConnexionBDD {

    // mmmh... mon pc slm...
    private static final String URL      = "jdbc:mysql://localhost:3306/gestionsejourjava";

    // C'est moi le maitre ici
    private static final String USER     = "root";

    // Mon mot de passe
    private static final String PASSWORD = "cpuma";

    /**
     * Ouvre et ferme la porte de mySQL
     */
    public static Connection getConnexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Test  1  2 ICI LA TERRE CAMILLE
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
