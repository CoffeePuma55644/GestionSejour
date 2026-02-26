# Monographie — GestionSejour Hotel

**Application de Gestion de Sejour Hotelier**

---

## 1. Guide d'Utilisation

### 1.1 Presentation generale

GestionSejour est une application de bureau developpee en Java permettant de gerer les operations courantes d'un etablissement hotelier. L'application offre une interface graphique intuitive organisee autour de quatre modules accessibles depuis une barre de navigation laterale.

### 1.2 Fonctionnalites cles

**Module Clients**
L'utilisateur peut enregistrer de nouveaux clients en saisissant leur nom, prenom, numero de telephone et adresse. La liste complete des clients enregistres s'affiche dans un tableau central, actualisable a tout moment via le bouton "Rafraichir la liste". Les champs nom et prenom sont obligatoires ; l'application affiche un message d'alerte en cas d'oubli.

**Module Chambres**
Ce module permet d'enregistrer les chambres de l'etablissement en renseignant le numero de chambre, le type (Simple, Double ou Suite), le prix par nuit et l'etat (Disponible, Occupee ou En nettoyage). Le type et l'etat sont selectionnes via des menus deroulants, ce qui evite les erreurs de saisie. Le tableau central affiche l'ensemble des chambres avec leurs caracteristiques.

**Module Services**
L'hotelier y repertorie les services supplementaires proposes aux clients : spa, petit-dejeuner, parking, blanchisserie, etc. Chaque service est defini par un nom, une categorie et un prix unitaire. Le tableau recapitulatif permet de visualiser l'ensemble de l'offre de services.

**Module Sejours et Consommations**
C'est le module le plus complet. Il comporte deux formulaires :
- **Formulaire Sejour :** permet de creer une reservation en associant un client (via son identifiant) a une chambre (via son numero), avec les dates d'arrivee et de depart, le nombre de personnes et le statut de paiement (En attente, Paye ou Annule).
- **Formulaire Consommation :** permet d'enregistrer les services consommes par un client pendant son sejour (par exemple : 2 petits-dejeuners le 15 mars). On renseigne l'identifiant du sejour, l'identifiant du service, la quantite et la date.

Le tableau central affiche la liste de tous les sejours enregistres.

### 1.3 Navigation

L'application s'ouvre sur une fenetre unique de 1200x750 pixels. La barre laterale gauche (sidebar) affiche quatre boutons : Clients, Chambres, Sejours et Services. Un clic sur l'un de ces boutons affiche instantanement le module correspondant dans la zone centrale, sans ouvrir de nouvelle fenetre. Le bouton actif est mis en surbrillance pour indiquer la section en cours.

### 1.4 Prerequis techniques

- Java 23 (JDK) installe sur la machine
- Connexion Internet active (la base de donnees est hebergee dans le cloud via Supabase)
- Aucune installation de base de donnees locale requise

---

## 2. Strategie Commerciale

### 2.1 Proposition de Valeur

#### Le probleme

En Republique Democratique du Congo, la grande majorite des etablissements hoteliers — notamment les hotels de petite et moyenne taille, les maisons d'hotes et les auberges — gerent encore leurs operations de maniere manuelle : cahiers de reception, fiches clients papier, suivi des chambres au tableau blanc, calculs de factures a la main. Cette situation entraine plusieurs problemes concrets :

- **Perte de donnees :** Les cahiers peuvent etre egares, endommages ou mal remplis. Il n'existe aucune sauvegarde en cas de sinistre (incendie, inondation, vol).
- **Erreurs de facturation :** Le calcul manuel des nuits, des services consommes et des montants totaux est source d'erreurs frequentes qui coutent de l'argent a l'etablissement ou creent des litiges avec les clients.
- **Aucune visibilite en temps reel :** Le gerant ne peut pas savoir instantanement quelles chambres sont disponibles, combien de clients sont en cours de sejour ou quel est le chiffre d'affaires du mois sans compulser manuellement les registres.
- **Lenteur du service :** L'enregistrement d'un nouveau client ou d'une reservation prend du temps lorsqu'il faut chercher un stylo, verifier dans le cahier, recopier les informations.

#### La solution

GestionSejour numerise l'ensemble de ces operations dans une application simple et accessible :

- **Enregistrement rapide :** Un client est enregistre en quelques secondes via un formulaire clair. Fini les fiches papier.
- **Suivi des chambres :** L'etat de chaque chambre (disponible, occupee, en nettoyage) est visible d'un coup d'oeil dans un tableau actualise.
- **Gestion des sejours :** La creation d'une reservation associe automatiquement un client a une chambre avec les dates et le statut de paiement. Plus de risque de double reservation manuelle.
- **Traçabilite des consommations :** Chaque service consomme par un client est enregistre avec sa quantite et sa date. La facturation devient fiable.
- **Donnees dans le cloud :** Grace a Supabase, les donnees sont stockees en ligne de maniere securisee (chiffrement SSL). Elles sont accessibles depuis n'importe quel poste connecte a Internet et ne risquent pas d'etre perdues en cas de probleme avec l'ordinateur local.

