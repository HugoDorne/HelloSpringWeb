package com.github.hugodorne.controller;

import com.github.hugodorne.enumeration.Disponibilite;
import com.github.hugodorne.model.BookEntity;
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
import java.time.Instant;
import java.util.List;

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

    public static class Model {

        public List<BookEntity> books;

        public List<PersonEntity> persons;

        public Model(List<BookEntity> books, List<PersonEntity> persons) {
            this.books = books;
            this.persons = persons;
        }

        public List<BookEntity> getBooks() {
            return books;
        }

        public void setBooks(List<BookEntity> books) {
            this.books = books;
        }

        public List<PersonEntity> getPersons() {
            return persons;
        }

        public void setPersons(List<PersonEntity> persons) {
            this.persons = persons;
        }
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
     * Méthode répondant à un POST("returnBorrow").
     *
     * @param request la requête
     * @return la page borrows.jsp
     */
    @PostMapping("returnBorrow")
    public String returnBorrow(HttpServletRequest request) {
        String idStr = request.getParameter("borrowId");

        try {
            var id = Integer.parseInt(idStr);

            var borrow = borrowRepository.getById(id);
            borrow.setBorrowReturn(Instant.now());
            borrow.getBookId().setBookDispo(Disponibilite.DISPONIBLE);

            borrowRepository.save(borrow);

            return "redirect:borrows";

        } catch (NumberFormatException e) {
            logger.warn(e.toString());
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

        return new ModelAndView("borrow", "model",
                new Model(bookRepository.findAll(), personRepository.findAll()));
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
        borrow.setBorrowDate(Instant.now());

        PersonEntity person = personRepository.getById(Integer.valueOf(borrowPerson));
        BookEntity book = bookRepository.getById(Integer.valueOf(borrowBook));
        book.setBookDispo(Disponibilite.INDISPONIBLE);

        borrow.setPersonId(person);
        borrow.setBookId(book);

        borrowRepository.save(borrow);

        return "redirect:borrows";
    }

}
