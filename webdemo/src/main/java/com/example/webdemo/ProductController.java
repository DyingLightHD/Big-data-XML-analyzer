package com.example.webdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@Controller
public class ProductController {

    ArrayList<Product> productList = new ArrayList<Product>();

    @GetMapping("/product")
    public String productForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/product")
    public String productSubmit(@ModelAttribute Product product){
        productList.add(product);
        return "result";
    }

    @GetMapping("/products")
    public String ListProducts(Model model){
        model.addAttribute("products", productList);
        return "products";
    }
}

