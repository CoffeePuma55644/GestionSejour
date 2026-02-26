package com.mycompany.gestionsejour.gui;

import java.awt.CardLayout;

/**
 * Le chef d'orchestre. Sidebar + header + CardLayout.
 * C'est lui qui fait tourner tout le spectacle.
 */
public class MainGUI extends javax.swing.JPanel {

    // Le CardLayout pour switcher entre les panels, notre télécommande
    private CardLayout cardLayout;

    // Les noms des cartes, on s'y retrouve plus facilement
    private static final String CARTE_CLIENTS  = "clients";
    private static final String CARTE_CHAMBRES = "chambres";
    private static final String CARTE_SEJOURS  = "sejours";
    private static final String CARTE_SERVICES = "services";

    /**
     * Constructeur. On monte tout.
     */
    public MainGUI() {
        initComponents();

        // On ajoute les 4 sous-panels dans le CardLayout
        panelContenu.add(new ClientsGUI(),  CARTE_CLIENTS);
        panelContenu.add(new ChambresGUI(), CARTE_CHAMBRES);
        panelContenu.add(new SejoursGUI(),  CARTE_SEJOURS);
        panelContenu.add(new ServicesGUI(), CARTE_SERVICES);

        configurerCardLayout();
        // Clients est affiché en premier, logique
        afficherCarte(CARTE_CLIENTS);
        styliserBoutonActif(btnClients);
    }

    /**
     * On récupère le CardLayout du panelContenu et on le garde sous la main.
     */
    private void configurerCardLayout() {
        cardLayout = (CardLayout) panelContenu.getLayout();
    }

    /**
     * Affiche la carte demandée. Simple et efficace.
     */
    private void afficherCarte(String nom) {
        cardLayout.show(panelContenu, nom);
    }

    /**
     * Met le bouton actif en bleu-500, les autres en bleu-700.
     * Un peu de cosmétique, ça fait pas de mal.
     */
    private void styliserBoutonActif(javax.swing.JButton actif) {
        java.awt.Color inactif = new java.awt.Color(29, 78, 216);
        java.awt.Color actifColor = new java.awt.Color(59, 130, 246);

        btnClients.setBackground(inactif);
        btnChambres.setBackground(inactif);
        btnSejours.setBackground(inactif);
        btnServices.setBackground(inactif);

        actif.setBackground(actifColor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelHeader = new javax.swing.JPanel();
        labelTitre = new javax.swing.JLabel();
        panelSidebar = new javax.swing.JPanel();
        btnClients = new javax.swing.JButton();
        btnChambres = new javax.swing.JButton();
        btnSejours = new javax.swing.JButton();
        btnServices = new javax.swing.JButton();
        labelSpacer = new javax.swing.JLabel();
        panelContenu = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        // --- Header bleu foncé ---
        panelHeader.setBackground(new java.awt.Color(30, 58, 138));
        panelHeader.setPreferredSize(new java.awt.Dimension(0, 50));
        panelHeader.setLayout(new java.awt.BorderLayout());

        labelTitre.setText("  Hotel Manager");
        labelTitre.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 20));
        labelTitre.setForeground(new java.awt.Color(255, 255, 255));
        panelHeader.add(labelTitre, java.awt.BorderLayout.CENTER);

        add(panelHeader, java.awt.BorderLayout.NORTH);

        // --- Sidebar bleu foncé ---
        panelSidebar.setBackground(new java.awt.Color(30, 58, 138));
        panelSidebar.setPreferredSize(new java.awt.Dimension(180, 0));
        panelSidebar.setLayout(new java.awt.GridBagLayout());

        btnClients.setText("Clients");
        btnClients.setBackground(new java.awt.Color(29, 78, 216));
        btnClients.setForeground(new java.awt.Color(255, 255, 255));
        btnClients.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btnClients.setBorderPainted(false);
        btnClients.setFocusPainted(false);
        btnClients.setContentAreaFilled(false);
        btnClients.setOpaque(true);
        btnClients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelSidebar.add(btnClients, gridBagConstraints);

        btnChambres.setText("Chambres");
        btnChambres.setBackground(new java.awt.Color(29, 78, 216));
        btnChambres.setForeground(new java.awt.Color(255, 255, 255));
        btnChambres.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btnChambres.setBorderPainted(false);
        btnChambres.setFocusPainted(false);
        btnChambres.setContentAreaFilled(false);
        btnChambres.setOpaque(true);
        btnChambres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChambres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChambresActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelSidebar.add(btnChambres, gridBagConstraints);

        btnSejours.setText("Séjours");
        btnSejours.setBackground(new java.awt.Color(29, 78, 216));
        btnSejours.setForeground(new java.awt.Color(255, 255, 255));
        btnSejours.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btnSejours.setBorderPainted(false);
        btnSejours.setFocusPainted(false);
        btnSejours.setContentAreaFilled(false);
        btnSejours.setOpaque(true);
        btnSejours.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSejours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSejoursActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelSidebar.add(btnSejours, gridBagConstraints);

        btnServices.setText("Services");
        btnServices.setBackground(new java.awt.Color(29, 78, 216));
        btnServices.setForeground(new java.awt.Color(255, 255, 255));
        btnServices.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btnServices.setBorderPainted(false);
        btnServices.setFocusPainted(false);
        btnServices.setContentAreaFilled(false);
        btnServices.setOpaque(true);
        btnServices.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelSidebar.add(btnServices, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelSidebar.add(labelSpacer, gridBagConstraints);

        add(panelSidebar, java.awt.BorderLayout.WEST);

        panelContenu.setLayout(new java.awt.CardLayout());
        add(panelContenu, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientsActionPerformed
        afficherCarte(CARTE_CLIENTS);
        styliserBoutonActif(btnClients);
    }//GEN-LAST:event_btnClientsActionPerformed

    private void btnChambresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChambresActionPerformed
        afficherCarte(CARTE_CHAMBRES);
        styliserBoutonActif(btnChambres);
    }//GEN-LAST:event_btnChambresActionPerformed

    private void btnSejoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSejoursActionPerformed
        afficherCarte(CARTE_SEJOURS);
        styliserBoutonActif(btnSejours);
    }//GEN-LAST:event_btnSejoursActionPerformed

    private void btnServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicesActionPerformed
        afficherCarte(CARTE_SERVICES);
        styliserBoutonActif(btnServices);
    }//GEN-LAST:event_btnServicesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChambres;
    private javax.swing.JButton btnClients;
    private javax.swing.JButton btnSejours;
    private javax.swing.JButton btnServices;
    private javax.swing.JLabel labelSpacer;
    private javax.swing.JLabel labelTitre;
    private javax.swing.JPanel panelContenu;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelSidebar;
    // End of variables declaration//GEN-END:variables
}
