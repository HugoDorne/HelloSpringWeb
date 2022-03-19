package com.github.hugodorne.controller;

import com.github.hugodorne.enumeration.Sexe;
import com.github.hugodorne.model.PersonEntity;
import com.github.hugodorne.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Person controller.
 */
@Controller
public class PersonController {

	private final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	PersonRepository personRepository;

	/**
	 * Méthode répondant à un GET("persons").
	 *
	 * @return la page persons.jsp
	 */
	@GetMapping("persons")
	public ModelAndView getPersons(){
		List<PersonEntity> persons = personRepository.findAll();
		return new ModelAndView("persons", "persons", persons);
	}

	/**
	 * Méthode répondant à un POST("editPerson").
	 *
	 * @param request la requête
	 * @return la page person.jsp
	 */
	@PostMapping("editPerson")
	public ModelAndView editPerson(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		int id;

		try {
			id = Integer.parseInt(idStr);
			return new ModelAndView("person", "person", personRepository.getById(id));

		} catch (NumberFormatException e) {
			logger.warn(e.toString());
			return getPersons();
		}
	}

	/**
	 * Méthode répondant à un POST("savePerson").
	 *
	 * @param request la requête
	 * @return la page persons.jsp
	 */
	@PostMapping("savePerson")
	public String savePerson(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		String nom = request.getParameter("personneNom");
		String prenom = request.getParameter("personnePrenom");
		String dateNaissanceStr = request.getParameter("personneDateNaissance");

		var dateNaissance = Date.valueOf(dateNaissanceStr);

		try {
			var id = Integer.parseInt(idStr);

			if (id > 0) {
				//Mise à jour person
				Optional<PersonEntity> personOpt = personRepository.findById(id);

				if (personOpt.isPresent()) {
					PersonEntity personne = personOpt.get();

					personne.setPersonLastname(nom);
					personne.setPersonFirstname(prenom);
					personne.setPersonBirthdate(dateNaissance);

					personRepository.save(personne);
				}
			} else {
				//Création Personne
				var personne = new PersonEntity();

				personne.setPersonLastname(nom);
				personne.setPersonFirstname(prenom);
				personne.setPersonBirthdate(dateNaissance);
				personne.setPersonSexe(Sexe.HOMME);

				personRepository.save(personne);
			}

			return "redirect:persons";
		} catch (NumberFormatException e) {
			logger.warn(Arrays.toString(e.getStackTrace()));
			return "redirect:persons";
		}
	}

	/**
	 * Méthode répondant à un POST("deletePerson").
	 *
	 * @param request la requête
	 * @return la page persons.jsp
	 */
	@PostMapping("deletePerson")
	public String deletePerson(HttpServletRequest request) {
		String idStr = request.getParameter("id");

		try {
			var id = Integer.parseInt(idStr);
			Optional<PersonEntity> personOpt = personRepository.findById(id);

			if (personOpt.isPresent()) {
				PersonEntity person = personOpt.get();

				personRepository.delete(person);
			}
			return "redirect:persons";
		} catch (NumberFormatException e) {
			logger.warn(Arrays.toString(e.getStackTrace()));
			return "redirect:persons";
		}
	}

	/**
	 * Méthode répondant à un POST("createPerson").
	 *
	 * @return la page person.jsp
	 */
	@PostMapping("createPerson")
	public ModelAndView createPerson() {
		var person = new PersonEntity();
		return new ModelAndView("person", "person", person);
	}
}
