package com.kaisikk.java.mixedstack.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {

    @Autowired
    private Language language;

    public int sum(int a, int b){
        return a + b;
    }

    public String sayHello(){
        return language.hello();
    }
}
