package com.kaisikk.java.mixedstack;

import com.kaisikk.java.mixedstack.domain.Book;
import com.kaisikk.java.mixedstack.repo.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MixedstackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MixedstackApplication.class, args);
    }

    /**
     * Наполнение временной базы
     *
     * @param repo
     * @return CommandLineRunner
     */
    public CommandLineRunner commandLineRunner (BookRepo repo){
        return args -> {
            repo.save(new Book("akka in action", "willams"));
            repo.save(new Book("scala professional programming", "odersky"));
            repo.save(new Book("selfish gen", "dawkins"));
        };
    }

}
