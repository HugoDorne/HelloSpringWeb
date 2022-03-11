CREATE TYPE "disponibilite_livre" AS ENUM (
  'dispo',
  'emprunte'
);

CREATE TABLE "utilisateurs" (
  "id" SERIAL PRIMARY KEY,
  "date_inscription" timestamp DEFAULT (now()),
  "admin" boolean DEFAULT false,
  "personne_id" int
);

CREATE TABLE "personne" (
  "id" SERIAL PRIMARY KEY,
  "nom" varchar,
  "prenom" varchar,
  "sexe" boolean,
  "date_anniversaire" date,
  "email" varchar
);

CREATE TABLE "livre" (
  "id" SERIAL PRIMARY KEY,
  "titre" varchar,
  "auteur" int,
  "disponibilite" disponibilite_livre
);

CREATE TABLE "emprunt" (
  "id" SERIAL PRIMARY KEY,
  "personne_id" int,
  "livre_id" int,
  "date_emprunt" timestamp DEFAULT (now()),
  "date_retour" timestamp
);

ALTER TABLE "utilisateurs" ADD FOREIGN KEY ("personne_id") REFERENCES "personne" ("id");

ALTER TABLE "livre" ADD FOREIGN KEY ("auteur") REFERENCES "personne" ("id");

ALTER TABLE "emprunt" ADD FOREIGN KEY ("personne_id") REFERENCES "personne" ("id");

ALTER TABLE "emprunt" ADD FOREIGN KEY ("livre_id") REFERENCES "livre" ("id");
