package com.github.hugodorne.controller;

import com.github.hugodorne.model.PersonneEntity;
import com.github.hugodorne.model.UtilisateurEntity;
import com.github.hugodorne.repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class UtilisateurController {

    private Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @GetMapping("utilisateurs")
    public ModelAndView getUtilisateurs(){
        List<UtilisateurEntity> utilisateurs = utilisateurRepository.findAll();
        return new ModelAndView("utilisateurs", "utilisateurs", utilisateurs);
    }

    @PostMapping("deleteUtilisateur")
    public String saveUtilisateur(HttpServletRequest request) {
        String idStr = request.getParameter("id");

        try {
            var id = Integer.parseInt(idStr);
            Optional<UtilisateurEntity> utilisateurOpt = utilisateurRepository.findById(id);

            if (utilisateurOpt.isPresent()) {
                UtilisateurEntity utilisateur = utilisateurOpt.get();

                utilisateurRepository.delete(utilisateur);
            }
            return "redirect:utilisateurs";
        } catch (NumberFormatException e) {
            logger.warn(Arrays.toString(e.getStackTrace()));
            return "redirect:utilisateurs";
        }
    }

    @PostMapping("createUtilisateur")
    public ModelAndView createUtilisateur() {
        var personne = new PersonneEntity();
        return new ModelAndView("personne", "personne", personne);
    }

}
