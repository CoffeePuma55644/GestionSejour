package com.mycompany.gestionsejour.gui;

import com.mycompany.gestionsejour.database.RequetesSQL;
import com.mycompany.gestionsejour.modeles.Client;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Panel des clients. On ajoute, on liste, on modifie, on supprime.
 */
public class ClientsGUI extends javax.swing.JPanel {

    /** Id du client sélectionné pour modification. -1 = aucun. */
    private int idClientEnEdition = -1;

    /**
     * Constructeur, on monte tout et on charge les clients directement.
     */
    public ClientsGUI() {
        initComponents();
        try {
            styleTableHeader();
            chargerClients();
            configurerSelectionTable();
        } catch (Exception e) {
            System.out.println("ClientsGUI : chargement initial échoué – " + e.getMessage());
        }
    }

    /**
     * En-têtes du tableau en bleu-200, c'est plus joli qu'un gris mort.
     */
    private void styleTableHeader() {
        tableClients.getTableHeader().setBackground(new java.awt.Color(191, 219, 254));
        tableClients.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
    }

    /**
     * Quand on clique sur une ligne, on pré-remplit le formulaire pour édition.
     */
    private void configurerSelectionTable() {
        tableClients.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tableClients.getSelectedRow();
                if (row >= 0) {
                    DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
                    idClientEnEdition = (int) model.getValueAt(row, 0);
                    fieldNom.setText((String) model.getValueAt(row, 1));
                    fieldPrenom.setText((String) model.getValueAt(row, 2));
                    fieldTel.setText((String) model.getValueAt(row, 3));
                    fieldAdresse.setText((String) model.getValueAt(row, 4));
                    panelFormClient.setBorder(javax.swing.BorderFactory.createTitledBorder(
                        "Modifier le client #" + idClientEnEdition));
                    btnModifierClient.setEnabled(true);
                    btnSupprimerClient.setEnabled(true);
                }
            }
        });
    }

    /**
     * Charge tous les clients depuis la BDD et remplit le tableau.
     * On vide d'abord pour pas avoir de doublons.
     */
    private void chargerClients() {
        DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
        model.setRowCount(0);

        List<Client> clients = RequetesSQL.listerClients();
        for (Client c : clients) {
            model.addRow(new Object[]{
                c.getIdClient(),
                c.getNomClient(),
                c.getPrenomClient(),
                c.getTelClient(),
                c.getAdresseClient()
            });
        }
    }

    /**
     * Vide les champs du formulaire et remet en mode "ajout".
     */
    private void viderFormulaire() {
        fieldNom.setText("");
        fieldPrenom.setText("");
        fieldTel.setText("");
        fieldAdresse.setText("");
        idClientEnEdition = -1;
        tableClients.clearSelection();
        panelFormClient.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter un client"));
        btnModifierClient.setEnabled(false);
        btnSupprimerClient.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelFormClient = new javax.swing.JPanel();
        labelNom = new javax.swing.JLabel();
        fieldNom = new javax.swing.JTextField();
        labelPrenom = new javax.swing.JLabel();
        fieldPrenom = new javax.swing.JTextField();
        labelTel = new javax.swing.JLabel();
        fieldTel = new javax.swing.JTextField();
        labelAdresse = new javax.swing.JLabel();
        fieldAdresse = new javax.swing.JTextField();
        btnAjouterClient = new javax.swing.JButton();
        panelSudClient = new javax.swing.JPanel();
        btnRafraichirClients = new javax.swing.JButton();
        btnModifierClient = new javax.swing.JButton();
        btnSupprimerClient = new javax.swing.JButton();
        scrollClients = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        panelFormClient.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter un client"));
        panelFormClient.setLayout(new java.awt.GridBagLayout());

        labelNom.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 5, 5);
        panelFormClient.add(labelNom, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 5, 15);
        panelFormClient.add(fieldNom, gridBagConstraints);

        labelPrenom.setText("Prénom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 5, 5);
        panelFormClient.add(labelPrenom, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 5, 15);
        panelFormClient.add(fieldPrenom, gridBagConstraints);

        labelTel.setText("Téléphone :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        panelFormClient.add(labelTel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        panelFormClient.add(fieldTel, gridBagConstraints);

        labelAdresse.setText("Adresse :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        panelFormClient.add(labelAdresse, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        panelFormClient.add(fieldAdresse, gridBagConstraints);

        btnAjouterClient.setText("Ajouter le client");
        btnAjouterClient.setContentAreaFilled(false);
        btnAjouterClient.setFocusPainted(false);
        btnAjouterClient.setOpaque(true);
        btnAjouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterClientActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 12, 15);
        panelFormClient.add(btnAjouterClient, gridBagConstraints);

        add(panelFormClient, java.awt.BorderLayout.NORTH);

        btnRafraichirClients.setText("Rafraîchir la liste");
        btnRafraichirClients.setContentAreaFilled(false);
        btnRafraichirClients.setFocusPainted(false);
        btnRafraichirClients.setOpaque(true);
        btnRafraichirClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRafraichirClientsActionPerformed(evt);
            }
        });
        panelSudClient.add(btnRafraichirClients);

        btnModifierClient.setText("Modifier le client");
        btnModifierClient.setContentAreaFilled(false);
        btnModifierClient.setEnabled(false);
        btnModifierClient.setFocusPainted(false);
        btnModifierClient.setOpaque(true);
        btnModifierClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierClientActionPerformed(evt);
            }
        });
        panelSudClient.add(btnModifierClient);

        btnSupprimerClient.setText("Supprimer");
        btnSupprimerClient.setContentAreaFilled(false);
        btnSupprimerClient.setEnabled(false);
        btnSupprimerClient.setFocusPainted(false);
        btnSupprimerClient.setOpaque(true);
        btnSupprimerClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerClientActionPerformed(evt);
            }
        });
        panelSudClient.add(btnSupprimerClient);

        add(panelSudClient, java.awt.BorderLayout.SOUTH);

        tableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom", "Prénom", "Téléphone", "Adresse"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableClients.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableClients.setRowHeight(28);
        scrollClients.setViewportView(tableClients);

        add(scrollClients, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterClientActionPerformed
        String nom     = fieldNom.getText().trim();
        String prenom  = fieldPrenom.getText().trim();
        String tel     = fieldTel.getText().trim();
        String adresse = fieldAdresse.getText().trim();

        if (nom.isEmpty() || prenom.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Le nom et le prénom sont obligatoires.",
                "Champs manquants", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        Client client = new Client(nom, prenom, tel, adresse);
        RequetesSQL.ajouterClient(client);
        viderFormulaire();
        chargerClients();
    }//GEN-LAST:event_btnAjouterClientActionPerformed

    private void btnRafraichirClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRafraichirClientsActionPerformed
        chargerClients();
    }//GEN-LAST:event_btnRafraichirClientsActionPerformed

    private void btnModifierClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierClientActionPerformed
        if (idClientEnEdition < 0) return;

        String nom     = fieldNom.getText().trim();
        String prenom  = fieldPrenom.getText().trim();
        String tel     = fieldTel.getText().trim();
        String adresse = fieldAdresse.getText().trim();

        if (nom.isEmpty() || prenom.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Le nom et le prénom sont obligatoires.",
                "Champs manquants", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        Client client = new Client(idClientEnEdition, nom, prenom, tel, adresse);
        RequetesSQL.modifierClient(client);
        viderFormulaire();
        chargerClients();
    }//GEN-LAST:event_btnModifierClientActionPerformed

    private void btnSupprimerClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerClientActionPerformed
        if (idClientEnEdition < 0) return;

        int confirmation = javax.swing.JOptionPane.showConfirmDialog(this,
            "Supprimer le client #" + idClientEnEdition + " ?",
            "Confirmation", javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.WARNING_MESSAGE);

        if (confirmation == javax.swing.JOptionPane.YES_OPTION) {
            RequetesSQL.supprimerClient(idClientEnEdition);
            viderFormulaire();
            chargerClients();
        }
    }//GEN-LAST:event_btnSupprimerClientActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterClient;
    private javax.swing.JButton btnModifierClient;
    private javax.swing.JButton btnRafraichirClients;
    private javax.swing.JButton btnSupprimerClient;
    private javax.swing.JTextField fieldAdresse;
    private javax.swing.JTextField fieldNom;
    private javax.swing.JTextField fieldPrenom;
    private javax.swing.JTextField fieldTel;
    private javax.swing.JLabel labelAdresse;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPrenom;
    private javax.swing.JLabel labelTel;
    private javax.swing.JPanel panelFormClient;
    private javax.swing.JPanel panelSudClient;
    private javax.swing.JScrollPane scrollClients;
    private javax.swing.JTable tableClients;
    // End of variables declaration//GEN-END:variables
}
