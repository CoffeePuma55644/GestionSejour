# Guide de Presentation — GestionSejour

> **But de ce document :** Vous etes 5 dans le groupe. Chacun presente UNE partie.
> Ce guide explique tout de maniere simple, avec des analogies concretes et les vrais bouts de code du projet.
> Lisez votre partie, comprenez-la, et vous serez prets a l'expliquer a l'oral.

---

## Sommaire

| Partie | Qui presente | Sujet |
|--------|-------------|-------|
| **Partie 1** | Personne 1 | Le projet et les donnees (les Modeles) |
| **Partie 2** | Personne 2 | La base de donnees Supabase et la connexion |
| **Partie 3** | Personne 3 | Les requetes SQL (le DAO) |
| **Partie 4** | Personne 4 | L'interface graphique — la navigation |
| **Partie 5** | Personne 5 | L'interface graphique — les 4 panneaux |

---

# Comment lire ce guide

Chaque partie contient :
1. **L'analogie** — une explication simple, comme si on parlait a quelqu'un qui n'a jamais code
2. **Ce qui se passe dans le code** — les vrais fichiers, les vrais bouts de code, expliques ligne par ligne
3. **Resume oral** — ce que tu dis concretement pendant la presentation

---

---

# PARTIE 1 — Le projet et les donnees (les Modeles)

**Fichiers concernes :** `Client.java`, `Chambre.java`, `Service.java`, `Sejour.java`, `Consommation.java`
**Dossier :** `src/main/java/com/mycompany/gestionsejour/modeles/`

---

## L'analogie

Imagine que tu geres un vrai hotel. Tu as besoin de noter des informations sur :
- **Les clients** qui viennent dormir (nom, prenom, telephone, adresse)
- **Les chambres** de l'hotel (numero, type, prix par nuit, est-ce qu'elle est libre)
- **Les services** proposes (spa, petit-dejeuner, parking... avec leur prix)
- **Les sejours** (quel client est dans quelle chambre, de quelle date a quelle date)
- **Les consommations** (pendant son sejour, le client a pris 2 petits-dej et 1 spa)

Dans la vraie vie, tu noterais tout ca sur des fiches papier. En Java, on cree des **classes** qui sont exactement ces fiches. Chaque classe est un **moule** : elle dit quelles informations on garde, et on peut creer autant de fiches qu'on veut a partir de ce moule.

> **Une classe, c'est comme un formulaire vide.** Un **objet**, c'est un formulaire rempli.

---

## Ce qui se passe dans le code

### Client.java — La fiche client

```java
public class Client {
    private int idClient;          // Son numero unique en base de donnees
    private String nomClient;      // Son nom de famille
    private String prenomClient;   // Son prenom
    private String telClient;      // Son telephone
    private String adresseClient;  // Ou il habite
}
```

**Pourquoi deux constructeurs ?**

```java
// Constructeur 1 : quand on LIT un client depuis la base (on a deja son ID)
public Client(int idClient, String nomClient, String prenomClient, String telClient, String adresseClient) {
    this.idClient      = idClient;
    this.nomClient     = nomClient;
    // ... etc
}

// Constructeur 2 : quand on CREE un nouveau client (pas encore d'ID, la base le donnera)
public Client(String nomClient, String prenomClient, String telClient, String adresseClient) {
    this.nomClient     = nomClient;
    // ... etc
}
```

> **Analogie :** Quand tu remplis une fiche pour un nouveau client, tu ne connais pas encore son numero de dossier. C'est l'administration (la base de donnees) qui lui attribue un numero automatiquement. Mais quand tu retrouves une fiche dans le classeur, elle a deja son numero.

**Les Getters et Setters** — Ce sont des methodes pour **lire** (`get`) et **modifier** (`set`) les informations d'un client. C'est comme si la fiche etait dans un dossier ferme : tu ne peux pas toucher directement les infos, tu dois passer par une methode dediee.

```java
public String getNomClient() { return nomClient; }    // Lire le nom
public void setNomClient(String nomClient) { this.nomClient = nomClient; }  // Modifier le nom
```

**Le toString()** — Sert a afficher un client de maniere lisible :
```java
public String toString() {
    return "Client #" + idClient + " - " + prenomClient + " " + nomClient
            + " | Tel : " + telClient + " | Adresse : " + adresseClient;
}
// Exemple de resultat : "Client #3 - Jean Dupont | Tel : 0612345678 | Adresse : Paris"
```

---

### Chambre.java — La fiche chambre

```java
public class Chambre {
    private int numChambre;       // Ex: 101, 202, 305...
    private String typeChambre;   // "Simple", "Double" ou "Suite"
    private double prixNuit;      // Combien ca coute par nuit
    private String etatChambre;   // "Disponible", "Occupee" ou "En nettoyage"
}
```

> **Difference avec Client :** La chambre n'a qu'UN seul constructeur car le numero de chambre est choisi manuellement (101, 202...) et pas genere automatiquement par la base.

---

### Service.java — La fiche service

```java
public class Service {
    private int idService;         // Numero unique
    private String nomService;     // "Spa", "Petit-dejeuner", "Parking"...
    private String categorie;      // Dans quelle categorie (loisir, restauration...)
    private double prixUnitaire;   // Combien ca coute a l'unite
}
```

