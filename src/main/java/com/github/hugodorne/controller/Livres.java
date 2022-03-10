package com.github.hugodorne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Livres {

    @GetMapping("livres")
    public String getIndex(){
        return "livres";
    }
}
