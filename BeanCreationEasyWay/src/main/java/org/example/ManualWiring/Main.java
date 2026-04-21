package org.example.ManualWiring;

import org.example.ManualWiring.beans.Person;
import org.example.ManualWiring.beans.Vehicle;

import org.example.ManualWiring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var person = context.getBean(Person.class);
        var vehicle = context.getBean(Vehicle.class);
        System.out.println("Person name: "+person.getName());
        System.out.println("vehicle owned by person is: "+person.getVehicle());
        System.out.println("Vehicle name from vehicle bean: "+vehicle.getName());
    }
}
