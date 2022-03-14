package com.github.hugodorne.controller;

import com.github.hugodorne.enumeration.Sexe;
import com.github.hugodorne.model.PersonneEntity;
import com.github.hugodorne.repository.PersonneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Optional;

@Controller
public class PersonneController {

	private final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

	@Autowired
	PersonneRepository personneRepository;

	@Autowired
	UtilisateurController utilisateurController;

	@PostMapping("editPersonne")
	public ModelAndView editUtilisateur(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		int id;

		try {
			id = Integer.parseInt(idStr);
			return new ModelAndView("personne", "personne", personneRepository.findById(id).get());

		} catch (NumberFormatException e) {
			logger.warn(e.toString());
			return utilisateurController.getUtilisateurs();
		}
	}

	@PostMapping("savePersonne")
	public String saveUtilisateur(HttpServletRequest request) throws ParseException {
		String idStr = request.getParameter("id");
		String nom = request.getParameter("personneNom");
		String prenom = request.getParameter("personnePrenom");
		String dateNaissanceStr = request.getParameter("personneDateNaissance");

		var dateNaissance = Date.valueOf(dateNaissanceStr);

		try {
			var id = Integer.parseInt(idStr);

			if (id > 0) {
				//Mise à jour personne
				Optional<PersonneEntity> personneOpt = personneRepository.findById(id);

				if (personneOpt.isPresent()) {
					PersonneEntity personne = personneOpt.get();

					personne.setNom(nom);
					personne.setPrenom(prenom);
					personne.setDateAnniversaire(dateNaissance);

					personneRepository.save(personne);
				}
			} else {
				//Création Personne
				var personne = new PersonneEntity();

				personne.setNom(nom);
				personne.setPrenom(prenom);
				personne.setDateAnniversaire(dateNaissance);
				personne.setSexe(Sexe.HOMME);

				personneRepository.save(personne);
			}

			return "redirect:utilisateurs";
		} catch (NumberFormatException e) {
			logger.warn(Arrays.toString(e.getStackTrace()));
			return "redirect:utilisateurs";
		}
	}
}
