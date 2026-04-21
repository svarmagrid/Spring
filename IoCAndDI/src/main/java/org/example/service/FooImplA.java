package org.example.service;

import org.springframework.stereotype.Component;

@Component("fooA")
public class FooImplA implements Foo{
    public String process(){
        return "Foo A processing";
    }
}
