package com.github.hugodorne.controller;

import com.github.hugodorne.model.BookEntity;
import com.github.hugodorne.model.BorrowEntity;
import com.github.hugodorne.model.BorrowEntity;
import com.github.hugodorne.model.PersonEntity;
import com.github.hugodorne.repository.BookRepository;
import com.github.hugodorne.repository.BorrowRepository;
import com.github.hugodorne.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Borrow controller.
 */
@Controller
public class BorrowController {

    private final Logger logger = LoggerFactory.getLogger(BorrowController.class);

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;

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

    /**
     * Méthode répondant à un POST("editBorrow").
     *
     * @param request la requête
     * @return la page borrow.jsp
     */
    @PostMapping("editBorrow")
    public ModelAndView editBorrow(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        int id;

        try {
            id = Integer.parseInt(idStr);
            return new ModelAndView("borrow", "borrow", borrowRepository.getById(id));

        } catch (NumberFormatException e) {
            logger.warn(e.toString());
            return getBorrows();
        }
    }

    /**
     * Méthode répondant à un POST("saveBorrow").
     *
     * @param request la requête
     * @return la page borrows.jsp
     */
    @PostMapping("saveBorrow")
    public String saveBorrow(HttpServletRequest request) {
        String borrowPerson = request.getParameter("borrowPerson");
        String borrowBook = request.getParameter("borrowBook");

        //Création Personne
        var borrow = new BorrowEntity();

        PersonEntity person = personRepository.getById(Integer.valueOf(borrowPerson));
        BookEntity book = bookRepository.getById(Integer.valueOf(borrowBook));

        borrow.setPersonId(person);
        borrow.setBookId(book);

        borrowRepository.save(borrow);

        return "redirect:borrows";
    }

    /**
     * Méthode répondant à un POST("deleteBorrow").
     *
     * @param request la requête
     * @return la page borrows.jsp
     */
    @PostMapping("deleteBorrow")
    public String deleteBorrow(HttpServletRequest request) {
        String idStr = request.getParameter("id");

        try {
            var id = Integer.parseInt(idStr);
            Optional<BorrowEntity> borrowOpt = borrowRepository.findById(id);

            if (borrowOpt.isPresent()) {
                BorrowEntity borrow = borrowOpt.get();

                borrowRepository.delete(borrow);
            }
            return "redirect:borrows";
        } catch (NumberFormatException e) {
            logger.error(e.getMessage());
            return "redirect:borrows";
        }
    }

    /**
     * Méthode répondant à un POST("createBorrow").
     *
     * @return la page borrow.jsp
     */
    @PostMapping("createBorrow")
    public ModelAndView createBorrow() {
        var borrow = new BorrowEntity();
        return new ModelAndView("borrow", "borrow", borrow);
    }
}
