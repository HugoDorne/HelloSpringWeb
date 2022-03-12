package com.github.hugodorne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpruntController {

    @GetMapping("emprunt")
    public String getEmprunt(){
        return "emprunt";
    }

    @GetMapping("emprunts")
    public String getEmprunts(){
        return "emprunts";
    }
}
