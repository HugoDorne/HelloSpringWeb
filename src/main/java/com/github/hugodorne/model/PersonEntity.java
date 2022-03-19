package com.github.hugodorne.model;

import com.github.hugodorne.enumeration.Sexe;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "public", catalog = "ddft0v81e8ep51")
public class PersonEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "person_id", nullable = false)
	private int personId;

	@Basic(optional = false)
	@Column(name = "person_firstname", nullable = false, length = 127)
	private String personFirstname;

	@Basic(optional = false)
	@Column(name = "person_lastname", nullable = false, length = 127)
	private String personLastname;

	@Basic(optional = false)
	@Column(name = "person_birthdate")
	private Date personBirthdate;

	@Enumerated(EnumType.STRING)
	@Column(name = "person_sexe", length = 63)
	private Sexe personSexe;

	@Basic
	@Column(name = "person_email")
	private String personEmail;


	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonFirstname() {
		return personFirstname;
	}

	public void setPersonFirstname(String personFirstname) {
		this.personFirstname = personFirstname;
	}

	public String getPersonLastname() {
		return personLastname;
	}

	public void setPersonLastname(String personLastname) {
		this.personLastname = personLastname;
	}

	public Date getPersonBirthdate() {
		return personBirthdate;
	}

	public void setPersonBirthdate(Date personBirthdate) {
		this.personBirthdate = personBirthdate;
	}

	public Sexe getPersonSexe() {
		return personSexe;
	}

	public void setPersonSexe(Sexe personSexe) {
		this.personSexe = personSexe;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PersonEntity that = (PersonEntity) o;

		if (personId != that.personId) return false;
		if (!Objects.equals(personFirstname, that.personFirstname))
			return false;
		if (!Objects.equals(personLastname, that.personLastname))
			return false;
		if (!Objects.equals(personBirthdate, that.personBirthdate))
			return false;
		if (!Objects.equals(personSexe, that.personSexe)) return false;
		return Objects.equals(personEmail, that.personEmail);
	}

	@Override
	public int hashCode() {
		int result = personId;
		result = 31 * result + (personFirstname != null ? personFirstname.hashCode() : 0);
		result = 31 * result + (personLastname != null ? personLastname.hashCode() : 0);
		result = 31 * result + (personBirthdate != null ? personBirthdate.hashCode() : 0);
		result = 31 * result + (personSexe != null ? personSexe.hashCode() : 0);
		result = 31 * result + (personEmail != null ? personEmail.hashCode() : 0);
		return result;
	}
}
