package com.github.hugodorne.controller;

import com.github.hugodorne.model.LivreEntity;
import com.github.hugodorne.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LivreController {

    @Autowired
    private LivreRepository livreRepository;

    @GetMapping("livre")
    public String getLivre(){
        return "livre";
    }

    @GetMapping("livres")
    public ModelAndView getLivres(){
        List<LivreEntity> livres = livreRepository.findAll();
        return new ModelAndView("livres", "livres", livres);
    }
}
