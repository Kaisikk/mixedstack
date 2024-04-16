package com.kaisikk.java.mixedstack.repo;

import com.kaisikk.java.mixedstack.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {


}
