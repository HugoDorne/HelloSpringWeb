package com.github.hugodorne.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    public class User {

        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private final Logger logger = LoggerFactory.getLogger("IndexController");

    @GetMapping("index")
    public String getIndex(){
        return "index";
    }

    @PostMapping("login")
    public String postLogin(User user) {

        String username = user.getUsername();
        String password = user.getPassword();

        logger.info("Username : {}, Password : {}", username, password);

        return "accueil";
    }

}
