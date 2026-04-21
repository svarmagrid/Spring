package org.example.config;

import org.example.service.Foo;
import org.example.service.FooImplA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    // Bean defined with interface return type
    @Bean
    public Foo fooFromConfig() {
        return new FooImplA();
    }

    // Bean defined as concrete type
    @Bean
    public FooImplA fooImplFromConfig() {
        return new FooImplA();
    }
}


