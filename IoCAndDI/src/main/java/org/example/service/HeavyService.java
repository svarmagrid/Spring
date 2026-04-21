package org.example.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HeavyService {
    public HeavyService() {
        System.out.println("Heavy service initialied");
    }

    public void execute(){
        System.out.println("Heavy Service running...");
    }
}
