package com.training.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.dto.Product;

@FeignClient("product-microservice")
public interface ProductApiCall {

    @GetMapping("/product/{id}")
    public Product get(@PathVariable int id);
}
