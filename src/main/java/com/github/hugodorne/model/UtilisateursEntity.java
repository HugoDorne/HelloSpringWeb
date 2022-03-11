package com.github.hugodorne.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "utilisateurs", schema = "public", catalog = "ddft0v81e8ep51")
public class UtilisateursEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Basic
	@Column(name = "date_inscription", nullable = true)
	private Timestamp dateInscription;
	@Basic
	@Column(name = "admin", nullable = true)
	private Boolean admin;
	@Basic
	@Column(name = "personne_id", nullable = true)
	private Integer personneId;
	@ManyToOne
	@JoinColumn(name = "personne_id", referencedColumnName = "id")
	private PersonneEntity personneByPersonneId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Timestamp dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Integer getPersonneId() {
		return personneId;
	}

	public void setPersonneId(Integer personneId) {
		this.personneId = personneId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UtilisateursEntity that = (UtilisateursEntity) o;

		if (id != that.id) return false;
		if (dateInscription != null ? !dateInscription.equals(that.dateInscription) : that.dateInscription != null)
			return false;
		if (admin != null ? !admin.equals(that.admin) : that.admin != null) return false;
		if (personneId != null ? !personneId.equals(that.personneId) : that.personneId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (dateInscription != null ? dateInscription.hashCode() : 0);
		result = 31 * result + (admin != null ? admin.hashCode() : 0);
		result = 31 * result + (personneId != null ? personneId.hashCode() : 0);
		return result;
	}

	public PersonneEntity getPersonneByPersonneId() {
		return personneByPersonneId;
	}

	public void setPersonneByPersonneId(PersonneEntity personneByPersonneId) {
		this.personneByPersonneId = personneByPersonneId;
	}
}