Meme logique que Client : 2 constructeurs (avec et sans ID).

---

### Sejour.java — La fiche sejour (la plus riche)

```java
public class Sejour {
    private int idSejour;
    private String dateArrivee;     // "2026-03-15"
    private String dateDepart;      // "2026-03-20"
    private int nbPersonnes;        // Combien de personnes
    private String statutPaiement;  // "En attente", "Paye" ou "Annule"
    private Client client;          // <-- LE client qui a reserve
    private Chambre chambre;        // <-- LA chambre reservee
}
```

> **Point important :** Un sejour ne contient pas juste des `int` et des `String`. Il contient un **objet Client** et un **objet Chambre**. C'est comme si, sur la fiche du sejour, tu agrafais la fiche du client ET la fiche de la chambre. En programmation, on appelle ca une **relation "has-a"** (un sejour "a un" client et "a une" chambre).

---

### Consommation.java — La fiche de ce que le client a consomme

```java
public class Consommation {
    private Sejour sejour;     // Pendant quel sejour
    private Service service;   // Quel service (spa, petit-dej...)
    private int quantite;      // Combien de fois
    private String dateConso;  // Quel jour

    // Methode bonus : calcule le prix total
    public double getMontantTotal() {
        return quantite * service.getPrixUnitaire();
    }
}
```

> **Exemple concret :** Si un client a pris 3 petits-dejeuners a 12.50 euros chacun, `getMontantTotal()` renvoie `3 * 12.50 = 37.50 euros`.

---

### Les relations entre les modeles (le schema mental)

```
Consommation ──a un──> Sejour ──a un──> Client
                                └──a un──> Chambre
             └──a un──> Service
```

Traduit en francais : *"Une consommation concerne un sejour precis et un service precis. Ce sejour est lie a un client et a une chambre."*

---

## Resume oral (ce que tu dis a la presentation)

> "Notre application gere un hotel. On a 5 entites principales : les clients, les chambres, les services, les sejours et les consommations. Chaque entite est representee par une classe Java dans le dossier `modeles`. Ces classes sont des sortes de fiches : elles contiennent les informations et des methodes pour y acceder. L'entite la plus riche est le Sejour, qui fait le lien entre un Client et une Chambre. Et la Consommation fait le lien entre un Sejour et un Service — par exemple, quand un client prend un petit-dejeuner pendant son sejour."

---

---

# PARTIE 2 — La base de donnees Supabase et la connexion

**Fichiers concernes :** `schema.sql`, `ConnexionBDD.java`
**Dossier :** `src/main/java/com/mycompany/gestionsejour/database/`

---

## L'analogie

Nos modeles (Partie 1), c'est comme des fiches papier qu'on remplit en Java. Mais quand on ferme l'application, tout disparait de la memoire. Il nous faut un **classeur permanent** ou stocker ces fiches. Ce classeur, c'est la **base de donnees**.

On utilise **Supabase**, qui est un service cloud. Au lieu d'installer une base de donnees sur notre ordinateur, on la met **sur Internet** (dans le cloud, hebergee sur Amazon Web Services en Europe). L'avantage ? N'importe qui dans le groupe peut lancer l'app et acceder aux memes donnees, peu importe son ordinateur.

> **Supabase, c'est comme un Google Drive pour les bases de donnees.** Les donnees sont en ligne, accessibles de partout.

Sous le capot, Supabase utilise **PostgreSQL**, qui est un des moteurs de base de donnees les plus utilises au monde.

---

## Ce qui se passe dans le code

### schema.sql — Le plan du classeur

Ce fichier decrit **la structure** de nos 5 tables (= 5 tiroirs du classeur). Il ne contient pas de donnees, juste la forme des tiroirs.

**Table `client` :**
```sql
CREATE TABLE IF NOT EXISTS client (
    id_client       INT             AUTO_INCREMENT PRIMARY KEY,  -- Numero unique, genere auto
    nom_client      VARCHAR(100)    NOT NULL,                    -- Obligatoire
    prenom_client   VARCHAR(100)    NOT NULL,
    tel_client      VARCHAR(20),                                 -- Optionnel
    adresse_client  VARCHAR(255)
);
```

> **Ce que ca veut dire :**
> - `id_client` est le numero unique de chaque client. `AUTO_INCREMENT` = la base le genere toute seule (1, 2, 3...)
> - `PRIMARY KEY` = c'est la cle primaire, l'identifiant unique de chaque ligne
> - `NOT NULL` = ce champ est obligatoire, on ne peut pas le laisser vide
> - `VARCHAR(100)` = du texte de max 100 caracteres

**Table `sejour` — avec des cles etrangeres :**
```sql
CREATE TABLE IF NOT EXISTS sejour (
    id_sejour       INT             AUTO_INCREMENT PRIMARY KEY,
    date_arrivee    DATE            NOT NULL,
    date_depart     DATE            NOT NULL,
    nb_personnes    INT             NOT NULL DEFAULT 1,
    statut_paiement VARCHAR(50)     NOT NULL DEFAULT 'Non paye',
    id_client       INT             NOT NULL,
    num_chambre     INT             NOT NULL,
    CONSTRAINT fk_sejour_client
        FOREIGN KEY (id_client)   REFERENCES client(id_client),
    CONSTRAINT fk_sejour_chambre
        FOREIGN KEY (num_chambre) REFERENCES chambre(num_chambre)
);
```

