package com.kaisikk.java.mixedstack.controller;

import com.kaisikk.java.mixedstack.domain.Book;
import com.kaisikk.java.mixedstack.repo.BookRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepo repo;

    /**
     * Вызываем получение html страницы
     *
     * @throws Exception
     */
    @Test
    void index() throws Exception {
        // вызываем контроллер
        mockMvc.perform(get("/"))
                // проверяем код ответа
                .andExpect(status().isOk())
                // проверяем имя view
                .andExpect(view().name("index"))
                // проверяем содержит ли контент строку
                .andExpect(content().string(containsString("Index Page")));
    }

    @Test
    void getAllBooks() throws Exception {
        // мокаем репу для текущего теста
        when(repo.findAll()).thenReturn(Arrays.asList(
                new Book(1L, "akka in action", "williams"),
                new Book(2L, "scala professional programming", "odersky")));

        // проверяем имя view и ее наполнение
        mockMvc.perform(get("/html/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("books"))
                .andExpect(content().string(containsString("williams")));
    }

}