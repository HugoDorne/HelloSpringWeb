-- Création des valeurs de test
INSERT INTO person (person_firstname, person_lastname, person_birthdate, person_sexe, person_email) VALUES
    ('Hugo', 'DORNE', '1999-08-06', 'HOMME', 'hugodorne@gmail.com'),
    ('Mickaël', 'FONTES', '1999-12-22', 'HOMME', 'mickafontes@gmail.com'),
    ('Agathe', 'CHERI', '1999-10-20', 'FEMME', 'agathe.cheri@gmail.com'),
    ('Lilian', 'FONTAN', '1999-07-07', 'HOMME', 'lilfontan@gmail.com'),
    ('Christophe', 'GOMIS', '1999-09-01', 'HOMME', 'chrislebg@gmail.com');

INSERT INTO book (book_title, book_authors, book_dispo) VALUES
    ('La Bible', 'Jésus', 'Indisponible'),
    ('Atomic Habits', 'James Clear', 'Indisponible'),
    ('Les Misérables', 'Victor Hugo', 'Disponible');

INSERT INTO borrow (person_id, book_id, borrow_return) VALUES
    (3,1, null),
    (1,2, null),
    (2,3, now());