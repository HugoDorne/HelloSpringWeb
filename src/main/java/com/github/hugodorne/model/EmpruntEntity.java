package com.github.hugodorne.model;

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

	@Basic
	@Column(name = "personne_id", nullable = false)
	private int personneId;

	@Basic
	@Column(name = "livre_id", nullable = false)
	private int livreId;

	@Basic
	@Column(name = "date_emprunt", nullable = false)
	private Instant dateEmprunt;

	@Basic
	@Column(name = "date_retour")
	private Instant dateRetour;

	@ManyToOne
	@JoinColumn(name = "personne_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private PersonneEntity personneByPersonneId;

	@ManyToOne
	@JoinColumn(name = "livre_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private LivreEntity livreByLivreId;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonneId() {
		return personneId;
	}

	public void setPersonneId(int personneId) {
		this.personneId = personneId;
	}

	public int getLivreId() {
		return livreId;
	}

	public void setLivreId(int livreId) {
		this.livreId = livreId;
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
		if (personneId != that.personneId) return false;
		if (livreId != that.livreId) return false;
		if (!Objects.equals(dateEmprunt, that.dateEmprunt)) return false;
		return Objects.equals(dateRetour, that.dateRetour);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + personneId;
		result = 31 * result + livreId;
		result = 31 * result + (dateEmprunt != null ? dateEmprunt.hashCode() : 0);
		result = 31 * result + (dateRetour != null ? dateRetour.hashCode() : 0);
		return result;
	}

	public PersonneEntity getPersonneByPersonneId() {
		return personneByPersonneId;
	}

	public void setPersonneByPersonneId(PersonneEntity personneByPersonneId) {
		this.personneByPersonneId = personneByPersonneId;
	}

	public LivreEntity getLivreByLivreId() {
		return livreByLivreId;
	}

	public void setLivreByLivreId(LivreEntity livreByLivreId) {
		this.livreByLivreId = livreByLivreId;
	}
}
