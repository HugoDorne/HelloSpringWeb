package com.github.hugodorne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Home controller.
 */
@Controller
public class HomeController {

    /**
     * Méthode répondant à un GET("home").
     *
     * @return la page home.jsp qui est la page d'accueil
     */
    @GetMapping("home")
    public String getHome(){
        return "home";
    }
}