> **Les cles etrangeres (`FOREIGN KEY`), c'est quoi ?**
> Imagine que sur la fiche du sejour, tu ecris le numero du client. La cle etrangere, c'est une regle qui dit : "Ce numero DOIT correspondre a un client qui existe vraiment dans le tiroir des clients." Ca empeche de creer un sejour pour un client fantome.

**Table `consommer` — la table de liaison :**
```sql
CREATE TABLE IF NOT EXISTS consommer (
    id_sejour       INT             NOT NULL,
    id_service      INT             NOT NULL,
    quantite        INT             NOT NULL DEFAULT 1,
    date_conso      DATE            NOT NULL,
    PRIMARY KEY (id_sejour, id_service, date_conso),  -- Cle primaire COMPOSITE
    FOREIGN KEY (id_sejour)  REFERENCES sejour(id_sejour),
    FOREIGN KEY (id_service) REFERENCES service(id_service)
);
```

> **Cle primaire composite :** Ici, l'identifiant unique n'est pas UN seul champ, mais la COMBINAISON de trois champs (sejour + service + date). Ca veut dire : un meme client ne peut pas consommer le meme service deux fois le meme jour (ce qui a du sens : on enregistre la quantite a la place).

---

### ConnexionBDD.java — La cle pour ouvrir le classeur

```java
public class ConnexionBDD {

    // L'adresse de notre base Supabase dans le cloud
    private static final String URL = "jdbc:postgresql://aws-1-eu-central-1.pooler.supabase.com:5432/postgres?sslmode=require&connectTimeout=5&socketTimeout=10";

    // Notre identifiant Supabase
    private static final String USER = "postgres.ipwkimnglyerdknwnhwp";

    // Notre mot de passe Supabase
    private static final String PASSWORD = "o2yK04KxIAeFrEoa";

    // Ouvre une connexion vers la base
    public static Connection getConnexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

**Decodons l'URL piece par piece :**

| Morceau | Signification |
|---------|--------------|
| `jdbc:postgresql://` | On utilise JDBC (Java Database Connectivity) pour parler a PostgreSQL |
| `aws-1-eu-central-1.pooler.supabase.com` | L'adresse du serveur Supabase (heberge sur AWS en Europe centrale) |
| `:5432` | Le port de PostgreSQL (comme un numero de porte) |
| `/postgres` | Le nom de la base de donnees |
| `sslmode=require` | La connexion est **chiffree** (securisee, comme le cadenas HTTPS) |
| `connectTimeout=5` | Si le serveur ne repond pas en 5 secondes, on abandonne |

> **Analogie :** `getConnexion()` c'est comme appeler le secretaire de l'hotel pour qu'il te donne les cles du bureau. A chaque fois qu'on veut lire ou ecrire des donnees, on appelle cette methode pour "ouvrir la porte", et on la ferme quand on a fini.

**La methode `testerConnexion()` :**
```java
public static void testerConnexion() {
    try {
        Connection conn = getConnexion();
        System.out.println("Connexion a la base de donnees reussie !");
        conn.close();
    } catch (SQLException e) {
        System.out.println("Erreur de connexion : " + e.getMessage());
    }
}
```
> C'est juste un test : on ouvre la porte, si ca marche on dit "OK", sinon on affiche l'erreur. Utile pour verifier que Supabase est bien accessible.

---

### L'historique : de MySQL local a Supabase cloud

Si vous regardez les branches Git du projet :
- `my-sql-version` : l'ancienne version qui utilisait MySQL installe sur la machine (`localhost:3306`)
- `main` : la version actuelle qui utilise Supabase (PostgreSQL cloud)

Pourquoi la migration ? Avec MySQL local, chaque membre du groupe devait installer MySQL sur son PC et avoir les memes donnees. Avec Supabase, on a tous la meme base, en ligne. Le code Java n'a quasiment pas change : on a juste modifie l'URL, le user, le mot de passe, et remplace le driver `mysql-connector-java` par `postgresql` dans le `pom.xml`.

---

## Resume oral

> "Les donnees de notre application sont stockees dans une base PostgreSQL hebergee sur Supabase, un service cloud. Le fichier `schema.sql` definit la structure des 5 tables : client, chambre, service, sejour et consommer. Chaque table a une cle primaire et les tables sejour et consommer ont des cles etrangeres pour garantir la coherence des donnees. La connexion se fait via la classe `ConnexionBDD`, qui utilise JDBC pour se connecter a Supabase avec une URL securisee en SSL. On est partis d'une version MySQL locale et on a migre vers Supabase pour que tout le groupe puisse travailler sur les memes donnees a distance."

---

---

# PARTIE 3 — Les requetes SQL (le DAO)

**Fichier concerne :** `RequetesSQL.java`
**Dossier :** `src/main/java/com/mycompany/gestionsejour/database/`