**En resume :** GestionSejour remplace le cahier, la calculatrice et le tableau blanc par une solution numerique fiable, rapide et securisee.

### 2.2 Segmentation Client

Notre produit cible trois segments d'etablissements en RDC :

**Segment principal : Hotels de petite et moyenne taille (10 a 50 chambres)**
Ce sont les hotels familiaux, les maisons d'hotes et les auberges que l'on retrouve dans les grandes villes congolaises (Kinshasa, Lubumbashi, Goma, Bukavu, Kisangani). Ces etablissements :
- Ont un personnel reduit (souvent 2 a 10 employes)
- Ne disposent generalement pas d'un logiciel de gestion
- Gerent entre 5 et 30 clients par jour
- Ont un budget informatique limite
- Disposent generalement d'au moins un ordinateur a la reception

C'est notre cible ideale car l'application est assez simple pour etre utilisee sans formation poussee, tout en apportant une valeur immediate par rapport a la gestion papier.

**Segment secondaire : Residences meublees et apart-hotels**
Les residences meublees en pleine expansion a Kinshasa et Lubumbashi accueillent des clients pour des sejours de moyenne et longue duree. La gestion des dates d'arrivee/depart et du suivi des paiements est critique pour eux.

**Segment tertiaire : Centres d'hebergement et foyers**
Les centres d'accueil, foyers de travailleurs et hebergements temporaires geres par des ONG ou des organisations religieuses. Ils ont besoin d'un outil de suivi des occupants simple et peu couteux.

### 2.3 Modele de Revenus

#### Strategie de tarification

Nous proposons un **modele hybride** : licence unique + abonnement de maintenance optionnel.

| Offre | Contenu | Prix |
|-------|---------|------|
| **Licence Standard** | Application complete + installation + formation initiale (1 journee) | **250 USD** (paiement unique) |
| **Maintenance & Support** | Mises a jour, assistance technique par telephone/WhatsApp, corrections de bugs | **25 USD / mois** (optionnel) |
| **Installation supplementaire** | Deploiement sur un poste additionnel | **50 USD** par poste |

#### Justification du prix par rapport au marche local

**Contexte economique en RDC :**
- Le revenu moyen d'un petit hotel a Kinshasa se situe entre 2 000 et 10 000 USD par mois selon la taille et le taux d'occupation.
- Les solutions internationales de gestion hoteliere (Opera PMS, Hotelogix, Cloudbeds) coutent entre 50 et 300 USD par mois en abonnement, soit 600 a 3 600 USD par an — un montant prohibitif pour la plupart des petits etablissements congolais.
- La connexion Internet, bien qu'en amelioration, reste un facteur a considerer. Notre application necessite une connexion uniquement pour les operations de lecture/ecriture en base, pas de streaming ou de donnees lourdes.

**Pourquoi 250 USD est un prix juste :**
1. **Accessibilite :** 250 USD represente l'equivalent d'environ 1 a 3 nuits dans un hotel de gamme moyenne a Kinshasa. L'investissement est recupere des le premier mois d'utilisation grace au gain de temps et a la reduction des erreurs de facturation.
2. **Competitivite :** Face aux logiciels internationaux a 100+ USD/mois, notre licence unique a 250 USD est 5 a 10 fois moins chere sur un an.
3. **Pas d'engagement mensuel obligatoire :** Le modele de licence unique rassure les gerants qui ne souhaitent pas s'engager dans un abonnement recurrent. La maintenance a 25 USD/mois est optionnelle.
4. **Pas de frais d'infrastructure :** Aucune installation de serveur local n'est requise. La base de donnees est hebergee dans le cloud (Supabase), ce qui elimine le cout d'un serveur dedie.
5. **Adapte au pouvoir d'achat local :** Le prix a ete calibre pour etre accessible meme aux petits etablissements tout en restant viable economiquement pour notre equipe de developpement.

#### Projection de revenus (premiere annee)

| Hypothese | Valeur |
|-----------|--------|
| Nombre de clients vises (an 1) | 20 etablissements |
| Revenu licences | 20 x 250 = **5 000 USD** |
| Taux d'adoption maintenance | 50% (10 clients) |
| Revenu maintenance annuel | 10 x 25 x 12 = **3 000 USD** |
| **Revenu total estime (an 1)** | **8 000 USD** |

Ce modele est evolutif : a mesure que des fonctionnalites avancees sont ajoutees (facturation automatique, statistiques, gestion du personnel), le prix de la licence et de la maintenance peuvent etre revus a la hausse pour les nouvelles versions, tout en conservant les anciens clients sur leur version acquise.

---

*Document redige dans le cadre du projet academique GestionSejour — Gestion de Sejour Hotelier.*
*Technologie : Java 23 / Swing / PostgreSQL (Supabase) / JDBC / Maven.*
