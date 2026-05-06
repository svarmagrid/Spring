package org.example;

import org.example.service.CounterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FixedWithDirtiesContextTest {

    @Autowired
    private CounterService counterService;

    @Test
    void test1(){
        int val = counterService.increment();
        System.out.println(val);
        assertEquals(1,val);
    }

    @Test
    void test2(){

        assertEquals(1,counterService.increment());
//        System.out.println(counterService.getCounter());
    }
}
