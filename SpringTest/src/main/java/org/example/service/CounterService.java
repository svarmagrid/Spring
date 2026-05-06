package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private int counter;

    public int increment(){
        return ++counter;
    }

    public int getCounter(){
        return counter;
    }
}
