-- Création de la base de données
CREATE TABLE "person" (
    "person_id" SERIAL PRIMARY KEY,
    "person_firstname" varchar(127) NOT NULL,
    "person_lastname" varchar(127) NOT NULL,
    "person_birthdate" date,
    "person_sexe" varchar(63),
    "person_email" varchar(255));

CREATE TABLE "book" (
    "book_id" SERIAL PRIMARY KEY,
    "book_title" varchar(255) NOT NULL,
    "book_authors" varchar(255) NOT NULL,
    "book_dispo" varchar(63) NOT NULL DEFAULT 'DISPONIBLE');

CREATE TABLE "borrow" (
    "borrow_id" SERIAL PRIMARY KEY,
    "person_id" int NOT NULL,
    "book_id" int NOT NULL,
    "borrow_date" timestamptz NOT NULL DEFAULT (now()),
    "borrow_return" timestamptz);

ALTER TABLE "borrow" ADD FOREIGN KEY ("person_id") REFERENCES "person" ("person_id");

ALTER TABLE "borrow" ADD FOREIGN KEY ("book_id") REFERENCES "book" ("book_id");
