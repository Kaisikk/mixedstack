package com.kaisikk.java.mixedstack.repo;

import com.kaisikk.java.mixedstack.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookRepoTest {

    @Autowired
    private BookRepo bookRepo;

    @Test
    void findByNameAndAuthor() {
       assert(!bookRepo.findAll().iterator().hasNext());

        Book book = bookRepo.save(new Book("akka in action", "willaims"));

        assertTrue(bookRepo.findByNameAndAuthor("akka in action", "willaims").get().getId() == book.getId());
    }

    @Test
    public void findAll(){
        assert(!bookRepo.findAll().iterator().hasNext());

        bookRepo.save(new Book("akka in action", "willaims"));
        bookRepo.save(new Book("scala professional programming", "odersky"));
        bookRepo.save(new Book("selfish gen", "dawkins"));

        assertTrue(StreamSupport.stream(bookRepo.findAll().spliterator(), false).count() == 3);
    }

    @Test
    public void saveNewBook(){

        assert(!bookRepo.findAll().iterator().hasNext());

        Book book = bookRepo.save(new Book("akka in action", "willaims"));
        Book book2 = bookRepo.save(new Book("scala professional programming", "odersky"));

        assertTrue(bookRepo.save(book).getAuthor().equals("willaims"));
        assertTrue(bookRepo.save(book2).getName().equals("scala professional programming"));
    }
}