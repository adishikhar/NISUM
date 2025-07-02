package com.nisum.Q1.component;



import com.nisum.Q1.Greeter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GreeterComponent implements Greeter {

    @Override
    public String greet(String name) {
        return "Hello from Component, " + name;
    }
}
