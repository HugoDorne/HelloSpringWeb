package com.github.hugodorne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HelloSpringMvcApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringMvcApplication.class, args);
    }

}
