package org.example.DynamicBeanRegistration.beans;

public class Engine {


    public Engine() {
        System.out.println("Engine bean created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                '}';
    }
}
