package org.example.controller;

import org.example.annotation.LuisBody;
import org.example.annotation.LuisController;
import org.example.annotation.LuisGetMethod;
import org.example.annotation.LuisPostMethod;
import org.example.model.Product;
import org.example.service.IService;

@LuisController
public class HelloWordController {

    private IService service;

    public HelloWordController(IService service){
        this.service = service;
    }

    @LuisGetMethod("/hello")
    public String sayHelloWorld(){
        return "Hello World";
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
        System.out.println(newProduct);
        return newProduct;
    }

    @LuisGetMethod("/injected")
    public String sayCustomMessage(){
        return service.sayCustomMessage("hello world");
    }
}
