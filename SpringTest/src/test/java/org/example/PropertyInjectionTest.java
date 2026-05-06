package org.example;

import org.example.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
        "app.message=Hello from Test"
})
public class PropertyInjectionTest {

    @Autowired
    private HelloController helloController;

    @Test
    void testPropertyInjection(){
        assertEquals("Hello from Test", helloController.hello());
    }
}
