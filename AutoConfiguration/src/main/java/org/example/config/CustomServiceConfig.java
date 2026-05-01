package org.example.config;

import org.example.service.CustomService;
import org.example.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomServiceConfig {

    @Bean
    public MyService myService(){
        return new CustomService();
    }
}
