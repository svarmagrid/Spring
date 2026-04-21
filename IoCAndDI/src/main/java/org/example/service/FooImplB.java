package org.example.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("fooB")
@Primary
public class FooImplB implements Foo{

    public String process(){
        return "Foo B processing (Primary)";
    }
}
