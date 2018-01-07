package com.example.webdemo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    public List<Product> listAllProduct();
    public Product findProductByName(String productName);
}
