package com.kaisikk.java.mixedstack.controller;

import com.kaisikk.java.mixedstack.domain.Book;
import com.kaisikk.java.mixedstack.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class BookController {

    // репа для энтити
    @Autowired
    private BookRepo bookRepo;

    /**
     * Получение всех книг
     *
     * @return
     */
    @GetMapping
    public Iterable<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    /**
     * Поиск книги по id
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id){
        return bookRepo.findById(id).get();
    }

}