---

## L'analogie

OK donc maintenant on a nos fiches (les modeles) et notre classeur (la base de donnees + la connexion). Mais il manque quelqu'un pour aller chercher les fiches, en ajouter des nouvelles, etc. Ce quelqu'un, c'est **le secretaire**. En programmation, on appelle ca un **DAO** (Data Access Object = objet qui accede aux donnees).

Le fichier `RequetesSQL.java`, c'est notre secretaire. C'est le SEUL a avoir le droit de parler a la base de donnees. Les panneaux graphiques (l'interface) ne font jamais de SQL directement : ils demandent toujours au secretaire.

> **Une methode du DAO, c'est comme une mission donnee au secretaire :** "Va me chercher la liste de tous les clients" ou "Ajoute cette nouvelle chambre dans le classeur."

---

## Ce qui se passe dans le code

### La structure generale

Toutes les methodes sont **`static`** (on les appelle directement sur la classe, pas besoin de creer un objet). Chaque methode suit le meme schema :

```
1. Ouvrir la connexion  (ConnexionBDD.getConnexion())
2. Preparer la requete SQL
3. Executer la requete
4. Fermer la connexion
```

> **Analogie :** Le secretaire se leve, va au classeur, fait son travail, revient a son bureau et ferme le classeur. A chaque mission, c'est le meme rituel.

---

### Exemple detaille : ajouter un client

```java
public static void ajouterClient(Client client) {
    // Etape 1 : La requete SQL avec des "?" (des trous a remplir)
    String sql = "INSERT INTO client (nom_client, prenom_client, tel_client, adresse_client) VALUES (?, ?, ?, ?)";

    try {
        // Etape 2 : On ouvre la connexion
        Connection conn = ConnexionBDD.getConnexion();

        // Etape 3 : On prepare la requete (les "?" seront remplaces)
        PreparedStatement stmt = conn.prepareStatement(sql);

        // Etape 4 : On remplit les trous avec les infos du client
        stmt.setString(1, client.getNomClient());     // Le 1er "?" = nom
        stmt.setString(2, client.getPrenomClient());   // Le 2eme "?" = prenom
        stmt.setString(3, client.getTelClient());      // Le 3eme "?" = tel
        stmt.setString(4, client.getAdresseClient());  // Le 4eme "?" = adresse

        // Etape 5 : On execute (envoie la requete a la base)
        stmt.executeUpdate();

        // Etape 6 : On ferme tout proprement
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
    }
}
```

> **Pourquoi des `?` et pas directement les valeurs ?** C'est ce qu'on appelle un **PreparedStatement**. Ca protege contre les **injections SQL** (une attaque ou un pirate pourrait mettre du code SQL malveillant dans un champ de formulaire). Avec les `?`, Java traite tout comme du texte pur, jamais comme du code SQL.

> **Analogie securite :** C'est comme un guichet avec une vitre. Le client ecrit sa demande sur un papier et le glisse sous la vitre. Le secretaire le lit comme du texte, il ne va jamais executer ce qui est ecrit comme un ordre. Si quelqu'un ecrit "Supprime tous les clients", le secretaire lit juste les mots, il ne les execute pas.

---

### Exemple detaille : lister tous les clients

```java
public static List<Client> listerClients() {
    List<Client> liste = new ArrayList<>();    // On prepare un panier vide
    String sql = "SELECT * FROM client";       // "Donne-moi TOUT le tiroir client"

    try {
        Connection conn = ConnexionBDD.getConnexion();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();    // executeQuery car on LIT (pas d'ecriture)

        // On parcourt chaque ligne renvoyee par la base
        while (rs.next()) {
            Client c = new Client(
                rs.getInt("id_client"),          // On lit la colonne "id_client"
                rs.getString("nom_client"),       // On lit la colonne "nom_client"
                rs.getString("prenom_client"),
                rs.getString("tel_client"),
                rs.getString("adresse_client")
            );
            liste.add(c);   // On ajoute le client au panier
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        System.out.println("Erreur : " + e.getMessage());
    }

    return liste;   // On renvoie le panier plein
}
```

> **`executeUpdate()` vs `executeQuery()` :**
> - `executeUpdate()` = on MODIFIE la base (INSERT, UPDATE, DELETE)
> - `executeQuery()` = on LIT la base (SELECT) et on recoit un `ResultSet`
>
> **Le `ResultSet`**, c'est comme un curseur qui se deplace ligne par ligne dans les resultats. `rs.next()` = "passe a la ligne suivante". `rs.getString("nom_client")` = "lis-moi la valeur de la colonne nom_client sur cette ligne."

---

### Toutes les methodes du DAO

| Methode | SQL | Ce qu'elle fait |
|---------|-----|-----------------|
| `ajouterClient(Client)` | `INSERT INTO client ...` | Ajoute un nouveau client |
| `listerClients()` | `SELECT * FROM client` | Renvoie tous les clients |
| `ajouterChambre(Chambre)` | `INSERT INTO chambre ...` | Ajoute une nouvelle chambre |
| `listerChambres()` | `SELECT * FROM chambre` | Renvoie toutes les chambres |
| `ajouterService(Service)` | `INSERT INTO service ...` | Ajoute un nouveau service |
| `listerServices()` | `SELECT * FROM service` | Renvoie tous les services |
| `ajouterSejour(Sejour)` | `INSERT INTO sejour ...` | Ajoute un sejour (avec l'ID du client et le N* de chambre) |
| `listerSejours()` | `SELECT * FROM sejour` | Renvoie tous les sejours |
| `ajouterConsommation(Consommation)` | `INSERT INTO consommer ...` | Enregistre une consommation |

---

### Les particularites a connaitre

**1. Les "objets fantomes" dans `listerSejours()` :**
```java
Client client = new Client(rs.getInt("id_client"), "", "", "", "");
Chambre chambre = new Chambre(rs.getInt("num_chambre"), "", 0, "");
```
Quand on liste les sejours, la requete ne fait pas de `JOIN` (pas de jointure entre les tables). Donc on n'a que l'ID du client et le numero de chambre, pas leur nom ou type. On cree des objets "vides" avec juste l'ID. C'est un raccourci.

**2. Pas de UPDATE ni DELETE :**
Le DAO ne permet que d'ajouter (`INSERT`) et de lister (`SELECT`). On ne peut pas modifier ni supprimer des donnees depuis l'application. C'est une limitation connue du projet.

**3. Pas de `listerConsommations()` :**
On peut ajouter des consommations, mais on ne peut pas les afficher. Il n'y a pas de methode pour les lister ni de tableau dans l'interface pour les voir.

---

## Resume oral

> "La classe `RequetesSQL` est notre DAO — c'est le seul point de contact entre l'application et la base de donnees. Elle contient des methodes statiques pour ajouter et lister les donnees de chaque entite. Chaque methode ouvre sa propre connexion, prepare une requete SQL avec des `PreparedStatement` pour eviter les injections SQL, execute la requete, puis ferme la connexion. On a des methodes `ajouter` (INSERT) et `lister` (SELECT) pour les clients, chambres, services et sejours. Les consommations peuvent etre ajoutees mais pas encore listees. C'est une limitation connue qu'on pourrait ameliorer."

---

---

# PARTIE 4 — L'interface graphique — La navigation

**Fichiers concernes :** `GestionSejour.java`, `MainGUI.java`
**Dossier :** `src/main/java/com/mycompany/gestionsejour/` et `gui/`

---

## L'analogie

Imagine une application comme un **immeuble** :
- `GestionSejour.java` c'est la **cle de l'immeuble** — c'est lui qui ouvre la porte (lance la fenetre)
- `MainGUI.java` c'est le **hall d'entree** — il y a un panneau de direction (la sidebar a gauche) et une grande zone centrale qui change selon ou tu veux aller

Quand tu cliques sur "Clients" dans la sidebar, la zone centrale affiche le panneau des clients. Quand tu cliques sur "Chambres", elle change pour afficher le panneau des chambres. C'est toujours la meme zone, mais le contenu change. Ce systeme s'appelle un **CardLayout** en Java Swing — comme un jeu de cartes ou on ne voit qu'une carte a la fois.

---

## Ce qui se passe dans le code

### GestionSejour.java — Le demarrage de l'application

```java
public class GestionSejour {
    public static void main(String[] args) {

        // Swing veut qu'on lui parle dans son propre thread, on fait ca bien
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JFrame fenetre = new JFrame("Gestion Sejour Hotel");  // La fenetre
                fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Fermer = quitter
                fenetre.setSize(1200, 750);           // Taille en pixels
                fenetre.setLocationRelativeTo(null);   // Centre sur l'ecran
                fenetre.add(new MainGUI());            // On met le MainGUI dedans
                fenetre.setVisible(true);              // On rend visible
            }
        });
    }
}
```

> **Pourquoi `SwingUtilities.invokeLater()` ?**
> Java Swing (la librairie pour creer des interfaces) a une regle : tout ce qui touche a l'affichage doit se faire dans un thread (fil d'execution) special appele **EDT** (Event Dispatch Thread). C'est comme une file d'attente : toutes les actions d'affichage passent une par une pour eviter les bugs visuels. `invokeLater` dit : "mets ce code dans la file d'attente de l'EDT".
>
> **Analogie :** C'est comme au McDo — tu ne vas pas directement en cuisine preparer ton burger. Tu passes commande au comptoir (l'EDT), et le comptoir gere l'ordre des commandes.

