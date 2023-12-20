package org.example.controller;

import org.example.annotation.*;
import org.example.model.Product;
import org.example.service.IService;

@LuisController
public class HelloWordController {

    private final IService service;

    public HelloWordController(IService service){
        this.service = service;
    }

    @LuisGetMethod("/hello")
    public String sayHelloWorld(){
        return "Hello World";
    }

    @LuisGetMethod("/hello/{name}")
    public String sayHelloWorldTo(@LuisPathVariable("name") String name){
        return "Hello World to: " + name;
    }
    @LuisGetMethod("/square/{value}")
    public String square(@LuisPathVariable("value") int val){
        return "Square: " + (val*val);
    }

    @LuisGetMethod("/square_floats/{value}")
    public String square(@LuisPathVariable("value") double val){
        return "Square: " + (val*val);
    }

    @LuisGetMethod("/test")
    public String sayTest(){
        return "Test is working";
    }

    @LuisGetMethod("/product")
    public Product showProduct(){
        Product p = new Product();
        p.setId(123456);
        p.setName("computer");
        p.setPrice(2500.0);
        p.setImageLink("computer.jpg");
        return p;
    }

    @LuisPostMethod("/product")
    public Product saveProduct(@LuisBody Product newProduct){
        return newProduct;
    }

    @LuisGetMethod("/injected")
    public String sayCustomMessage(){
        return service.sayCustomMessage("hello world");
    }
}
