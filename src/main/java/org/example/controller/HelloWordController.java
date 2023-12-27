package org.example.controller;

import org.example.annotation.LuisController;
import org.example.annotation.LuisGetMethod;
import org.example.annotation.LuisPathVariable;
import org.example.service.IService;

@LuisController
public class HelloWordController {

    private final IService service;

    public HelloWordController(IService service) {
        this.service = service;
    }

    @LuisGetMethod("/hello")
    public String sayHelloWorld() {
        return "Hello World";
    }

    @LuisGetMethod("/hello/{name}")
    public String sayHelloWorldTo(@LuisPathVariable("name") String name) {
        return "Hello World to: " + name;
    }

    @LuisGetMethod("/square/{value}")
    public String square(@LuisPathVariable("value") int val) {
        return "Square: " + (val * val);
    }

    @LuisGetMethod("/square_floats/{value}")
    public String square(@LuisPathVariable("value") double val) {
        return "Square: " + (val * val);
    }

    @LuisGetMethod("/test")
    public String sayTest() {
        return "Test is working";
    }

    @LuisGetMethod("/injected")
    public String sayCustomMessage() {
        return service.sayCustomMessage("hello world");
    }
}