---

### MainGUI.java — Le chef d'orchestre

**La structure visuelle :**
```
+--------------------------------------------------+
|              HEADER (bleu fonce)                  |   <- panelHeader (NORTH)
|              "Hotel Manager"                      |
+----------+---------------------------------------+
|          |                                        |
| SIDEBAR  |          ZONE CENTRALE                 |   <- panelContenu (CENTER)
| (bleu)   |          (CardLayout)                  |
|          |                                        |
| [Clients]|   Affiche UN panneau a la fois :       |
| [Chambres]   - ClientsGUI                        |
| [Sejours]|   - ChambresGUI                        |
| [Services]   - SejoursGUI                        |
|          |   - ServicesGUI                         |
|          |                                        |
+----------+---------------------------------------+
```

**Les 3 zones utilisent `BorderLayout` :**
```java
setLayout(new java.awt.BorderLayout());
add(panelHeader,  java.awt.BorderLayout.NORTH);   // En haut
add(panelSidebar, java.awt.BorderLayout.WEST);    // A gauche
add(panelContenu, java.awt.BorderLayout.CENTER);   // Au centre
```

> **`BorderLayout`, c'est quoi ?** C'est un gestionnaire de disposition qui divise l'ecran en 5 zones : NORTH (haut), SOUTH (bas), WEST (gauche), EAST (droite), CENTER (milieu). On place un composant dans chaque zone.

