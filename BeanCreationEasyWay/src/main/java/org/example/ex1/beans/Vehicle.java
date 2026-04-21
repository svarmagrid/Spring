package org.example.ex1.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Vehicle implements InitializingBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello from bean");
    }

    //using the dependency jakarta.annotation to initialize (Preferred)
//    @PostConstruct
//    public void initialize(){
//        this.name = "Audi";
//    }

    //it runs after a bean’s properties have been set by the container but before the bean is used.
    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "Tesla";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying vehicle bean");
    }

}
