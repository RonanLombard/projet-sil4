-- -----------------------------------------------------------------------
-- mysql SQL script for schema sil4
-- -----------------------------------------------------------------------


ALTER TABLE etudiant
    DROP FOREIGN KEY etudiant_FK_1;


ALTER TABLE professeur
    DROP FOREIGN KEY professeur_FK_1;


ALTER TABLE matiere_classe
    DROP FOREIGN KEY matiere_classe_FK_1;


ALTER TABLE matiere_classe
    DROP FOREIGN KEY matiere_classe_FK_2;


ALTER TABLE note
    DROP FOREIGN KEY note_FK_1;


ALTER TABLE note
    DROP FOREIGN KEY note_FK_2;


ALTER TABLE absence
    DROP FOREIGN KEY absence_FK_1;


drop table if exists etudiant;
drop table if exists professeur;
drop table if exists matiere;
drop table if exists classe;
drop table if exists matiere_classe;
drop table if exists note;
drop table if exists absence;



# -----------------------------------------------------------------------
# etudiant
# -----------------------------------------------------------------------
CREATE TABLE etudiant
(
    etudiant_id INTEGER NOT NULL AUTO_INCREMENT,
    nom VARCHAR(128) NOT NULL,
    prenom VARCHAR(128) NOT NULL,
    login VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    classe_id INTEGER NOT NULL,
    PRIMARY KEY(etudiant_id)
);


# -----------------------------------------------------------------------
# professeur
# -----------------------------------------------------------------------
CREATE TABLE professeur
(
    professeur_id INTEGER NOT NULL AUTO_INCREMENT,
    nom VARCHAR(128) NOT NULL,
    prenom VARCHAR(128) NOT NULL,
    login VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    matiere_id INTEGER NOT NULL,
    PRIMARY KEY(professeur_id)
);


# -----------------------------------------------------------------------
# matiere
# -----------------------------------------------------------------------
CREATE TABLE matiere
(
    matiere_id INTEGER NOT NULL AUTO_INCREMENT,
    nom VARCHAR(128) NOT NULL,
    PRIMARY KEY(matiere_id)
);


# -----------------------------------------------------------------------
# classe
# -----------------------------------------------------------------------
CREATE TABLE classe
(
    classe_id INTEGER NOT NULL AUTO_INCREMENT,
    nom VARCHAR(128) NOT NULL,
    PRIMARY KEY(classe_id)
);


# -----------------------------------------------------------------------
# matiere_classe
# -----------------------------------------------------------------------
CREATE TABLE matiere_classe
(
    matiere_classe_id INTEGER NOT NULL AUTO_INCREMENT,
    classe_id INTEGER NOT NULL,
    matiere_id INTEGER NOT NULL,
    PRIMARY KEY(matiere_classe_id)
);


# -----------------------------------------------------------------------
# note
# -----------------------------------------------------------------------
CREATE TABLE note
(
    note_id INTEGER NOT NULL AUTO_INCREMENT,
    etudiant_id INTEGER NOT NULL,
    matiere_id INTEGER NOT NULL,
    valeur INTEGER NOT NULL,
    PRIMARY KEY(note_id)
);


# -----------------------------------------------------------------------
# absence
# -----------------------------------------------------------------------
CREATE TABLE absence
(
    absence_id INTEGER NOT NULL AUTO_INCREMENT,
    etudiant_id INTEGER NOT NULL,
    date DATE NOT NULL,
    justifie CHAR NOT NULL,
    PRIMARY KEY(absence_id)
);


ALTER TABLE etudiant
    ADD CONSTRAINT etudiant_FK_1
    FOREIGN KEY (classe_id)
    REFERENCES classe (classe_id);

ALTER TABLE professeur
    ADD CONSTRAINT professeur_FK_1
    FOREIGN KEY (matiere_id)
    REFERENCES matiere (matiere_id);

ALTER TABLE matiere_classe
    ADD CONSTRAINT matiere_classe_FK_1
    FOREIGN KEY (matiere_id)
    REFERENCES matiere (matiere_id);

ALTER TABLE matiere_classe
    ADD CONSTRAINT matiere_classe_FK_2
    FOREIGN KEY (classe_id)
    REFERENCES classe (classe_id);

ALTER TABLE note
    ADD CONSTRAINT note_FK_1
    FOREIGN KEY (etudiant_id)
    REFERENCES etudiant (etudiant_id);

ALTER TABLE note
    ADD CONSTRAINT note_FK_2
    FOREIGN KEY (matiere_id)
    REFERENCES matiere (matiere_id);

ALTER TABLE absence
    ADD CONSTRAINT absence_FK_1
    FOREIGN KEY (etudiant_id)
    REFERENCES etudiant (etudiant_id);




