package com.mycompany.gestionsejour.gui;

import com.mycompany.gestionsejour.database.RequetesSQL;
import com.mycompany.gestionsejour.modeles.Chambre;
import com.mycompany.gestionsejour.modeles.Client;
import com.mycompany.gestionsejour.modeles.Consommation;
import com.mycompany.gestionsejour.modeles.Sejour;
import com.mycompany.gestionsejour.modeles.Service;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Panel des séjours + consommations. Le plus riche du lot.
 * Deux formulaires, un tableau. On gère tout ici.
 */
public class SejoursGUI extends javax.swing.JPanel {

    /**
     * Construction et chargement immédiat des séjours.
     */
    public SejoursGUI() {
        initComponents();
        styleTableHeader();
        chargerSejours();
    }

    /**
     * En-têtes du tableau en bleu-200.
     */
    private void styleTableHeader() {
        tableSejours.getTableHeader().setBackground(new java.awt.Color(191, 219, 254));
        tableSejours.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
    }

    /**
     * Charge tous les séjours depuis la BDD.
     */
    private void chargerSejours() {
        DefaultTableModel model = (DefaultTableModel) tableSejours.getModel();
        model.setRowCount(0);

        List<Sejour> sejours = RequetesSQL.listerSejours();
        for (Sejour s : sejours) {
            model.addRow(new Object[]{
                s.getIdSejour(),
                s.getClient().getIdClient(),
                s.getChambre().getNumChambre(),
                s.getDateArrivee(),
                s.getDateDepart(),
                s.getNbPersonnes(),
                s.getStatutPaiement()
            });
        }
    }

    /**
     * Vide le formulaire séjour après ajout.
     */
    private void viderFormulaireSejour() {
        fieldIdClientSejour.setText("");
        fieldNumChambreSejour.setText("");
        fieldDateArrivee.setText("");
        fieldDateDepart.setText("");
        fieldNbPersonnes.setText("");
        comboStatutPaiement.setSelectedIndex(0);
    }

    /**
     * Vide le formulaire consommation après ajout.
     */
    private void viderFormulaireConso() {
        fieldIdSejourConso.setText("");
        fieldIdServiceConso.setText("");
        fieldQuantiteConso.setText("");
        fieldDateConso.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelNordSejour = new javax.swing.JPanel();
        panelFormSejour = new javax.swing.JPanel();
        labelIdClient = new javax.swing.JLabel();
        fieldIdClientSejour = new javax.swing.JTextField();
        labelNumChambreSejour = new javax.swing.JLabel();
        fieldNumChambreSejour = new javax.swing.JTextField();
        labelDateArrivee = new javax.swing.JLabel();
        fieldDateArrivee = new javax.swing.JTextField();
        labelDateDepart = new javax.swing.JLabel();
        fieldDateDepart = new javax.swing.JTextField();
        labelNbPersonnes = new javax.swing.JLabel();
        fieldNbPersonnes = new javax.swing.JTextField();
        labelStatutPaiement = new javax.swing.JLabel();
        comboStatutPaiement = new javax.swing.JComboBox<>();
        btnAjouterSejour = new javax.swing.JButton();
        panelFormConso = new javax.swing.JPanel();
        labelIdSejourConso = new javax.swing.JLabel();
        fieldIdSejourConso = new javax.swing.JTextField();
        labelIdServiceConso = new javax.swing.JLabel();
        fieldIdServiceConso = new javax.swing.JTextField();
        labelQuantiteConso = new javax.swing.JLabel();
        fieldQuantiteConso = new javax.swing.JTextField();
        labelDateConso = new javax.swing.JLabel();
        fieldDateConso = new javax.swing.JTextField();
        btnAjouterConso = new javax.swing.JButton();
        panelSudSejour = new javax.swing.JPanel();
        btnRafraichirSejours = new javax.swing.JButton();
        scrollSejours = new javax.swing.JScrollPane();
        tableSejours = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        // === PANNEAU NORD : les deux formulaires empilés ===
        panelNordSejour.setBackground(new java.awt.Color(241, 245, 249));
        panelNordSejour.setPreferredSize(new java.awt.Dimension(0, 290));
        panelNordSejour.setLayout(new java.awt.GridBagLayout());

        // --- Formulaire Séjour ---
        panelFormSejour.setBackground(new java.awt.Color(241, 245, 249));
        panelFormSejour.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter un séjour"));
        panelFormSejour.setLayout(new java.awt.GridBagLayout());

        labelIdClient.setText("ID Client :");
        labelIdClient.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 4, 5);
        panelFormSejour.add(labelIdClient, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 4, 10);
        panelFormSejour.add(fieldIdClientSejour, gridBagConstraints);

