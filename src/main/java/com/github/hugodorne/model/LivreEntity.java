package com.github.hugodorne.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.hugodorne.enumeration.Disponibilite;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "livre")
public class LivreEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private int id;

	@Basic(optional = false)
	@Column(name = "titre", nullable = false)
	private String titre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "auteur", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private PersonneEntity auteur;

	@Enumerated(EnumType.STRING)
	@Column(name = "disponibilite", nullable = false)
	private Disponibilite disponibilite;


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

	public PersonneEntity getAuteur() {
		return auteur;
	}

	public void setAuteur(PersonneEntity auteur) {
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
		result = 31 * result + (disponibilite != null ? disponibilite.hashCode() : 0);
		return result;
	}

}
