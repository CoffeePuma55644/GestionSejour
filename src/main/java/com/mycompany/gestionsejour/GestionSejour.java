package com.mycompany.gestionsejour;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Le point de départ. Tout commence ici.
 */
public class GestionSejour {

    public static void main(String[] args) {

        // Swing veut qu'on lui parle dans son propre thread, on fait ça bien
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                // La fenêtre principale, bienvenue
                JFrame fenetre = new JFrame("Gestion Séjour Hôtel");

                // Croix rouge = fin du programme
                fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // 800x600, classique
                fenetre.setSize(800, 600);

                // On centre, c'est plus propre
                fenetre.setLocationRelativeTo(null);

                // On branche l'interface générée par NetBeans
                fenetre.add(new Interface());

                // Et on allume tout ça
                fenetre.setVisible(true);
            }
        });
    }
}
