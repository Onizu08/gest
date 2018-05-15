DROP DATABASE IF EXISTS FACTURATION;

CREATE DATABASE IF NOT EXISTS FACTURATION;
USE FACTURATION;
# -----------------------------------------------------------------------------
#       TABLE : FACTURE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS FACTURE
 (
   IDFACTURE INTEGER NOT NULL AUTO_INCREMENT ,
   IDFACTURE_ANNULER INTEGER NULL  ,
   IDUTILISATEUR BIGINT(4) NOT NULL  ,
   IDDEVISE INTEGER NOT NULL  ,
   IDCLIENT BIGINT(4) NOT NULL  ,
   REFFACTURE VARCHAR(255) NOT NULL  ,
   DATEFACTURE DATE NOT NULL  ,
   TYPEFACTURE VARCHAR(255) NOT NULL  ,
   MONTANTFACTURE DECIMAL(10,2) NOT NULL  ,
   STATUT VARCHAR(128) NOT NULL  ,
   ECHEANCEPAIEMENT INTEGER NOT NULL  ,
   NBPAIEMENT INTEGER NOT NULL  ,
   FRAISFACTURE DECIMAL(10,2) NULL  ,
   NBJOURVALIDITE INTEGER NULL  ,
   REMISE DECIMAL(10,2) NULL  ,
   TAUXCONVERSION DECIMAL(10,2) NOT NULL  
   , PRIMARY KEY (IDFACTURE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : UTILISATEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS UTILISATEUR
 (
   IDUTILISATEUR BIGINT(4) NOT NULL AUTO_INCREMENT ,
   IDSOCIETE INTEGER NOT NULL  ,
   LOGIN CHAR(32) NOT NULL  ,
   PWD CHAR(32) NOT NULL  ,
   PROFIL CHAR(32) NOT NULL  
   , PRIMARY KEY (IDUTILISATEUR) 
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
#       TABLE : COMMANDE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMMANDE
 (
   IDCOMMANDE BIGINT(4) NOT NULL AUTO_INCREMENT ,
   IDCLIENT BIGINT(4) NOT NULL  ,
   REFERENCECOMMANDE VARCHAR(255) NOT NULL  ,
   DATECOMMANDE DATE NOT NULL  ,
   STATUT VARCHAR(128) NOT NULL  
   , PRIMARY KEY (IDCOMMANDE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : DEVISE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS DEVISE
 (
   IDDEVISE INTEGER NOT NULL AUTO_INCREMENT ,
   LIBELEDEVISE VARCHAR(128) NOT NULL  ,
   TAUXDEVISE DECIMAL(10,2) NOT NULL  
   , PRIMARY KEY (IDDEVISE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : VILLE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS VILLE
 (
   IDVILLE BIGINT(4) NOT NULL AUTO_INCREMENT ,
   IDPAYS VARCHAR(128) NULL  ,
   LIBVILLE VARCHAR(255) NOT NULL  
   , PRIMARY KEY (IDVILLE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SOCIETE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SOCIETE
 (
   IDSOCIETE INTEGER NOT NULL AUTO_INCREMENT ,
   IDVILLE BIGINT(4) NULL  ,
   NOMSOCIETE VARCHAR(128) NOT NULL  ,
   ADRESSESOCIETE VARCHAR(255) NOT NULL  ,
   TELEPHONESOCIETE BIGINT(4) NOT NULL  ,
   FAXSOCIETE BIGINT(4) NULL  ,
   SIRET VARCHAR(128) NOT NULL  ,
   CAPITALSOCIETE BIGINT(4) NULL  ,
   NUMTVASOCIETE BIGINT(4) NULL  ,
   NAF VARCHAR(128) NULL  
   , PRIMARY KEY (IDSOCIETE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
   IDCLIENT BIGINT(4) NOT NULL AUTO_INCREMENT ,
   IDVILLE BIGINT(4) NULL  ,
   IDSOCIETE INTEGER NULL  ,
   NOMCLIENT VARCHAR(255) NOT NULL  ,
   PRENOMCLIENT VARCHAR(128) NOT NULL  ,
   DATENAISSANCECLIENT DATE NULL  ,
   ADRESSECLIENT VARCHAR(128) NULL  ,
   TELEPHONECLIENT VARCHAR(255) NOT NULL  ,
   MAILCLIENT VARCHAR(255) NOT NULL  ,
   TYPECLIENT VARCHAR(255) NOT NULL  ,
   DATEDEBUTCLIENT DATE NULL  ,
   MONTANTAVOIRCLIENT DECIMAL(10,2) NULL  ,
   MONTANTDUCLIENT DECIMAL(10,2) NULL  ,
   TAUXREMISECLIENT DECIMAL(10,2) NULL  
   , PRIMARY KEY (IDCLIENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : REDUCTION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REDUCTION
 (
   IDREDUCTION BIGINT(4) NOT NULL AUTO_INCREMENT ,
   LIBREDUCTION VARCHAR(128) NOT NULL  ,
   APPLIQUE BOOL NULL  ,
   DESCRITPIONREDUCTION VARCHAR(128) NULL  
   , PRIMARY KEY (IDREDUCTION) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CATEGORIE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CATEGORIE
 (
   IDCATEGORIE INTEGER NOT NULL AUTO_INCREMENT ,
   LIBCATEGORIE CHAR(32) NOT NULL  ,
   PROMOCATEGORIE BOOL NULL  ,
   DESCRIPTIONCATEGORIE VARCHAR(128) NULL  
   , PRIMARY KEY (IDCATEGORIE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ACHAT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ACHAT
 (
   IDACHAT INTEGER NOT NULL AUTO_INCREMENT ,
   IDCOMMANDE BIGINT(4) NULL  ,
   IDARTICLE VARCHAR(255) NULL  ,
   IDFACTURE INTEGER NULL  ,
   QUANTITE INTEGER NOT NULL  ,
   MONTANTHT DECIMAL(10,2) NOT NULL  ,
   TVA DECIMAL(10,2) NULL  ,
   REMISE DECIMAL(10,2) NULL  
   , PRIMARY KEY (IDACHAT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ARTICLE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ARTICLE
 (
   IDARTICLE VARCHAR(255) NOT NULL AUTO_INCREMENT ,
   IDCATEGORIE INTEGER NOT NULL  ,
   REFARTICLE VARCHAR(128) NOT NULL  ,
   NOMARTICLE VARCHAR(128) NOT NULL  ,
   PRIXUNIARTICLEHT BIGINT(4) NOT NULL  ,
   PROMOARTICLE BOOL NULL  ,
   DESCRIPTIONARTICLE VARCHAR(128) NULL  
   , PRIMARY KEY (IDARTICLE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PAYER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PAYER
 (
   IDFACTURE INTEGER NOT NULL AUTO_INCREMENT ,
   IDCLIENT BIGINT(4) NOT NULL  ,
   DATEPREVU DATE NOT NULL  ,
   MONTANTPREVU DECIMAL(10,2) NOT NULL  ,
   DATEPAYE DATE NULL  ,
   MONTANTPAYE DECIMAL(10,2) NULL  
   , PRIMARY KEY (IDFACTURE,IDCLIENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : AFFECTER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AFFECTER
 (
   IDARTICLE VARCHAR(255) NOT NULL  ,
   IDREDUCTION BIGINT(4) NOT NULL  
   , PRIMARY KEY (IDARTICLE,IDREDUCTION) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ATTRRIBUER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ATTRRIBUER
 (
   IDCATEGORIE INTEGER NOT NULL  ,
   IDREDUCTION BIGINT(4) NOT NULL  
   , PRIMARY KEY (IDCATEGORIE,IDREDUCTION) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE FACTURE 
  ADD FOREIGN KEY FK_FACTURE_FACTURE (IDFACTURE_ANNULER)
      REFERENCES FACTURE (IDFACTURE) ;


ALTER TABLE FACTURE 
  ADD FOREIGN KEY FK_FACTURE_UTILISATEUR (IDUTILISATEUR)
      REFERENCES UTILISATEUR (IDUTILISATEUR) ;


ALTER TABLE FACTURE 
  ADD FOREIGN KEY FK_FACTURE_DEVISE (IDDEVISE)
      REFERENCES DEVISE (IDDEVISE) ;


ALTER TABLE FACTURE 
  ADD FOREIGN KEY FK_FACTURE_CLIENT (IDCLIENT)
      REFERENCES CLIENT (IDCLIENT) ;


ALTER TABLE UTILISATEUR 
  ADD FOREIGN KEY FK_UTILISATEUR_SOCIETE (IDSOCIETE)
      REFERENCES SOCIETE (IDSOCIETE) ;


ALTER TABLE COMMANDE 
  ADD FOREIGN KEY FK_COMMANDE_CLIENT (IDCLIENT)
      REFERENCES CLIENT (IDCLIENT) ;


ALTER TABLE VILLE 
  ADD FOREIGN KEY FK_VILLE_PAYS (IDPAYS)
      REFERENCES PAYS (IDPAYS) ;


ALTER TABLE SOCIETE 
  ADD FOREIGN KEY FK_SOCIETE_VILLE (IDVILLE)
      REFERENCES VILLE (IDVILLE) ;


ALTER TABLE CLIENT 
  ADD FOREIGN KEY FK_CLIENT_VILLE (IDVILLE)
      REFERENCES VILLE (IDVILLE) ;


ALTER TABLE CLIENT 
  ADD FOREIGN KEY FK_CLIENT_SOCIETE (IDSOCIETE)
      REFERENCES SOCIETE (IDSOCIETE) ;


ALTER TABLE ACHAT 
  ADD FOREIGN KEY FK_ACHAT_COMMANDE (IDCOMMANDE)
      REFERENCES COMMANDE (IDCOMMANDE) ;


ALTER TABLE ACHAT 
  ADD FOREIGN KEY FK_ACHAT_ARTICLE (IDARTICLE)
      REFERENCES ARTICLE (IDARTICLE) ;


ALTER TABLE ACHAT 
  ADD FOREIGN KEY FK_ACHAT_FACTURE (IDFACTURE)
      REFERENCES FACTURE (IDFACTURE) ;


ALTER TABLE ARTICLE 
  ADD FOREIGN KEY FK_ARTICLE_CATEGORIE (IDCATEGORIE)
      REFERENCES CATEGORIE (IDCATEGORIE) ;


ALTER TABLE PAYER 
  ADD FOREIGN KEY FK_PAYER_FACTURE (IDFACTURE)
      REFERENCES FACTURE (IDFACTURE) ;


ALTER TABLE PAYER 
  ADD FOREIGN KEY FK_PAYER_CLIENT (IDCLIENT)
      REFERENCES CLIENT (IDCLIENT) ;


ALTER TABLE AFFECTER 
  ADD FOREIGN KEY FK_AFFECTER_ARTICLE (IDARTICLE)
      REFERENCES ARTICLE (IDARTICLE) ;


ALTER TABLE AFFECTER 
  ADD FOREIGN KEY FK_AFFECTER_REDUCTION (IDREDUCTION)
      REFERENCES REDUCTION (IDREDUCTION) ;


ALTER TABLE ATTRRIBUER 
  ADD FOREIGN KEY FK_ATTRRIBUER_CATEGORIE (IDCATEGORIE)
      REFERENCES CATEGORIE (IDCATEGORIE) ;


ALTER TABLE ATTRRIBUER 
  ADD FOREIGN KEY FK_ATTRRIBUER_REDUCTION (IDREDUCTION)
      REFERENCES REDUCTION (IDREDUCTION) ;

