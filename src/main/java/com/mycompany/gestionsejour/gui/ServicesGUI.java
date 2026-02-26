package com.mycompany.gestionsejour.gui;

import com.mycompany.gestionsejour.database.RequetesSQL;
import com.mycompany.gestionsejour.modeles.Service;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Panel des services. Spa, petits-déj, parking... tout ce qui fait du fric.
 */
public class ServicesGUI extends javax.swing.JPanel {

    /**
     * Construction et chargement immédiat des services.
     */
    public ServicesGUI() {
        initComponents();
        try {
            styleTableHeader();
            chargerServices();
        } catch (Exception e) {
            System.out.println("ServicesGUI : chargement initial échoué – " + e.getMessage());
        }
    }

    /**
     * En-têtes du tableau en bleu-200.
     */
    private void styleTableHeader() {
        tableServices.getTableHeader().setBackground(new java.awt.Color(191, 219, 254));
        tableServices.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
    }

    /**
     * Charge tous les services depuis la BDD.
     */
    private void chargerServices() {
        DefaultTableModel model = (DefaultTableModel) tableServices.getModel();
        model.setRowCount(0);

        List<Service> services = RequetesSQL.listerServices();
        for (Service s : services) {
            model.addRow(new Object[]{
                s.getIdService(),
                s.getNomService(),
                s.getCategorie(),
                s.getPrixUnitaire()
            });
        }
    }

    /**
     * Vide le formulaire après ajout. Propre, prêt pour le suivant.
     */
    private void viderFormulaire() {
        fieldNomService.setText("");
        fieldCategorieService.setText("");
        fieldPrixUnitaire.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelFormService = new javax.swing.JPanel();
        labelNomService = new javax.swing.JLabel();
        fieldNomService = new javax.swing.JTextField();
        labelCategorieService = new javax.swing.JLabel();
        fieldCategorieService = new javax.swing.JTextField();
        labelPrixUnitaire = new javax.swing.JLabel();
        fieldPrixUnitaire = new javax.swing.JTextField();
        btnAjouterService = new javax.swing.JButton();
        panelSudService = new javax.swing.JPanel();
        btnRafraichirServices = new javax.swing.JButton();
        scrollServices = new javax.swing.JScrollPane();
        tableServices = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        // --- Formulaire haut ---
        panelFormService.setBackground(new java.awt.Color(241, 245, 249));
        panelFormService.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter un service"));
        panelFormService.setPreferredSize(new java.awt.Dimension(0, 170));
        panelFormService.setLayout(new java.awt.GridBagLayout());

        labelNomService.setText("Nom du service :");
        labelNomService.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 5, 5);
        panelFormService.add(labelNomService, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 5, 15);
        panelFormService.add(fieldNomService, gridBagConstraints);

        labelCategorieService.setText("Catégorie :");
        labelCategorieService.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 5, 5);
        panelFormService.add(labelCategorieService, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 5, 15);
        panelFormService.add(fieldCategorieService, gridBagConstraints);

        labelPrixUnitaire.setText("Prix unitaire (€) :");
        labelPrixUnitaire.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        panelFormService.add(labelPrixUnitaire, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
        panelFormService.add(fieldPrixUnitaire, gridBagConstraints);

        btnAjouterService.setText("Ajouter le service");
        btnAjouterService.setBackground(new java.awt.Color(37, 99, 235));
        btnAjouterService.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouterService.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btnAjouterService.setFocusPainted(false);
        btnAjouterService.setContentAreaFilled(false);
        btnAjouterService.setOpaque(true);
        btnAjouterService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouterService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterServiceActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 12, 15);
        panelFormService.add(btnAjouterService, gridBagConstraints);

        add(panelFormService, java.awt.BorderLayout.NORTH);

        // --- Barre bas ---
        panelSudService.setBackground(new java.awt.Color(241, 245, 249));
        panelSudService.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnRafraichirServices.setText("Rafraîchir la liste");
        btnRafraichirServices.setBackground(new java.awt.Color(30, 58, 138));
        btnRafraichirServices.setForeground(new java.awt.Color(255, 255, 255));
        btnRafraichirServices.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        btnRafraichirServices.setFocusPainted(false);
        btnRafraichirServices.setContentAreaFilled(false);
        btnRafraichirServices.setOpaque(true);
        btnRafraichirServices.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRafraichirServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRafraichirServicesActionPerformed(evt);
            }
        });
        panelSudService.add(btnRafraichirServices);

        add(panelSudService, java.awt.BorderLayout.SOUTH);

        // --- Tableau ---
        tableServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Nom", "Catégorie", "Prix unitaire (€)" }
        ) {
            public boolean isCellEditable(int row, int col) { return false; }
        });
        tableServices.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableServices.setRowHeight(28);
        tableServices.setGridColor(new java.awt.Color(191, 219, 254));
        tableServices.setSelectionBackground(new java.awt.Color(59, 130, 246));
        tableServices.setSelectionForeground(new java.awt.Color(255, 255, 255));
        scrollServices.setViewportView(tableServices);

        add(scrollServices, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterServiceActionPerformed
        String nom      = fieldNomService.getText().trim();
        String categorie = fieldCategorieService.getText().trim();
        String prixStr  = fieldPrixUnitaire.getText().trim();

        if (nom.isEmpty() || categorie.isEmpty() || prixStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Tous les champs sont obligatoires.",
                "Champs manquants", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double prix = Double.parseDouble(prixStr);

            Service service = new Service(nom, categorie, prix);
            RequetesSQL.ajouterService(service);
            viderFormulaire();
            chargerServices();

        } catch (NumberFormatException ex) {
            // Le prix doit être un nombre, pas un mot
            javax.swing.JOptionPane.showMessageDialog(this,
                "Le prix unitaire doit être un nombre décimal (ex: 12.50).",
                "Format invalide", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAjouterServiceActionPerformed

    private void btnRafraichirServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRafraichirServicesActionPerformed
        chargerServices();
    }//GEN-LAST:event_btnRafraichirServicesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterService;
    private javax.swing.JButton btnRafraichirServices;
    private javax.swing.JTextField fieldCategorieService;
    private javax.swing.JTextField fieldNomService;
    private javax.swing.JTextField fieldPrixUnitaire;
    private javax.swing.JLabel labelCategorieService;
    private javax.swing.JLabel labelNomService;
    private javax.swing.JLabel labelPrixUnitaire;
    private javax.swing.JPanel panelFormService;
    private javax.swing.JPanel panelSudService;
    private javax.swing.JScrollPane scrollServices;
    private javax.swing.JTable tableServices;
    // End of variables declaration//GEN-END:variables
}