---

**Le CardLayout — le systeme de cartes :**

```java
// Dans le constructeur, on ajoute les 4 panneaux comme des "cartes" nommees
panelContenu.add(new ClientsGUI(),  "clients");
panelContenu.add(new ChambresGUI(), "chambres");
panelContenu.add(new SejoursGUI(),  "sejours");
panelContenu.add(new ServicesGUI(), "services");
```

```java
// Pour afficher une carte, on appelle :
private void afficherCarte(String nom) {
    cardLayout.show(panelContenu, nom);   // "montre la carte qui s'appelle <nom>"
}
```

> **Analogie :** Imagine 4 transparents empiles. Le `CardLayout`, c'est le mecanisme qui met un transparent au-dessus de la pile. `show("clients")` = "mets le transparent Clients devant".

---

**Quand on clique sur un bouton de la sidebar :**

```java
private void btnClientsActionPerformed(java.awt.event.ActionEvent evt) {
    afficherCarte("clients");          // Affiche le panneau Clients
    styliserBoutonActif(btnClients);   // Met le bouton en surbrillance
}
```

```java
// Le bouton actif est bleu clair, les autres bleu fonce
private void styliserBoutonActif(javax.swing.JButton actif) {
    java.awt.Color inactif = new java.awt.Color(29, 78, 216);     // Bleu fonce
    java.awt.Color actifColor = new java.awt.Color(59, 130, 246); // Bleu clair

    btnClients.setBackground(inactif);   // Tous en bleu fonce
    btnChambres.setBackground(inactif);
    btnSejours.setBackground(inactif);
    btnServices.setBackground(inactif);

    actif.setBackground(actifColor);     // Celui qu'on a clique en bleu clair
}
```

> **Le flux complet d'un clic :**
> 1. L'utilisateur clique sur "Chambres"
> 2. Java Swing detecte le clic et appelle `btnChambresActionPerformed()`
> 3. Cette methode appelle `afficherCarte("chambres")` → le CardLayout affiche ChambresGUI
> 4. Elle appelle aussi `styliserBoutonActif(btnChambres)` → le bouton change de couleur

---

**Le design visuel :**
- **Header :** fond bleu fonce (`#1E3A8A`), hauteur 50px, titre "Hotel Manager" en blanc gras 20pt
- **Sidebar :** fond bleu fonce, largeur 180px, boutons blancs avec coins arrondis et cursor pointer
- **Zone centrale :** fond gris clair, contenu dynamique

Les boutons sont configures pour ne pas avoir de bordure par defaut (`setBorderPainted(false)`) et sont rendus opaques pour que la couleur de fond s'affiche (`setOpaque(true)`). Le curseur change en main (`HAND_CURSOR`) pour indiquer que c'est cliquable.

---

## Resume oral

> "Le point d'entree de l'application est `GestionSejour.java` qui cree la fenetre principale et y place un `MainGUI`. Le MainGUI est le chef d'orchestre : il organise l'ecran en 3 zones avec un `BorderLayout` — un header en haut, une sidebar a gauche avec 4 boutons de navigation, et une zone centrale qui utilise un `CardLayout`. Le CardLayout permet d'empiler 4 panneaux et de n'en afficher qu'un seul a la fois. Quand on clique sur un bouton, la methode `afficherCarte()` bascule vers le bon panneau, et `styliserBoutonActif()` met le bouton clique en surbrillance."

---

---

# PARTIE 5 — L'interface graphique — Les 4 panneaux

**Fichiers concernes :** `ClientsGUI.java`, `ChambresGUI.java`, `ServicesGUI.java`, `SejoursGUI.java`
**Dossier :** `src/main/java/com/mycompany/gestionsejour/gui/`

---

## L'analogie

Chaque panneau, c'est comme un **guichet specialise** dans l'hotel :
- Le guichet "Clients" permet d'inscrire de nouveaux clients et de voir la liste
- Le guichet "Chambres" permet d'ajouter des chambres et de voir lesquelles existent
- Le guichet "Services" permet de creer de nouveaux services (spa, parking...)
- Le guichet "Sejours" est le guichet principal : il gere les reservations ET les consommations

Tous les guichets fonctionnent pareil : un **formulaire en haut** pour ajouter, un **tableau au centre** pour afficher, et un **bouton rafraichir en bas**.

---

## Ce qui se passe dans le code

### La structure repetee de chaque panneau

Tous les panneaux suivent exactement le meme schema :

