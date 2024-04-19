package com.kaisikk.java.mixedstack.controller;

import com.kaisikk.java.mixedstack.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BookRepo repo;

    /**
     * Начальная страница
     *
     * @return String
     */
    @GetMapping
    public String  index(){
        return "index";
    }

    /**
     * Вторая тестовая страница
     *
     * @return String
     */
    @GetMapping("second")
    public String second(){
        return "second";
    }

    /**
     * Наполнение html страницы с найденными объектами
     *
     * @param model
     * @return String
     */
    @GetMapping("/html/books")
    public String getAllBooks(Model model){
        model.addAttribute("books",repo.findAll());
        return "books";
    }
}
