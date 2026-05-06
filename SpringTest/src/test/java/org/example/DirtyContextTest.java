package org.example;

import org.example.service.CounterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DirtyContextTest {

    @Autowired
    private CounterService counterService;

    @Test
    void test1(){
        int value = counterService.increment();
        assertEquals(1,value);
    }

    @Test
    void test2() {
        int value = counterService.increment();
        // This will FAIL because counter is already incremented
        assertEquals(1, value);
    }
}
