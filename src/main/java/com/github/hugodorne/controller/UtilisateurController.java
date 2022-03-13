package com.github.hugodorne.controller;

import com.github.hugodorne.model.UtilisateurEntity;
import com.github.hugodorne.repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UtilisateurController {

    private Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("utilisateur")
    public String getUtilisateur(){
        return "utilisateur";
    }

    @GetMapping("utilisateurs")
    public ModelAndView getUtilisateurs(){
        List<UtilisateurEntity> utilisateurs = utilisateurRepository.findAll();
        return new ModelAndView("utilisateurs", "utilisateurs", utilisateurs);
    }
}
