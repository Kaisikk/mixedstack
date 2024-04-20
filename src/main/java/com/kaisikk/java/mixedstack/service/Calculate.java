package com.kaisikk.java.mixedstack.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Calculate {

    private Map<Integer, Integer> cacheResults = new HashMap<>();

    @Cacheable("sums")
    public int sum(int a, int b){
        try {
            Thread.sleep(7500);
        } catch (InterruptedException interruptedException){}
        return a + b;
    }

}
