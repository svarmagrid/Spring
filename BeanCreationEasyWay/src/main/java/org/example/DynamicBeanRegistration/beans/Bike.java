package org.example.DynamicBeanRegistration.beans;

public class Bike {
    public Bike() {
        System.out.println("Bike bean created");
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
        return "Bike{" +
                "name='" + name + '\'' +
                '}';
    }
}
