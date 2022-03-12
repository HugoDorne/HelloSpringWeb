package com.github.hugodorne.model;

import com.github.hugodorne.enumeration.Sexe;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "personne")
public class PersonneEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;

	@Basic
	@Column(name = "nom", nullable = false)
	private String nom;

	@Basic
	@Column(name = "prenom", nullable = false)
	private String prenom;

	@Basic
	@Column(name = "sexe", nullable = false)
	private Sexe sexe;

	@Basic
	@Column(name = "date_anniversaire")
	private Date dateAnniversaire;

	@Basic
	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "personneByPersonneId")
	private Collection<EmpruntEntity> empruntsById;

	@OneToMany(mappedBy = "personneByAuteur")
	private Collection<LivreEntity> livresById;

	@OneToMany(mappedBy = "personneByPersonneId")
	private Collection<UtilisateursEntity> utilisateursById;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Date getDateAnniversaire() {
		return dateAnniversaire;
	}

	public void setDateAnniversaire(Date dateAnniversaire) {
		this.dateAnniversaire = dateAnniversaire;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PersonneEntity that = (PersonneEntity) o;

		if (id != that.id) return false;
		if (!Objects.equals(nom, that.nom)) return false;
		if (!Objects.equals(prenom, that.prenom)) return false;
		if (!Objects.equals(sexe, that.sexe)) return false;
		if (!Objects.equals(dateAnniversaire, that.dateAnniversaire))
			return false;
		return Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (nom != null ? nom.hashCode() : 0);
		result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
		result = 31 * result + (sexe != null ? sexe.hashCode() : 0);
		result = 31 * result + (dateAnniversaire != null ? dateAnniversaire.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}

	public Collection<EmpruntEntity> getEmpruntsById() {
		return empruntsById;
	}

	public void setEmpruntsById(Collection<EmpruntEntity> empruntsById) {
		this.empruntsById = empruntsById;
	}

	public Collection<LivreEntity> getLivresById() {
		return livresById;
	}

	public void setLivresById(Collection<LivreEntity> livresById) {
		this.livresById = livresById;
	}

	public Collection<UtilisateursEntity> getUtilisateursById() {
		return utilisateursById;
	}

	public void setUtilisateursById(Collection<UtilisateursEntity> utilisateursById) {
		this.utilisateursById = utilisateursById;
	}
}
