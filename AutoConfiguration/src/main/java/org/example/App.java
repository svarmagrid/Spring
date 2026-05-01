package org.example;

import org.example.service.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner printServiceMessage(ObjectProvider<MyService> myServiceProvider) {
        return args -> {
            MyService myService = myServiceProvider.getIfAvailable();
            if (myService == null) {
                System.out.println("No MyService bean configured");
                return;
            }
            System.out.println(myService.message());
        };
    }
}