        labelNumChambreSejour.setText("N° Chambre :");
        labelNumChambreSejour.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 4, 5);
        panelFormSejour.add(labelNumChambreSejour, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 4, 10);
        panelFormSejour.add(fieldNumChambreSejour, gridBagConstraints);

        labelDateArrivee.setText("Arrivée (YYYY-MM-DD) :");
        labelDateArrivee.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 4, 5);
        panelFormSejour.add(labelDateArrivee, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 10);
        panelFormSejour.add(fieldDateArrivee, gridBagConstraints);

        labelDateDepart.setText("Départ (YYYY-MM-DD) :");
        labelDateDepart.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 4, 5);
        panelFormSejour.add(labelDateDepart, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 10);
        panelFormSejour.add(fieldDateDepart, gridBagConstraints);

        labelNbPersonnes.setText("Nb personnes :");
        labelNbPersonnes.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 4, 5);
        panelFormSejour.add(labelNbPersonnes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 10);
        panelFormSejour.add(fieldNbPersonnes, gridBagConstraints);

        labelStatutPaiement.setText("Statut paiement :");
        labelStatutPaiement.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 4, 5);
        panelFormSejour.add(labelStatutPaiement, gridBagConstraints);

        comboStatutPaiement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"En attente", "Payé", "Annulé"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 10);
        panelFormSejour.add(comboStatutPaiement, gridBagConstraints);

        btnAjouterSejour.setText("Ajouter le séjour");
        btnAjouterSejour.setBackground(new java.awt.Color(37, 99, 235));
        btnAjouterSejour.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouterSejour.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btnAjouterSejour.setFocusPainted(false);
        btnAjouterSejour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouterSejour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterSejourActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelFormSejour.add(btnAjouterSejour, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelNordSejour.add(panelFormSejour, gridBagConstraints);

        // --- Formulaire Consommation ---
        panelFormConso.setBackground(new java.awt.Color(241, 245, 249));
        panelFormConso.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter une consommation"));
        panelFormConso.setLayout(new java.awt.GridBagLayout());

        labelIdSejourConso.setText("ID Séjour :");
        labelIdSejourConso.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 4, 5);
        panelFormConso.add(labelIdSejourConso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 4, 10);
        panelFormConso.add(fieldIdSejourConso, gridBagConstraints);

        labelIdServiceConso.setText("ID Service :");
        labelIdServiceConso.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 4, 5);
        panelFormConso.add(labelIdServiceConso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 4, 10);
        panelFormConso.add(fieldIdServiceConso, gridBagConstraints);

        labelQuantiteConso.setText("Quantité :");
        labelQuantiteConso.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 4, 5);
        panelFormConso.add(labelQuantiteConso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 10);
        panelFormConso.add(fieldQuantiteConso, gridBagConstraints);

        labelDateConso.setText("Date (YYYY-MM-DD) :");
        labelDateConso.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 4, 5);
        panelFormConso.add(labelDateConso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 10);
        panelFormConso.add(fieldDateConso, gridBagConstraints);

        btnAjouterConso.setText("Ajouter la consommation");
        btnAjouterConso.setBackground(new java.awt.Color(37, 99, 235));
        btnAjouterConso.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouterConso.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btnAjouterConso.setFocusPainted(false);
        btnAjouterConso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouterConso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterConsoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        panelFormConso.add(btnAjouterConso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelNordSejour.add(panelFormConso, gridBagConstraints);

        add(panelNordSejour, java.awt.BorderLayout.NORTH);

        // --- Barre bas ---
        panelSudSejour.setBackground(new java.awt.Color(241, 245, 249));
        panelSudSejour.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnRafraichirSejours.setText("Rafraîchir la liste");
        btnRafraichirSejours.setBackground(new java.awt.Color(30, 58, 138));
        btnRafraichirSejours.setForeground(new java.awt.Color(255, 255, 255));
        btnRafraichirSejours.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        btnRafraichirSejours.setFocusPainted(false);
        btnRafraichirSejours.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRafraichirSejours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRafraichirSejoursActionPerformed(evt);
            }
        });
        panelSudSejour.add(btnRafraichirSejours);

        add(panelSudSejour, java.awt.BorderLayout.SOUTH);

        // --- Tableau ---
        tableSejours.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "ID Séjour", "ID Client", "N° Chambre", "Arrivée", "Départ", "Nb Pers.", "Paiement" }
        ) {
            public boolean isCellEditable(int row, int col) { return false; }
        });
        tableSejours.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableSejours.setRowHeight(28);
        tableSejours.setGridColor(new java.awt.Color(191, 219, 254));
        tableSejours.setSelectionBackground(new java.awt.Color(59, 130, 246));
        tableSejours.setSelectionForeground(new java.awt.Color(255, 255, 255));
        scrollSejours.setViewportView(tableSejours);

        add(scrollSejours, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterSejourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterSejourActionPerformed
        String idClientStr  = fieldIdClientSejour.getText().trim();
        String numChambreStr = fieldNumChambreSejour.getText().trim();
        String arrivee      = fieldDateArrivee.getText().trim();
        String depart       = fieldDateDepart.getText().trim();
        String nbPersStr    = fieldNbPersonnes.getText().trim();
        String statut       = (String) comboStatutPaiement.getSelectedItem();

        // Les champs texte obligatoires d'abord
        if (idClientStr.isEmpty() || numChambreStr.isEmpty() || arrivee.isEmpty() || depart.isEmpty() || nbPersStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Tous les champs sont obligatoires.",
                "Champs manquants", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idClient   = Integer.parseInt(idClientStr);
            int numChambre = Integer.parseInt(numChambreStr);
            int nbPersonnes = Integer.parseInt(nbPersStr);

            // On construit des objets "fantômes" avec juste l'id, la BDD se chargera du reste
            Client client   = new Client(idClient, "", "", "", "");
            Chambre chambre = new Chambre(numChambre, "", 0, "");

            Sejour sejour = new Sejour(arrivee, depart, nbPersonnes, statut, client, chambre);
            RequetesSQL.ajouterSejour(sejour);
            viderFormulaireSejour();
            chargerSejours();

        } catch (NumberFormatException ex) {
            // Quelqu'un a mis des lettres dans un champ numérique, on le signale
            javax.swing.JOptionPane.showMessageDialog(this,
                "L'ID client, le N° chambre et le nb de personnes doivent être des entiers.",
                "Format invalide", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAjouterSejourActionPerformed

    private void btnAjouterConsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterConsoActionPerformed
        String idSejourStr  = fieldIdSejourConso.getText().trim();
        String idServiceStr = fieldIdServiceConso.getText().trim();
        String qteStr       = fieldQuantiteConso.getText().trim();
        String dateConso    = fieldDateConso.getText().trim();

        if (idSejourStr.isEmpty() || idServiceStr.isEmpty() || qteStr.isEmpty() || dateConso.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Tous les champs consommation sont obligatoires.",
                "Champs manquants", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idSejour  = Integer.parseInt(idSejourStr);
            int idService = Integer.parseInt(idServiceStr);
            int qte       = Integer.parseInt(qteStr);

            // Idem, objets "coquilles" avec juste les ids
            Sejour sejour   = new Sejour(idSejour, "", "", 0, "", new Client(0,"","","",""), new Chambre(0,"",0,""));
            Service service = new Service(idService, "", "", 0);

            Consommation conso = new Consommation(sejour, service, qte, dateConso);
            RequetesSQL.ajouterConsommation(conso);
            viderFormulaireConso();

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "L'ID séjour, l'ID service et la quantité doivent être des entiers.",
                "Format invalide", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAjouterConsoActionPerformed

    private void btnRafraichirSejoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRafraichirSejoursActionPerformed
        chargerSejours();
    }//GEN-LAST:event_btnRafraichirSejoursActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterConso;
    private javax.swing.JButton btnAjouterSejour;
    private javax.swing.JButton btnRafraichirSejours;
    private javax.swing.JComboBox<String> comboStatutPaiement;
    private javax.swing.JTextField fieldDateArrivee;
    private javax.swing.JTextField fieldDateConso;
    private javax.swing.JTextField fieldDateDepart;
    private javax.swing.JTextField fieldIdClientSejour;
    private javax.swing.JTextField fieldIdSejourConso;
    private javax.swing.JTextField fieldIdServiceConso;
    private javax.swing.JTextField fieldNbPersonnes;
    private javax.swing.JTextField fieldNumChambreSejour;
    private javax.swing.JTextField fieldQuantiteConso;
    private javax.swing.JLabel labelDateArrivee;
    private javax.swing.JLabel labelDateConso;
    private javax.swing.JLabel labelDateDepart;
    private javax.swing.JLabel labelIdClient;
    private javax.swing.JLabel labelIdSejourConso;
    private javax.swing.JLabel labelIdServiceConso;
    private javax.swing.JLabel labelNbPersonnes;
    private javax.swing.JLabel labelNumChambreSejour;
    private javax.swing.JLabel labelQuantiteConso;
    private javax.swing.JLabel labelStatutPaiement;
    private javax.swing.JPanel panelFormConso;
    private javax.swing.JPanel panelFormSejour;
    private javax.swing.JPanel panelNordSejour;
    private javax.swing.JPanel panelSudSejour;
    private javax.swing.JScrollPane scrollSejours;
    private javax.swing.JTable tableSejours;
    // End of variables declaration//GEN-END:variables
}
