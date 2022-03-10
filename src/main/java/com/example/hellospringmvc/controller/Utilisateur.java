package com.example.hellospringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Utilisateur {

    @GetMapping("utilisateur")
    public String getIndex(){
        return "utilisateur";
    }
}
