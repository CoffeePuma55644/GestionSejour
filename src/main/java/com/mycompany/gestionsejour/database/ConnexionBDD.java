package com.mycompany.gestionsejour.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * YEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH
 */
public class ConnexionBDD {

    // Supabase PostgreSQL - Session Pooler (IPv4 compatible)
    private static final String URL      = "jdbc:postgresql://aws-1-eu-central-1.pooler.supabase.com:5432/postgres?sslmode=require&connectTimeout=5&socketTimeout=10";

    // Supabase user
    private static final String USER     = "postgres.ipwkimnglyerdknwnhwp";

    // Supabase password
    private static final String PASSWORD = "o2yK04KxIAeFrEoa";

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
