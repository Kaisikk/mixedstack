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

    @GetMapping
    public String  index(){
        return "index";
    }

    @GetMapping("second")
    public String second(){
        return "second";
    }

    @GetMapping("/html/books")
    public String getAllBooks(Model model){
        model.addAttribute("books",repo.findAll());
        return "books";
    }
}