```
+--------------------------------------------------+
|  FORMULAIRE (haut - NORTH)                       |
|  "Ajouter un client / chambre / service..."      |
|  [Champ 1] [Champ 2] [Champ 3] [Bouton Ajouter] |
+--------------------------------------------------+
|                                                    |
|  TABLEAU (centre - CENTER)                         |
|  ID | Nom | Prenom | Telephone | Adresse          |
|  1  | Dupont | Jean | 06...    | Paris             |
|  2  | Martin | Luc  | 07...    | Lyon              |
|                                                    |
+--------------------------------------------------+
|  [Rafraichir la liste] (bas - SOUTH)              |
+--------------------------------------------------+
```

Et le constructeur de chaque panneau fait toujours les memes 3 etapes :
```java
public ClientsGUI() {
    initComponents();        // 1. Construire les composants visuels
    styleTableHeader();      // 2. Mettre les en-tetes du tableau en bleu
    chargerClients();        // 3. Aller chercher les donnees dans la BDD
}
```

> **Analogie :** C'est comme un employe qui arrive le matin : il installe son guichet (initComponents), met une jolie nappe (styleTableHeader), puis va chercher les dossiers du jour (chargerClients).

---

### Le flux complet : de la saisie a la base de donnees

Prenons l'exemple de l'ajout d'un client. Quand l'utilisateur remplit le formulaire et clique "Ajouter le client" :

```java
private void btnAjouterClientActionPerformed(java.awt.event.ActionEvent evt) {
    // Etape 1 : On recupere ce que l'utilisateur a tape
    String nom     = fieldNom.getText().trim();
    String prenom  = fieldPrenom.getText().trim();
    String tel     = fieldTel.getText().trim();
    String adresse = fieldAdresse.getText().trim();

    // Etape 2 : On verifie que les champs obligatoires ne sont pas vides
    if (nom.isEmpty() || prenom.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Le nom et le prenom sont obligatoires.",
            "Champs manquants", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;   // On arrete la, on ne va pas plus loin
    }

    // Etape 3 : On cree un objet Client (une "fiche" remplie)
    Client client = new Client(nom, prenom, tel, adresse);

    // Etape 4 : On demande au secretaire (DAO) de l'ajouter en BDD
    RequetesSQL.ajouterClient(client);

    // Etape 5 : On vide le formulaire pour la prochaine saisie
    viderFormulaire();

    // Etape 6 : On recharge le tableau pour voir le nouveau client
    chargerClients();
}
```

> **Le flux en image :**
> ```
> Utilisateur tape "Dupont" "Jean"
>         |
>         v
> [Clic sur "Ajouter"]
>         |
>         v
> Validation (nom et prenom pas vides ?)  -- si vide --> message d'erreur
>         |
>         v (OK)
> Creation d'un objet Client("Dupont", "Jean", ...)
>         |
>         v
> RequetesSQL.ajouterClient(client)  --> INSERT INTO client ... --> Supabase
>         |
>         v
> viderFormulaire()  --> les champs redeviennent vides
>         |
>         v
> chargerClients()   --> SELECT * FROM client --> remplit le tableau avec les nouvelles donnees
> ```

---

### Le chargement du tableau (`chargerClients`)

```java
private void chargerClients() {
    // On recupere le modele du tableau (la structure qui contient les donnees)
    DefaultTableModel model = (DefaultTableModel) tableClients.getModel();

    // On vide le tableau (sinon on aurait des doublons a chaque rechargement)
    model.setRowCount(0);

    // On demande au DAO la liste de tous les clients
    List<Client> clients = RequetesSQL.listerClients();

    // Pour chaque client, on ajoute une ligne au tableau
    for (Client c : clients) {
        model.addRow(new Object[]{
            c.getIdClient(),       // Colonne 1 : ID
            c.getNomClient(),      // Colonne 2 : Nom
            c.getPrenomClient(),   // Colonne 3 : Prenom
            c.getTelClient(),      // Colonne 4 : Telephone
            c.getAdresseClient()   // Colonne 5 : Adresse
        });
    }
}
```

> Le tableau est un `JTable` avec un `DefaultTableModel`. C'est comme un tableur Excel : le `DefaultTableModel` contient les donnees (les lignes et colonnes), et le `JTable` les affiche.

---

### Les specificites de chaque panneau

**ClientsGUI** — Le plus simple
- 4 champs texte : Nom, Prenom, Telephone, Adresse
- Validation : nom et prenom obligatoires
- Tableau : ID | Nom | Prenom | Telephone | Adresse

**ChambresGUI** — Avec des listes deroulantes
- 2 champs texte (numero, prix) + 2 **ComboBox** (type et etat)
- Les ComboBox proposent des choix fixes : `["Simple", "Double", "Suite"]` et `["Disponible", "Occupee", "En nettoyage"]`
- Validation numerique : le numero doit etre un `int`, le prix un `double`
```java
int num = Integer.parseInt(numStr);       // Convertit "101" en 101
double prix = Double.parseDouble(prixStr); // Convertit "85.50" en 85.50
```
Si l'utilisateur tape du texte au lieu d'un nombre, on attrape l'erreur :
```java
catch (NumberFormatException ex) {
    javax.swing.JOptionPane.showMessageDialog(this,
        "Le numero doit etre un entier et le prix un nombre decimal.",
        "Format invalide", javax.swing.JOptionPane.ERROR_MESSAGE);
}
```

