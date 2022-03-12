package com.github.hugodorne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilisateurController {

    @GetMapping("utilisateur")
    public String getUtilisateur(){
        return "utilisateur";
    }

    @GetMapping("utilisateurs")
    public String getUtilisateurs(){
        return "utilisateurs";
    }
}