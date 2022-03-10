package com.github.hugodorne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Emprunt {

    @GetMapping("emprunt")
    public String getIndex(){
        return "emprunt";
    }
}
