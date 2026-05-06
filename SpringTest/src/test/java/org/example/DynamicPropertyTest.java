package org.example;

import org.example.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DynamicPropertyTest {
    @DynamicPropertySource
    static void registerProps(DynamicPropertyRegistry registry){
        registry.add("app.message",()->"Dynamic Hello");
    }

    @Autowired
    private HelloController helloController;

    @Test
    void testDynamicProperty(){
        assertEquals("Dynamic Hello",helloController.hello());
    }
}


