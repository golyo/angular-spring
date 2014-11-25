package com.zh.angular.spring.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zh.angular.spring.domain.Book;

import javax.servlet.http.HttpServletResponse;

import java.io.Serializable;
import java.util.List;

/**
 * REST controller for managing Book.
 */
@RestController
@RequestMapping("/app")
public class BookResource {

    private final Logger log = LoggerFactory.getLogger(BookResource.class);

    @Autowired
    private JpaRepository<Book, Serializable> bookRepository;
    
    /**
     * POST  /rest/books -> Create a new book.
     */
    @RequestMapping(value = "/rest/books",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Book book) {
        log.debug("REST request to save Book : {}", book);
        bookRepository.save(book);
    }

    /**
     * GET  /rest/books -> get all the books.
     */
    @RequestMapping(value = "/rest/books",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAll() {
        List<Book> all = bookRepository.findAll();
        log.debug("REST request to get all Books" + all);
        return all;
    }

    /**
     * GET  /rest/books/:id -> get the "id" book.
     */
    @RequestMapping(value = "/rest/books/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Book : {}", id);
        Book book = bookRepository.findOne(id);
        if (book == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    /**
     * DELETE  /rest/books/:id -> delete the "id" book.
     */
    @RequestMapping(value = "/rest/books/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        log.debug("REST request to delete Book : {}", id);
        bookRepository.delete(id);
    }
}
