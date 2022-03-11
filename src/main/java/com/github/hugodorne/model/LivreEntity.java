package com.github.hugodorne.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "livre", schema = "public", catalog = "ddft0v81e8ep51")
public class LivreEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Basic
	@Column(name = "titre", nullable = true, length = -1)
	private String titre;
	@Basic
	@Column(name = "auteur", nullable = true)
	private Integer auteur;
	@Basic
	@Column(name = "disponibilite", nullable = true)
	private Object disponibilite;
	@OneToMany(mappedBy = "livreByLivreId")
	private Collection<EmpruntEntity> empruntsById;
	@ManyToOne
	@JoinColumn(name = "auteur", referencedColumnName = "id")
	private PersonneEntity personneByAuteur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getAuteur() {
		return auteur;
	}

	public void setAuteur(Integer auteur) {
		this.auteur = auteur;
	}

	public Object getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Object disponibilite) {
		this.disponibilite = disponibilite;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LivreEntity that = (LivreEntity) o;

		if (id != that.id) return false;
		if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
		if (auteur != null ? !auteur.equals(that.auteur) : that.auteur != null) return false;
		if (disponibilite != null ? !disponibilite.equals(that.disponibilite) : that.disponibilite != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (titre != null ? titre.hashCode() : 0);
		result = 31 * result + (auteur != null ? auteur.hashCode() : 0);
		result = 31 * result + (disponibilite != null ? disponibilite.hashCode() : 0);
		return result;
	}

	public Collection<EmpruntEntity> getEmpruntsById() {
		return empruntsById;
	}

	public void setEmpruntsById(Collection<EmpruntEntity> empruntsById) {
		this.empruntsById = empruntsById;
	}

	public PersonneEntity getPersonneByAuteur() {
		return personneByAuteur;
	}

	public void setPersonneByAuteur(PersonneEntity personneByAuteur) {
		this.personneByAuteur = personneByAuteur;
	}
}
