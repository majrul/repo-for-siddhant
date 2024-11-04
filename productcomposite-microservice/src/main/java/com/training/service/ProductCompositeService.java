package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.dto.Product;
import com.training.dto.Rating;

@Service
public class ProductCompositeService {

    @Autowired
    @Qualifier("rtLb")
    private RestTemplate restTemplate;

    @Value("${productUrl}")
    private String productUrl;

    @Value("${ratingUrl}")
    private String ratingUrl;

    public Product getProductDetails(int productId) {
        //String productApiUrl = "http://localhost:8001/product/{id}";
        String productApiUrl = productUrl + "/product/{id}";
        Product product  = restTemplate.getForObject(productApiUrl, Product.class, productId);

        //String ratingsApiUrl = "http://localhost:8002/rating/{id}";
        String ratingsApiUrl = ratingUrl + "/rating/{id}";
        List<Rating> ratings = restTemplate.getForObject(ratingsApiUrl, List.class, productId);

        product.setRatings(ratings);
        return product;
    }
}
