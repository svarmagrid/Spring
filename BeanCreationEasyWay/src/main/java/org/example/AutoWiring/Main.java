package org.example.AutoWiring;

import org.example.AutoWiring.beans.Car;
import org.example.AutoWiring.beans.Engine;

import org.example.AutoWiring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var car = context.getBean(Car.class);
        var engine = context.getBean(Engine.class);
        System.out.println("Car name from Spring context: "+car.getName());
        System.out.println("Engine name from Spring context: "+engine.getName());
        System.out.println("Engine that car own is: "+car.getEngine());
    }
}
