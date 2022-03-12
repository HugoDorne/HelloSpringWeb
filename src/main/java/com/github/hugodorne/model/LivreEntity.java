package com.github.hugodorne.model;

import com.github.hugodorne.enumeration.Disponibilite;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "livre")
public class LivreEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;

	@Basic
	@Column(name = "titre", nullable = false)
	private String titre;

	@Basic
	@Column(name = "auteur", nullable = false)
	private int auteur;

	@Basic
	@Column(name = "disponibilite", nullable = false)
	private Disponibilite disponibilite;

	@OneToMany(mappedBy = "livreByLivreId")
	private Collection<EmpruntEntity> empruntsById;

	@ManyToOne
	@JoinColumn(name = "auteur", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
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

	public int getAuteur() {
		return auteur;
	}

	public void setAuteur(int auteur) {
		this.auteur = auteur;
	}

	public Disponibilite getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LivreEntity that = (LivreEntity) o;

		if (id != that.id) return false;
		if (auteur != that.auteur) return false;
		if (!Objects.equals(titre, that.titre)) return false;
		return Objects.equals(disponibilite, that.disponibilite);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (titre != null ? titre.hashCode() : 0);
		result = 31 * result + auteur;
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
