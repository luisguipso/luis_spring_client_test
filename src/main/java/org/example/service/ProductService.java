package org.example.service;

import org.example.annotation.LuisService;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@LuisService
public class ProductService {

    Map<String, Product> products = new HashMap<>();

    public ProductService() {
        Product p = new Product();
        p.setId(123456);
        p.setName("computer");
        p.setPrice(2500.0);
        p.setImageLink("computer.jpg");
        products.put(p.getName(), p);

        p = new Product();
        p.setId(123457);
        p.setName("laptop");
        p.setPrice(3000.0);
        p.setImageLink("laptop.jpg");
        products.put(p.getName(), p);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductByName(String nameToSearch) {
        return products.get(nameToSearch);
    }
}
