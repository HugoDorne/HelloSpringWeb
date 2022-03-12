-- Création de la base de données
CREATE TYPE "disponibilite_livre" AS ENUM (
    'DISPONIBLE',
    'INDISPONIBLE'
    );

CREATE TYPE "sexe" AS ENUM (
    'HOMME',
    'FEMME'
    );

CREATE TABLE "personne" (
    "id" SERIAL PRIMARY KEY,
    "nom" varchar(255) NOT NULL,
    "prenom" varchar(255) NOT NULL,
    "sexe" sexe NOT NULL,
    "date_anniversaire" date,
    "email" varchar(255)
);

CREATE TABLE "utilisateurs" (
    "id" SERIAL PRIMARY KEY,
    "date_inscription" timestamptz NOT NULL DEFAULT (now()),
    "admin" boolean NOT NULL DEFAULT false,
    "personne_id" int NOT NULL
);

CREATE TABLE "livre" (
    "id" SERIAL PRIMARY KEY,
    "titre" varchar(255) NOT NULL,
    "auteur" int NOT NULL,
    "disponibilite" disponibilite_livre NOT NULL DEFAULT 'DISPONIBLE'
);

CREATE TABLE "emprunt" (
    "id" SERIAL PRIMARY KEY,
    "personne_id" int NOT NULL,
    "livre_id" int NOT NULL,
    "date_emprunt" timestamptz NOT NULL DEFAULT (now()),
    "date_retour" timestamptz
);

ALTER TABLE "utilisateurs" ADD FOREIGN KEY ("personne_id") REFERENCES "personne" ("id");

ALTER TABLE "livre" ADD FOREIGN KEY ("auteur") REFERENCES "personne" ("id");

ALTER TABLE "emprunt" ADD FOREIGN KEY ("personne_id") REFERENCES "personne" ("id");

ALTER TABLE "emprunt" ADD FOREIGN KEY ("livre_id") REFERENCES "livre" ("id");
