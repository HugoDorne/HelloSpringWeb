package com.github.hugodorne.controller;

import com.github.hugodorne.model.BookEntity;
import com.github.hugodorne.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The type Book controller.
 */
@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Méthode répondant à un GET("book").
     *
     * @return la page book.jsp
     */
    @GetMapping("book")
    public String getBook(){
        return "book";
    }

    /**
     * Méthode répondant à un GET("books").
     *
     * @return la page books.jsp listant tous les livres
     */
    @GetMapping("books")
    public ModelAndView getBooks(){
        List<BookEntity> books = bookRepository.findAll();
        return new ModelAndView("books", "books", books);
    }
}
