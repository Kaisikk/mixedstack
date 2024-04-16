package com.kaisikk.java.mixedstack.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    public Book(){}

    public Book(String name, String author){
        this.author = author;
        this.name = name;
    }

    public Book(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
