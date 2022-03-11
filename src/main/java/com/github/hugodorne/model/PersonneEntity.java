package com.github.hugodorne.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "personne", schema = "public", catalog = "ddft0v81e8ep51")
public class PersonneEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Basic
	@Column(name = "nom", nullable = true, length = -1)
	private String nom;
	@Basic
	@Column(name = "prenom", nullable = true, length = -1)
	private String prenom;
	@Basic
	@Column(name = "sexe", nullable = true)
	private Boolean sexe;
	@Basic
	@Column(name = "date_anniversaire", nullable = true)
	private Date dateAnniversaire;
	@Basic
	@Column(name = "email", nullable = true, length = -1)
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

	public Boolean getSexe() {
		return sexe;
	}

	public void setSexe(Boolean sexe) {
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
		if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
		if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
		if (sexe != null ? !sexe.equals(that.sexe) : that.sexe != null) return false;
		if (dateAnniversaire != null ? !dateAnniversaire.equals(that.dateAnniversaire) : that.dateAnniversaire != null)
			return false;
		if (email != null ? !email.equals(that.email) : that.email != null) return false;

		return true;
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
