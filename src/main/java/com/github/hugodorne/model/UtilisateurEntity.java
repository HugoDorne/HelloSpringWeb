package com.github.hugodorne.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "utilisateur")
public class UtilisateurEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;

	@Basic(optional = false)
	@Column(name = "date_inscription", nullable = false)
	private Instant dateInscription;

	@Basic(optional = false)
	@Column(name = "admin", nullable = false)
	private boolean admin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personne_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private PersonneEntity personneId;


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

	public PersonneEntity getPersonneId() {
		return personneId;
	}

	public void setPersonneId(PersonneEntity personneId) {
		this.personneId = personneId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UtilisateurEntity that = (UtilisateurEntity) o;

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
		return result;
	}

	@Override
	public String toString() {
		return "UtilisateurEntity{" +
				"id=" + id +
				", dateInscription=" + dateInscription +
				", admin=" + admin +
				", personneId=" + personneId +
				'}';
	}
}
