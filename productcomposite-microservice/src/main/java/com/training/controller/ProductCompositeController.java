package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.Product;
import com.training.service.ProductCompositeService;

@RestController
public class ProductCompositeController {

    @Autowired
    private ProductCompositeService productCompositeService;

    @GetMapping("/product-details/{id}")
    public Product getDetails(@PathVariable int id) {
        return productCompositeService.getProductDetails(id);
    }
}
