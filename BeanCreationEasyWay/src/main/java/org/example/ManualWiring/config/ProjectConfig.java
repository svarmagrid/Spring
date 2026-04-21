package org.example.ManualWiring.config;

import org.example.ManualWiring.beans.Person;
import org.example.ManualWiring.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        return vehicle;
    }

    //Two ways to create manual wiring
    //1. method call
//    @Bean
//    Person person(){
//        Person person = new Person();
//        person.setName("Satish");
//        person.setVehicle(vehicle());
//        return person;
//    }

    //2. passing parameter
    @Bean
    Person person(Vehicle vehicle){
        Person person = new Person();
        person.setName("Varma");
        person.setVehicle(vehicle);
        return person;
    }
}
