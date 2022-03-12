package com.github.hugodorne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LivreController {

    @GetMapping("livre")
    public String getLivre(){
        return "livre";
    }

    @GetMapping("livres")
    public String getLivres(){
        return "livres";
    }
}