**ServicesGUI** — Simple aussi
- 3 champs : Nom du service, Categorie, Prix unitaire
- Validation : tout obligatoire + prix numerique
- Tableau : ID | Nom | Categorie | Prix unitaire

**SejoursGUI** — Le plus complexe (2 formulaires !)
C'est le seul panneau qui a **deux formulaires** empiles :

```
+--------------------------------------------------+
|  Formulaire 1 : "Ajouter un sejour"              |
|  ID Client | N* Chambre | Arrivee | Depart |     |
|  Nb personnes | Statut paiement | [Ajouter]       |
+--------------------------------------------------+
|  Formulaire 2 : "Ajouter une consommation"        |
|  ID Sejour | ID Service | Quantite | Date |       |
|  [Ajouter la consommation]                         |
+--------------------------------------------------+
|  TABLEAU des sejours                               |
+--------------------------------------------------+
```

Pour le sejour, on ne selectionne pas un client dans une liste : on **tape son ID** directement. Ensuite le code cree des "objets fantomes" :
```java
// On cree un Client avec juste l'ID, le reste est vide
Client client = new Client(idClient, "", "", "", "");
Chambre chambre = new Chambre(numChambre, "", 0, "");

// On les met dans le Sejour, et la requete SQL n'utilise que les IDs
Sejour sejour = new Sejour(arrivee, depart, nbPersonnes, statut, client, chambre);
RequetesSQL.ajouterSejour(sejour);
```

> **Pourquoi des objets fantomes ?** Parce que la requete SQL `INSERT INTO sejour ... VALUES (?, ?, ?, ?, ?, ?)` n'a besoin que de l'ID du client et du numero de chambre, pas de toutes leurs infos. Donc on cree des objets "coquilles vides" avec juste l'ID a l'interieur.

---

### Les elements visuels communs

Tous les panneaux partagent le meme style :
- **Fond gris clair** : `new Color(241, 245, 249)` — couleur Tailwind `slate-100`
- **En-tetes tableau bleu clair** : `new Color(191, 219, 254)` — couleur `blue-200`
- **Boutons bleu** : `new Color(37, 99, 235)` — couleur `blue-600`
- **Selection tableau** : bleu vif sur fond blanc
- **Hauteur des lignes** : 28px pour une bonne lisibilite
- **Tableau non-editable** : `isCellEditable() { return false; }` — on ne peut pas modifier directement dans le tableau

---

## Resume oral

> "L'application a 4 panneaux, un par entite principale. Ils suivent tous le meme schema : un formulaire de saisie en haut, un tableau de donnees au centre, et un bouton rafraichir en bas. Quand on clique sur 'Ajouter', le code recupere les valeurs saisies, les valide, cree un objet modele, l'envoie a `RequetesSQL` qui l'insere en base, puis recharge le tableau. Le panneau Sejours est le plus complexe avec deux formulaires — un pour les sejours et un pour les consommations. Les panneaux Chambres et Services utilisent des menus deroulants (`ComboBox`) pour les champs a choix fixes. Tout le design est coherent : memes couleurs, meme structure, meme logique."

---

---

# Bonus — Les design patterns du projet

Pour ceux qui veulent briller a l'oral, voici les concepts techniques utilises :

| Pattern | Ou | Explication simple |
|---------|----|--------------------|
| **Architecture 3 couches** | Tout le projet | Presentation (GUI) → Acces donnees (DAO) → Base de donnees. Chaque couche a son role. |
| **DAO (Data Access Object)** | `RequetesSQL.java` | Un seul fichier centralise toutes les requetes SQL. Les panneaux ne font jamais de SQL directement. |
| **DTO (Data Transfer Object)** | Dossier `modeles/` | Les classes modeles servent a transporter les donnees entre les couches. |
| **CardLayout** | `MainGUI.java` | Systeme de cartes pour naviguer entre les panneaux sans ouvrir de nouvelles fenetres. |
| **Singleton statique** | `ConnexionBDD`, `RequetesSQL` | Toutes les methodes sont `static` : on les appelle directement, pas besoin de creer un objet. |

---

# Bonus — Les limites et ameliorations possibles

A mentionner si un prof pose la question "Qu'est-ce que vous amelioreriez ?" :

1. **Pas de modification ni suppression** — On ne peut qu'ajouter et lister. Ajouter des UPDATE et DELETE serait la priorite.
2. **Pas d'affichage des consommations** — On peut les enregistrer mais pas les voir.
3. **Les objets fantomes dans `listerSejours()`** — Idealement, on ferait un `JOIN` SQL pour afficher le nom du client et le type de chambre au lieu de juste l'ID.
4. **Pas de validation des dates** — On pourrait verifier que la date d'arrivee est avant la date de depart.
5. **Connexion sans pool** — Chaque requete ouvre et ferme une connexion. Un pool de connexions serait plus performant.
6. **Credentials en dur dans le code** — En production, on utiliserait des variables d'environnement.
