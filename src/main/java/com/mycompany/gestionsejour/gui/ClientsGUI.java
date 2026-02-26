package com.mycompany.gestionsejour.gui;

import com.mycompany.gestionsejour.database.RequetesSQL;
import com.mycompany.gestionsejour.modeles.Client;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Panel des clients. On ajoute, on liste, on est heureux.
 */
public class ClientsGUI extends javax.swing.JPanel {

    /**
     * Constructeur, on monte tout et on charge les clients directement.
     */
    public ClientsGUI() {
        initComponents();
        try {
            styleTableHeader();
            chargerClients();
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
     * Vide les champs du formulaire après un ajout réussi. On repart à zéro.
     */
    private void viderFormulaire() {
        fieldNom.setText("");
        fieldPrenom.setText("");
        fieldTel.setText("");
        fieldAdresse.setText("");
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
        scrollClients = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        // --- Formulaire haut ---
        panelFormClient.setBackground(new java.awt.Color(241, 245, 249));
        panelFormClient.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter un client"));
        panelFormClient.setPreferredSize(new java.awt.Dimension(0, 170));
        panelFormClient.setLayout(new java.awt.GridBagLayout());

        labelNom.setText("Nom :");
        labelNom.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 5, 5);
        panelFormClient.add(labelNom, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 5, 15);
        panelFormClient.add(fieldNom, gridBagConstraints);

        labelPrenom.setText("Prénom :");
        labelPrenom.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 5, 5);
        panelFormClient.add(labelPrenom, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 5, 15);
        panelFormClient.add(fieldPrenom, gridBagConstraints);

        labelTel.setText("Téléphone :");
        labelTel.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        panelFormClient.add(labelTel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        panelFormClient.add(fieldTel, gridBagConstraints);

        labelAdresse.setText("Adresse :");
        labelAdresse.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        panelFormClient.add(labelAdresse, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        panelFormClient.add(fieldAdresse, gridBagConstraints);

        btnAjouterClient.setText("Ajouter le client");
        btnAjouterClient.setBackground(new java.awt.Color(37, 99, 235));
        btnAjouterClient.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouterClient.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btnAjouterClient.setFocusPainted(false);
        btnAjouterClient.setContentAreaFilled(false);
        btnAjouterClient.setOpaque(true);
        btnAjouterClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterClientActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 12, 15);
        panelFormClient.add(btnAjouterClient, gridBagConstraints);

        add(panelFormClient, java.awt.BorderLayout.NORTH);

        // --- Barre bas ---
        panelSudClient.setBackground(new java.awt.Color(241, 245, 249));
        panelSudClient.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnRafraichirClients.setText("Rafraîchir la liste");
        btnRafraichirClients.setBackground(new java.awt.Color(30, 58, 138));
        btnRafraichirClients.setForeground(new java.awt.Color(255, 255, 255));
        btnRafraichirClients.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        btnRafraichirClients.setFocusPainted(false);
        btnRafraichirClients.setContentAreaFilled(false);
        btnRafraichirClients.setOpaque(true);
        btnRafraichirClients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRafraichirClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRafraichirClientsActionPerformed(evt);
            }
        });
        panelSudClient.add(btnRafraichirClients);

        add(panelSudClient, java.awt.BorderLayout.SOUTH);

        // --- Tableau ---
        tableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Nom", "Prénom", "Téléphone", "Adresse" }
        ) {
            public boolean isCellEditable(int row, int col) { return false; }
        });
        tableClients.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableClients.setRowHeight(28);
        tableClients.setGridColor(new java.awt.Color(191, 219, 254));
        tableClients.setSelectionBackground(new java.awt.Color(59, 130, 246));
        tableClients.setSelectionForeground(new java.awt.Color(255, 255, 255));
        scrollClients.setViewportView(tableClients);

        add(scrollClients, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterClientActionPerformed
        String nom     = fieldNom.getText().trim();
        String prenom  = fieldPrenom.getText().trim();
        String tel     = fieldTel.getText().trim();
        String adresse = fieldAdresse.getText().trim();

        // Pas de champs vides chez nous
        if (nom.isEmpty() || prenom.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Le nom et le prénom sont obligatoires.",
                "Champs manquants", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // On envoie le nouveau client en BDD et on recharge
        Client client = new Client(nom, prenom, tel, adresse);
        RequetesSQL.ajouterClient(client);
        viderFormulaire();
        chargerClients();
    }//GEN-LAST:event_btnAjouterClientActionPerformed

    private void btnRafraichirClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRafraichirClientsActionPerformed
        // Reload depuis la BDD, simple comme bonjour
        chargerClients();
    }//GEN-LAST:event_btnRafraichirClientsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterClient;
    private javax.swing.JButton btnRafraichirClients;
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
