package com.mycompany.gestionsejour;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Classe principale de l'application Gestion Séjour Hôtel.
 * C'est ici que le programme démarre.
 */
public class GestionSejour {

    public static void main(String[] args) {

        // On lance l'interface graphique dans le bon thread (bonne pratique Swing)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                // On crée la fenêtre principale
                JFrame fenetre = new JFrame("Gestion Séjour Hôtel");

                // Quand on ferme la fenêtre, le programme se termine
                fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // On définit la taille de la fenêtre
                fenetre.setSize(800, 600);

                // On centre la fenêtre sur l'écran
                fenetre.setLocationRelativeTo(null);

                // On ajoute le panneau Interface (géré par NetBeans) dans la fenêtre
                fenetre.add(new Interface());

                // On rend la fenêtre visible
                fenetre.setVisible(true);
            }
        });
    }
}
