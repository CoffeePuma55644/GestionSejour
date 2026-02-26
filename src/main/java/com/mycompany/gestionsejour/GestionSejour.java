package com.mycompany.gestionsejour;

import com.mycompany.gestionsejour.gui.MainGUI;
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

                // 1200x750 pour avoir de la place, on est pas des sauvages
                fenetre.setSize(1200, 750);

                // On centre, c'est plus propre
                fenetre.setLocationRelativeTo(null);

                // Notre beau MainGUI avec sa sidebar et son CardLayout
                fenetre.add(new MainGUI());

                // Et on allume tout ça
                fenetre.setVisible(true);
            }
        });
    }
}
