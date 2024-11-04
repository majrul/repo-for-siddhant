package com.training.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Product;
import com.training.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private int port;

    @GetMapping("/product/all")
    public List<Product> getAllProducts() {
        return productService.fetchAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) throws UnknownHostException {
        Product product = productService.fetch(id);
        product.setServiceUrl(InetAddress.getLocalHost().getHostAddress() + ":" + port);
        return product;
    }

    @PostMapping("/product/add")
    public String addProduct(@RequestBody Product product) {
        productService.add(product);
        return "Product added!";
    }

}
