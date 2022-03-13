-- Création des valeurs de test
INSERT INTO personne (nom, prenom, sexe, date_anniversaire, email) VALUES
    ('DORNE', 'Hugo', 'HOMME', '1999-08-06', 'hugodorne@gmail.com'),
    ('FONTES', 'Mickaël', 'HOMME', '1999-12-22', 'mickaelfontes@gmail.com'),
    ('CLEAR', 'James', 'HOMME', null, null),
    ('CHERI', 'Agathe', 'FEMME', null, null);

INSERT INTO utilisateur (date_inscription, admin, personne_id) VALUES
    (default, true, 1),
    (default, false, 2);

INSERT INTO livre (titre, auteur) VALUES
    ('La Bible', 4),
    ('Atomic Habits', 3);

INSERT INTO emprunt (personne_id, livre_id) VALUES
    (1,2),
    (2,1);
