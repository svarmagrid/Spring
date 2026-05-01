package org.example.service;

public class CustomService implements MyService{
    @Override
    public String message() {
        return "Custom service (Overrides auto-config)";
    }
}
