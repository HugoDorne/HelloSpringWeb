package com.github.hugodorne.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "utilisateurs")
public class UtilisateursEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;

	@Basic
	@Column(name = "date_inscription", nullable = false)
	private Instant dateInscription;

	@Basic
	@Column(name = "admin", nullable = false)
	private boolean admin;

	@Basic
	@Column(name = "personne_id", nullable = false)
	private int personneId;

	@ManyToOne
	@JoinColumn(name = "personne_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private PersonneEntity personneByPersonneId;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instant getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Instant dateInscription) {
		this.dateInscription = dateInscription;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getPersonneId() {
		return personneId;
	}

	public void setPersonneId(int personneId) {
		this.personneId = personneId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UtilisateursEntity that = (UtilisateursEntity) o;

		if (id != that.id) return false;
		if (admin != that.admin) return false;
		if (personneId != that.personneId) return false;
		return Objects.equals(dateInscription, that.dateInscription);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (dateInscription != null ? dateInscription.hashCode() : 0);
		result = 31 * result + (admin ? 1 : 0);
		result = 31 * result + personneId;
		return result;
	}

	public PersonneEntity getPersonneByPersonneId() {
		return personneByPersonneId;
	}

	public void setPersonneByPersonneId(PersonneEntity personneByPersonneId) {
		this.personneByPersonneId = personneByPersonneId;
	}
}
