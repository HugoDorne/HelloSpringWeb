package com.github.hugodorne.controller;

import com.github.hugodorne.model.BookEntity;
import com.github.hugodorne.repository.BookRepository;
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
 * The type Book controller.
 */
@Controller
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(PersonController.class);

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

    /**
     * Méthode répondant à un POST("editBook").
     *
     * @param request la requête
     * @return la page book.jsp
     */
    @PostMapping("editBook")
    public ModelAndView editBook(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        int id;

        try {
            id = Integer.parseInt(idStr);
            return new ModelAndView("book", "book", bookRepository.getById(id));

        } catch (NumberFormatException e) {
            logger.warn(e.toString());
            return getBooks();
        }
    }

    /**
     * Méthode répondant à un POST("saveBook").
     *
     * @param request la requête
     * @return la page books.jsp
     */
    @PostMapping("saveBook")
    public String saveBook(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        String bookTitle = request.getParameter("bookTitle");
        String bookAuthors = request.getParameter("bookAuthors");

        try {
            var bookId = Integer.parseInt(idStr);

            if (bookId > 0) {
                //Mise à jour person
                Optional<BookEntity> bookOpt = bookRepository.findById(bookId);

                if (bookOpt.isPresent()) {
                    BookEntity book = bookOpt.get();

                    book.setBookTitle(bookTitle);
                    book.setBookAuthors(bookAuthors);

                    bookRepository.save(book);
                }
            } else {
                //Création Personne
                var book = new BookEntity();

                book.setBookTitle(bookTitle);
                book.setBookAuthors(bookAuthors);

                bookRepository.save(book);
            }

            return "redirect:books";
        } catch (NumberFormatException e) {
            logger.warn(Arrays.toString(e.getStackTrace()));
            return "redirect:books";
        }
    }

    /**
     * Méthode répondant à un POST("deleteBook").
     *
     * @param request la requête
     * @return la page books.jsp
     */
    @PostMapping("deleteBook")
    public String deleteBook(HttpServletRequest request) {
        String idStr = request.getParameter("id");

        try {
            var id = Integer.parseInt(idStr);
            Optional<BookEntity> bookOpt = bookRepository.findById(id);

            if (bookOpt.isPresent()) {
                BookEntity book = bookOpt.get();

                bookRepository.delete(book);
            }
            return "redirect:books";
        } catch (NumberFormatException e) {
            logger.warn(Arrays.toString(e.getStackTrace()));
            return "redirect:books";
        }
    }

    /**
     * Méthode répondant à un POST("createBook").
     *
     * @return la page book.jsp
     */
    @PostMapping("createBook")
    public ModelAndView createBook() {
        var book = new BookEntity();
        return new ModelAndView("book", "book", book);
    }
}
