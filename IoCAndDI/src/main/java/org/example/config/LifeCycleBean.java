package org.example.config;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class LifeCycleBean {

    @PostConstruct
    public void init(){
        System.out.println("Bean initialized...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean destroyed...");
    }
}
