package com.mycompany.gestionsejour.gui;

import com.mycompany.gestionsejour.database.RequetesSQL;
import com.mycompany.gestionsejour.modeles.Chambre;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Panel des chambres. Numéro, type, prix, état.
 * Propre, carrelé, les draps sont frais.
 */
public class ChambresGUI extends javax.swing.JPanel {

    /**
     * Construction et chargement immédiat.
     */
    public ChambresGUI() {
        initComponents();
        styleTableHeader();
        chargerChambres();
    }

    /**
     * En-têtes bleu-200 pour le tableau.
     */
    private void styleTableHeader() {
        tableChambres.getTableHeader().setBackground(new java.awt.Color(191, 219, 254));
        tableChambres.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
    }

    /**
     * Charge toutes les chambres depuis la BDD.
     */
    private void chargerChambres() {
        DefaultTableModel model = (DefaultTableModel) tableChambres.getModel();
        model.setRowCount(0);

        List<Chambre> chambres = RequetesSQL.listerChambres();
        for (Chambre c : chambres) {
            model.addRow(new Object[]{
                c.getNumChambre(),
                c.getTypeChambre(),
                c.getPrixNuit(),
                c.getEtatChambre()
            });
        }
    }

    /**
     * Remet le formulaire à blanc. Propre comme une chambre après le ménage.
     */
    private void viderFormulaire() {
        fieldNumChambre.setText("");
        fieldPrixNuit.setText("");
        comboChambreType.setSelectedIndex(0);
        comboChambreEtat.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelFormChambre = new javax.swing.JPanel();
        labelNumChambre = new javax.swing.JLabel();
        fieldNumChambre = new javax.swing.JTextField();
        labelTypeChambre = new javax.swing.JLabel();
        comboChambreType = new javax.swing.JComboBox<>();
        labelPrixNuit = new javax.swing.JLabel();
        fieldPrixNuit = new javax.swing.JTextField();
        labelEtatChambre = new javax.swing.JLabel();
        comboChambreEtat = new javax.swing.JComboBox<>();
        btnAjouterChambre = new javax.swing.JButton();
        panelSudChambre = new javax.swing.JPanel();
        btnRafraichirChambres = new javax.swing.JButton();
        scrollChambres = new javax.swing.JScrollPane();
        tableChambres = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        // --- Formulaire haut ---
        panelFormChambre.setBackground(new java.awt.Color(241, 245, 249));
        panelFormChambre.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter une chambre"));
        panelFormChambre.setPreferredSize(new java.awt.Dimension(0, 170));
        panelFormChambre.setLayout(new java.awt.GridBagLayout());

        labelNumChambre.setText("Numéro :");
        labelNumChambre.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 5, 5);
        panelFormChambre.add(labelNumChambre, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 5, 15);
        panelFormChambre.add(fieldNumChambre, gridBagConstraints);

        labelTypeChambre.setText("Type :");
        labelTypeChambre.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 5, 5);
        panelFormChambre.add(labelTypeChambre, gridBagConstraints);

        comboChambreType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Simple", "Double", "Suite"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 5, 15);
        panelFormChambre.add(comboChambreType, gridBagConstraints);

        labelPrixNuit.setText("Prix/nuit (€) :");
        labelPrixNuit.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        panelFormChambre.add(labelPrixNuit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        panelFormChambre.add(fieldPrixNuit, gridBagConstraints);

        labelEtatChambre.setText("État :");
        labelEtatChambre.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        panelFormChambre.add(labelEtatChambre, gridBagConstraints);

        comboChambreEtat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Disponible", "Occupée", "En nettoyage"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        panelFormChambre.add(comboChambreEtat, gridBagConstraints);

        btnAjouterChambre.setText("Ajouter la chambre");
        btnAjouterChambre.setBackground(new java.awt.Color(37, 99, 235));
        btnAjouterChambre.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouterChambre.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btnAjouterChambre.setFocusPainted(false);
        btnAjouterChambre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouterChambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterChambreActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 12, 15);
        panelFormChambre.add(btnAjouterChambre, gridBagConstraints);

        add(panelFormChambre, java.awt.BorderLayout.NORTH);

        // --- Barre bas ---
        panelSudChambre.setBackground(new java.awt.Color(241, 245, 249));
        panelSudChambre.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnRafraichirChambres.setText("Rafraîchir la liste");
        btnRafraichirChambres.setBackground(new java.awt.Color(30, 58, 138));
        btnRafraichirChambres.setForeground(new java.awt.Color(255, 255, 255));
        btnRafraichirChambres.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        btnRafraichirChambres.setFocusPainted(false);
        btnRafraichirChambres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRafraichirChambres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRafraichirChambresActionPerformed(evt);
            }
        });
        panelSudChambre.add(btnRafraichirChambres);

        add(panelSudChambre, java.awt.BorderLayout.SOUTH);

        // --- Tableau ---
        tableChambres.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "Numéro", "Type", "Prix/nuit (€)", "État" }
        ) {
            public boolean isCellEditable(int row, int col) { return false; }
        });
        tableChambres.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableChambres.setRowHeight(28);
        tableChambres.setGridColor(new java.awt.Color(191, 219, 254));
        tableChambres.setSelectionBackground(new java.awt.Color(59, 130, 246));
        tableChambres.setSelectionForeground(new java.awt.Color(255, 255, 255));
        scrollChambres.setViewportView(tableChambres);

        add(scrollChambres, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterChambreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterChambreActionPerformed
        String numStr  = fieldNumChambre.getText().trim();
        String prixStr = fieldPrixNuit.getText().trim();
        String type    = (String) comboChambreType.getSelectedItem();
        String etat    = (String) comboChambreEtat.getSelectedItem();

        // Vérif numéro
        if (numStr.isEmpty() || prixStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Le numéro et le prix sont obligatoires.",
                "Champs manquants", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int num      = Integer.parseInt(numStr);
            double prix  = Double.parseDouble(prixStr);

            Chambre chambre = new Chambre(num, type, prix, etat);
            RequetesSQL.ajouterChambre(chambre);
            viderFormulaire();
            chargerChambres();

        } catch (NumberFormatException ex) {
            // L'utilisateur a mis du texte là où on voulait des chiffres
            javax.swing.JOptionPane.showMessageDialog(this,
                "Le numéro doit être un entier et le prix un nombre décimal.",
                "Format invalide", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAjouterChambreActionPerformed

    private void btnRafraichirChambresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRafraichirChambresActionPerformed
        chargerChambres();
    }//GEN-LAST:event_btnRafraichirChambresActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterChambre;
    private javax.swing.JButton btnRafraichirChambres;
    private javax.swing.JComboBox<String> comboChambreEtat;
    private javax.swing.JComboBox<String> comboChambreType;
    private javax.swing.JTextField fieldNumChambre;
    private javax.swing.JTextField fieldPrixNuit;
    private javax.swing.JLabel labelEtatChambre;
    private javax.swing.JLabel labelNumChambre;
    private javax.swing.JLabel labelPrixNuit;
    private javax.swing.JLabel labelTypeChambre;
    private javax.swing.JPanel panelFormChambre;
    private javax.swing.JPanel panelSudChambre;
    private javax.swing.JScrollPane scrollChambres;
    private javax.swing.JTable tableChambres;
    // End of variables declaration//GEN-END:variables
}
