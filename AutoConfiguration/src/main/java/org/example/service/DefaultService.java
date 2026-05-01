package org.example.service;

public class DefaultService implements MyService{
    @Override
    public String message() {
        return "Default auto configured service";
    }
}
