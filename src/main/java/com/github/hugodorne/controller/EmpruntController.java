package com.github.hugodorne.controller;

import com.github.hugodorne.model.EmpruntEntity;
import com.github.hugodorne.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmpruntController {

    @Autowired
    private EmpruntRepository empruntRepository;

    @GetMapping("emprunt")
    public String getEmprunt(){
        return "emprunt";
    }

    @GetMapping("emprunts")
    public ModelAndView getEmprunts(){
        List<EmpruntEntity> emprunts = empruntRepository.findAll();
        return new ModelAndView("emprunts", "emprunts", emprunts);
    }
}
