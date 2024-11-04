package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dto.Product;
import com.training.dto.Rating;

@Service
public class ProductCompositeService2 {

    @Autowired
    private ProductApiCall productApiCall;

    @Autowired
    private RatingsApiCall ratingsApiCall;

     public Product getProductDetails(int productId) {
        Product product  = productApiCall.get(productId);
        List<Rating> ratings = ratingsApiCall.get(productId);
        product.setRatings(ratings);
        return product;
    }
}
