package com.kaisikk.java.mixedstack.repo;

import com.kaisikk.java.mixedstack.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepo extends CrudRepository<Book, Long> {

    Optional<Book> findByNameAndAuthor(String name, String author);
}
