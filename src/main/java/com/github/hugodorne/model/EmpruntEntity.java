package com.github.hugodorne.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "emprunt")
public class EmpruntEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personne_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private PersonneEntity personne;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "livre_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private LivreEntity livre;

	@Basic(optional = false)
	@Column(name = "date_emprunt", nullable = false)
	private Instant dateEmprunt;

	@Basic
	@Column(name = "date_retour")
	private Instant dateRetour;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PersonneEntity getPersonne() {
		return personne;
	}

	public void setPersonne(PersonneEntity personneId) {
		this.personne = personneId;
	}

	public LivreEntity getLivre() {
		return livre;
	}

	public void setLivre(LivreEntity livreId) {
		this.livre = livreId;
	}

	public Instant getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Instant dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Instant getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Instant dateRetour) {
		this.dateRetour = dateRetour;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EmpruntEntity that = (EmpruntEntity) o;

		if (id != that.id) return false;
		if (personne != that.personne) return false;
		if (livre != that.livre) return false;
		if (!Objects.equals(dateEmprunt, that.dateEmprunt)) return false;
		return Objects.equals(dateRetour, that.dateRetour);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (dateEmprunt != null ? dateEmprunt.hashCode() : 0);
		result = 31 * result + (dateRetour != null ? dateRetour.hashCode() : 0);
		return result;
	}

}
