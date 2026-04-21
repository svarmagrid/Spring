package org.example.DynamicBeanRegistration.beans;


public class Vehicle {
    private String name;
    private Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
        System.out.println("Vehicle bean created");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "engine=" + engine +
                ", name='" + name + '\'' +
                '}';
    }
}
