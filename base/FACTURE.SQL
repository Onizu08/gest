DROP DATABASE IF EXISTS Facture;

CREATE DATABASE IF NOT EXISTS Facture;
USE Facture;
# -----------------------------------------------------------------------------
#       TABLE : UTILISATEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS UTILISATEUR
 (
   IDUTILISATEUR BIGINT(4) NOT NULL  ,
   IDSOCIETE INTEGER NOT NULL  ,
   LOGIN CHAR(32) NOT NULL  ,
   PWD CHAR(32) NOT NULL  ,
   PROFIL CHAR(32) NOT NULL  
   , PRIMARY KEY (IDUTILISATEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : FACTURE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS FACTURE
 (
   IDFACTURE INTEGER NOT NULL  ,
   IDFACTURE_ANNULER INTEGER NOT NULL  ,
   IDUTILISATEUR BIGINT(4) NOT NULL  ,
   IDCLIENT BIGINT(4) NOT NULL  ,
   REFFACTURE VARCHAR(255) NOT NULL  ,
   DATEFACTURE DATE NOT NULL  ,
   TYPEFACTURE VARCHAR(255) NOT NULL  ,
   MONTANTFACTURE DECIMAL(10,2) NOT NULL  ,
   STATUT VARCHAR(128) NOT NULL  ,
   ECHEANCEPAIEMENT INTEGER NOT NULL  ,
   NBPAIEMENT INTEGER NOT NULL  ,
   FRAISFACTURE DECIMAL(10,2) NULL  ,
   NBJOURVALIDITE INTEGER NULL  
   , PRIMARY KEY (IDFACTURE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COMMANDE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMMANDE
 (
   IDCOMMANDE BIGINT(4) NOT NULL  ,
   IDCLIENT BIGINT(4) NOT NULL  ,
   REFERENCECOMMANDE VARCHAR(255) NOT NULL  ,
   DATECOMMANDE DATE NOT NULL  ,
   STATUT VARCHAR(128) NOT NULL  
   , PRIMARY KEY (IDCOMMANDE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PAYS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PAYS
 (
   IDPAYS VARCHAR(128) NOT NULL  ,
   LIBPAYS VARCHAR(128) NOT NULL  
   , PRIMARY KEY (IDPAYS) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COMPTE_CLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMPTE_CLIENT
 (
   IDCLIENT BIGINT(4) NOT NULL  ,
   DATEDEBUTCLIENT DATE NULL  ,
   MONTANTAVOIR DECIMAL(10,2) NULL  ,
   MONTANTDU DECIMAL(10,2) NULL  ,
   TAUXREMISE DECIMAL(10,2) NULL  ,
   NOMCLIENT VARCHAR(255) NOT NULL  ,
   PRENOMCLIENT VARCHAR(128) NOT NULL  ,
   DATENAISSANCECLIENT DATE NULL  ,
   ADRESSECLIENT VARCHAR(128) NULL  ,
   TELEPHONECLIENT VARCHAR(255) NOT NULL  ,
   MAILCLIENT VARCHAR(255) NOT NULL  ,
   TYPECLIENT BOOL NOT NULL  
   , PRIMARY KEY (IDCLIENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SOCIETE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SOCIETE
 (
   IDSOCIETE INTEGER NOT NULL  ,
   IDVILLE BIGINT(4) NOT NULL  ,
   NOMSOCIETE VARCHAR(128) NOT NULL  ,
   ADRESSESOCIETE VARCHAR(255) NOT NULL  ,
   TELEPHONESOCIETE BIGINT(4) NOT NULL  ,
   FAXSOCIETE BIGINT(4) NULL  ,
   SIRET VARCHAR(128) NOT NULL  ,
   CAPITALSOCIETE BIGINT(4) NOT NULL  ,
   NUMTVASOCIETE BIGINT(4) NOT NULL  ,
   NAF VARCHAR(128) NOT NULL  
   , PRIMARY KEY (IDSOCIETE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : VILLE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS VILLE
 (
   IDVILLE BIGINT(4) NOT NULL  ,
   IDPAYS VARCHAR(128) NOT NULL  ,
   LIBVILLE VARCHAR(255) NOT NULL  
   , PRIMARY KEY (IDVILLE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
   IDCLIENT BIGINT(4) NOT NULL  ,
   IDVILLE BIGINT(4) NOT NULL  ,
   IDSOCIETE INTEGER NULL  ,
   NOMCLIENT VARCHAR(255) NOT NULL  ,
   PRENOMCLIENT VARCHAR(128) NOT NULL  ,
   DATENAISSANCECLIENT DATE NULL  ,
   ADRESSECLIENT VARCHAR(128) NULL  ,
   TELEPHONECLIENT VARCHAR(255) NOT NULL  ,
   MAILCLIENT VARCHAR(255) NOT NULL  ,
   TYPECLIENT BOOL NOT NULL  
   , PRIMARY KEY (IDCLIENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : REDUCTION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REDUCTION
 (
   IDREDUCTION BIGINT(4) NOT NULL  ,
   LIBREDUCTION VARCHAR(128) NOT NULL  ,
   DATEDEBUTREDUCTION DATE NOT NULL  ,
   TAUXREDUCTION DECIMAL(10,2) NOT NULL  ,
   DATEFINREDUCTION DATE NOT NULL  ,
   APPLIQUE BOOL NOT NULL  ,
   DESCRITPIONREDUCTION VARCHAR(128) NULL  
   , PRIMARY KEY (IDREDUCTION) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CATEGORIE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CATEGORIE
 (
   IDCATEGORIE INTEGER NOT NULL  ,
   LIBCATEGORIE CHAR(32) NOT NULL  ,
   PROMOCATEGORIE BOOL NOT NULL  ,
   DESCRIPTIONCATEGORIE VARCHAR(128) NULL  
   , PRIMARY KEY (IDCATEGORIE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ARTICLE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ARTICLE
 (
   IDARTICLE VARCHAR(255) NOT NULL  ,
   IDCATEGORIE INTEGER NOT NULL  ,
   REFARTICLE VARCHAR(128) NOT NULL  ,
   NOMARTICLE VARCHAR(128) NOT NULL  ,
   PRIXUNIARTICLEHT BIGINT(4) NOT NULL  ,
   PROMOARTICLE BOOL NOT NULL  ,
   DESCRIPTIONARTICLE VARCHAR(128) NULL  
   , PRIMARY KEY (IDARTICLE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PAYER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PAYER
 (
   IDCLIENT BIGINT(4) NOT NULL  ,
   IDFACTURE INTEGER NOT NULL  ,
   DATEPREVU DATE NOT NULL  ,
   MONTANTPREVU DECIMAL(10,2) NOT NULL  ,
   DATEPAYE DATE NULL  ,
   MONTANTPAYE DECIMAL(10,2) NULL  
   , PRIMARY KEY (IDCLIENT,IDFACTURE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COMPRENDRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMPRENDRE
 (
   IDARTICLE VARCHAR(255) NOT NULL  ,
   IDCOMMANDE BIGINT(4) NOT NULL  ,
   IDFACTURE INTEGER NOT NULL  ,
   QUANTITE INTEGER NOT NULL  ,
   MONTANTHT DECIMAL(10,2) NOT NULL  ,
   TVA DECIMAL(10,2) NOT NULL  ,
   REMISE DECIMAL(10,2) NULL  
   , PRIMARY KEY (IDARTICLE,IDCOMMANDE,IDFACTURE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : AFFECTER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AFFECTER
 (
   IDCATEGORIE INTEGER NOT NULL  ,
   IDREDUCTION BIGINT(4) NOT NULL  ,
   IDARTICLE VARCHAR(255) NOT NULL  
   , PRIMARY KEY (IDCATEGORIE,IDREDUCTION,IDARTICLE) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE UTILISATEUR 
  ADD FOREIGN KEY FK_UTILISATEUR_SOCIETE (IDSOCIETE)
      REFERENCES SOCIETE (IDSOCIETE) ;


ALTER TABLE FACTURE 
  ADD FOREIGN KEY FK_FACTURE_FACTURE (IDFACTURE_ANNULER)
      REFERENCES FACTURE (IDFACTURE) ;


ALTER TABLE FACTURE 
  ADD FOREIGN KEY FK_FACTURE_UTILISATEUR (IDUTILISATEUR)
      REFERENCES UTILISATEUR (IDUTILISATEUR) ;


ALTER TABLE FACTURE 
  ADD FOREIGN KEY FK_FACTURE_COMPTE_CLIENT (IDCLIENT)
      REFERENCES COMPTE_CLIENT (IDCLIENT) ;


ALTER TABLE COMMANDE 
  ADD FOREIGN KEY FK_COMMANDE_COMPTE_CLIENT (IDCLIENT)
      REFERENCES COMPTE_CLIENT (IDCLIENT) ;


ALTER TABLE COMPTE_CLIENT 
  ADD FOREIGN KEY FK_COMPTE_CLIENT_CLIENT (IDCLIENT)
      REFERENCES CLIENT (IDCLIENT) ;


ALTER TABLE SOCIETE 
  ADD FOREIGN KEY FK_SOCIETE_VILLE (IDVILLE)
      REFERENCES VILLE (IDVILLE) ;


ALTER TABLE VILLE 
  ADD FOREIGN KEY FK_VILLE_PAYS (IDPAYS)
      REFERENCES PAYS (IDPAYS) ;


ALTER TABLE CLIENT 
  ADD FOREIGN KEY FK_CLIENT_VILLE (IDVILLE)
      REFERENCES VILLE (IDVILLE) ;


ALTER TABLE CLIENT 
  ADD FOREIGN KEY FK_CLIENT_SOCIETE (IDSOCIETE)
      REFERENCES SOCIETE (IDSOCIETE) ;


ALTER TABLE ARTICLE 
  ADD FOREIGN KEY FK_ARTICLE_CATEGORIE (IDCATEGORIE)
      REFERENCES CATEGORIE (IDCATEGORIE) ;


ALTER TABLE PAYER 
  ADD FOREIGN KEY FK_PAYER_COMPTE_CLIENT (IDCLIENT)
      REFERENCES COMPTE_CLIENT (IDCLIENT) ;


ALTER TABLE PAYER 
  ADD FOREIGN KEY FK_PAYER_FACTURE (IDFACTURE)
      REFERENCES FACTURE (IDFACTURE) ;


ALTER TABLE COMPRENDRE 
  ADD FOREIGN KEY FK_COMPRENDRE_ARTICLE (IDARTICLE)
      REFERENCES ARTICLE (IDARTICLE) ;


ALTER TABLE COMPRENDRE 
  ADD FOREIGN KEY FK_COMPRENDRE_COMMANDE (IDCOMMANDE)
      REFERENCES COMMANDE (IDCOMMANDE) ;


ALTER TABLE COMPRENDRE 
  ADD FOREIGN KEY FK_COMPRENDRE_FACTURE (IDFACTURE)
      REFERENCES FACTURE (IDFACTURE) ;


ALTER TABLE AFFECTER 
  ADD FOREIGN KEY FK_AFFECTER_CATEGORIE (IDCATEGORIE)
      REFERENCES CATEGORIE (IDCATEGORIE) ;


ALTER TABLE AFFECTER 
  ADD FOREIGN KEY FK_AFFECTER_REDUCTION (IDREDUCTION)
      REFERENCES REDUCTION (IDREDUCTION) ;


ALTER TABLE AFFECTER 
  ADD FOREIGN KEY FK_AFFECTER_ARTICLE (IDARTICLE)
      REFERENCES ARTICLE (IDARTICLE) ;

