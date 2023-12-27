package org.example.controller;

import org.example.annotation.*;
import org.example.model.Product;
import org.example.service.IService;
import org.example.service.ProductService;

import java.util.List;

@LuisController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @LuisGetMethod("/product")
    public List<Product> showProduct() {
        return service.getAllProducts();
    }

    @LuisGetMethod("/product")
    public Product showProduct(@LuisRequestParam("name") String nameToSearch) {
        return service.getProductByName(nameToSearch);
    }

    @LuisPostMethod("/product")
    public Product saveProduct(@LuisBody Product newProduct) {
        return newProduct;
    }

    @LuisPostMethod("/product/{id}")
    public Product saveProduct(@LuisBody Product newProduct, @LuisPathVariable("id") long id) {
        if (id > 1)
            return newProduct;
        else
            return new Product();
    }
}
