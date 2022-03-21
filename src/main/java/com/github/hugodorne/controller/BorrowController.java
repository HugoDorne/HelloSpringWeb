package com.github.hugodorne.controller;

import com.github.hugodorne.model.BorrowEntity;
import com.github.hugodorne.repository.BorrowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The type Borrow controller.
 */
@Controller
public class BorrowController {

    private final Logger logger = LoggerFactory.getLogger(BorrowController.class);

    @Autowired
    private BorrowRepository borrowRepository;

    /**
     * Méthode répondant à un GET("borrow").
     *
     * @return la page borrow.jsp qui montre les attributs d'un emprunt
     */
    @GetMapping("borrow")
    public String getBorrow(){
        return "borrow";
    }

    /**
     * Méthode répondant à un GET("borrows").
     *
     * @return la page borrows.jsp qui liste les emprunts
     */
    @GetMapping("borrows")
    public ModelAndView getBorrows(){
        List<BorrowEntity> borrows = borrowRepository.findAll();
        return new ModelAndView("borrows", "borrows", borrows);
    }
}
