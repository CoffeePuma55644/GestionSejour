-- ============================================================
-- Gestion Séjour Hôtel — Script de création de la base
-- Base de données : gestionsejourjava
-- Utilisateur     : root / cpuma
-- Serveur         : localhost:3306
-- ============================================================

CREATE DATABASE IF NOT EXISTS gestionsejourjava
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_general_ci;

USE gestionsejourjava;

-- ------------------------------------------------------------
-- Table : client
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS client (
    id_client       INT             AUTO_INCREMENT PRIMARY KEY,
    nom_client      VARCHAR(100)    NOT NULL,
    prenom_client   VARCHAR(100)    NOT NULL,
    tel_client      VARCHAR(20),
    adresse_client  VARCHAR(255)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- Table : chambre
-- num_chambre est fourni manuellement (pas d'auto-incrément)
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS chambre (
    num_chambre     INT             PRIMARY KEY,
    type_chambre    VARCHAR(50)     NOT NULL,
    prix_nuit       DOUBLE          NOT NULL,
    etat_chambre    VARCHAR(50)     NOT NULL DEFAULT 'Disponible'
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- Table : service
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS service (
    id_service      INT             AUTO_INCREMENT PRIMARY KEY,
    nom_service     VARCHAR(100)    NOT NULL,
    categorie       VARCHAR(100),
    prix_unitaire   DOUBLE          NOT NULL
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- Table : sejour
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS sejour (
    id_sejour       INT             AUTO_INCREMENT PRIMARY KEY,
    date_arrivee    DATE            NOT NULL,
    date_depart     DATE            NOT NULL,
    nb_personnes    INT             NOT NULL DEFAULT 1,
    statut_paiement VARCHAR(50)     NOT NULL DEFAULT 'Non payé',
    id_client       INT             NOT NULL,
    num_chambre     INT             NOT NULL,
    CONSTRAINT fk_sejour_client
        FOREIGN KEY (id_client)   REFERENCES client(id_client),
    CONSTRAINT fk_sejour_chambre
        FOREIGN KEY (num_chambre) REFERENCES chambre(num_chambre)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- Table : consommer  (association séjour ↔ service)
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS consommer (
    id_sejour       INT             NOT NULL,
    id_service      INT             NOT NULL,
    quantite        INT             NOT NULL DEFAULT 1,
    date_conso      DATE            NOT NULL,
    PRIMARY KEY (id_sejour, id_service, date_conso),
    CONSTRAINT fk_conso_sejour
        FOREIGN KEY (id_sejour)  REFERENCES sejour(id_sejour),
    CONSTRAINT fk_conso_service
        FOREIGN KEY (id_service) REFERENCES service(id_service)
) ENGINE=InnoDB;
