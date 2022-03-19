package com.github.hugodorne.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The type Index controller.
 */
@Controller
public class LoginController {

    /**
     * The type User.
     */
    public static class User {

        private String username;
        private String password;

        /**
         * Instantiates a new User.
         *
         * @param username the username
         * @param password the password
         */
        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        /**
         * Gets username.
         *
         * @return the username
         */
        public String getUsername() {
            return username;
        }

        /**
         * Sets username.
         *
         * @param username the username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * Gets password.
         *
         * @return the password
         */
        public String getPassword() {
            return password;
        }

        /**
         * Sets password.
         *
         * @param password the password
         */
        public void setPassword(String password) {
            this.password = password;
        }
    }

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * Méthode répondant à un GET("index").
     *
     * @return la page login.jsp, la page de connexion
     */
    @GetMapping()
    public String getLogin(){
        return "login";
    }

    /**
     * Méthode répondant à un POST("login").
     *
     * @param user username et password de l'utilisateur
     * @return la page home.jsp si identifié, la page login.jsp sinon
     */
    @PostMapping("login")
    public String postLogin(User user) {

        if (user != null) {
            String username = user.getUsername();
            String password = user.getPassword();

            if (username != null && password != null
                && username.equals("admin") && password.equals("admin")) {

                logger.info("Admin authentifié, redirection vers accueil");
                return "home";
            } else {
                logger.warn("Utilisateur non authentifié");
                return "login";
            }
        } else {
            logger.warn("Utilisateur non présent");
            return "login";
        }
    }

}
