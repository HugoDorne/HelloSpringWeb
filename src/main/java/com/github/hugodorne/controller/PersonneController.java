package com.github.hugodorne.controller;

import com.github.hugodorne.repository.PersonneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonneController {

	private Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

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
			return new ModelAndView("utilisateur", "personne", personneRepository.findById(id).get());

		} catch (NumberFormatException e) {
			logger.warn(e.toString());
			return utilisateurController.getUtilisateurs();
		}
	}

	@PostMapping("savePersonne")
	public String saveUtilisateur(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissance = request.getParameter("dateNaissance");

		return "redirect:utilisateurs";
	}
}
