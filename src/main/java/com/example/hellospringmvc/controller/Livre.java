package com.example.hellospringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Livre {

    @GetMapping("livre")
    public String getIndex(){
        return "livre";
    }
}
