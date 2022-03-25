package tech.shaban.udemy.service;

import java.util.UUID;

public class GreetingService {
    
    public String sayHello(String name) {
        return String.format("Hello %s, your id is %s", name, UUID.randomUUID().toString());
    }
}
