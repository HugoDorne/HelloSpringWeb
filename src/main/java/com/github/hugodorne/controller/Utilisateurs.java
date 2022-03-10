package com.github.hugodorne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Utilisateurs {

    @GetMapping("utilisateurs")
    public String getIndex(){
        return "utilisateurs";
    }
}
