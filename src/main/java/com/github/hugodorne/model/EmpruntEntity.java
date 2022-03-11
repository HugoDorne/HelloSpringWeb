package com.github.hugodorne.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "emprunt", schema = "public", catalog = "ddft0v81e8ep51")
public class EmpruntEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Basic
	@Column(name = "personne_id", nullable = true)
	private Integer personneId;
	@Basic
	@Column(name = "livre_id", nullable = true)
	private Integer livreId;
	@Basic
	@Column(name = "date_emprunt", nullable = true)
	private Timestamp dateEmprunt;
	@Basic
	@Column(name = "date_retour", nullable = true)
	private Timestamp dateRetour;
	@ManyToOne
	@JoinColumn(name = "personne_id", referencedColumnName = "id")
	private PersonneEntity personneByPersonneId;
	@ManyToOne
	@JoinColumn(name = "livre_id", referencedColumnName = "id")
	private LivreEntity livreByLivreId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPersonneId() {
		return personneId;
	}

	public void setPersonneId(Integer personneId) {
		this.personneId = personneId;
	}

	public Integer getLivreId() {
		return livreId;
	}

	public void setLivreId(Integer livreId) {
		this.livreId = livreId;
	}

	public Timestamp getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Timestamp dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Timestamp getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Timestamp dateRetour) {
		this.dateRetour = dateRetour;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EmpruntEntity that = (EmpruntEntity) o;

		if (id != that.id) return false;
		if (personneId != null ? !personneId.equals(that.personneId) : that.personneId != null) return false;
		if (livreId != null ? !livreId.equals(that.livreId) : that.livreId != null) return false;
		if (dateEmprunt != null ? !dateEmprunt.equals(that.dateEmprunt) : that.dateEmprunt != null) return false;
		if (dateRetour != null ? !dateRetour.equals(that.dateRetour) : that.dateRetour != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (personneId != null ? personneId.hashCode() : 0);
		result = 31 * result + (livreId != null ? livreId.hashCode() : 0);
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
