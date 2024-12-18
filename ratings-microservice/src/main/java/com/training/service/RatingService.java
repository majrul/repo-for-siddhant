package com.training.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.training.entity.Rating;
import com.training.repository.RatingRepository;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private CacheManager cacheManager;
    
    //@CachePut(value = "ratings.cache", key = "#rating.productId")
    public void add(Rating rating) {
        ratingRepository.save(rating);
        cacheManager.getCache("ratings.cache").clear();
    }

    @Cacheable(value = "ratings.cache", key = "#productId")
    public List<Rating> fetch(int productId) {
        return ratingRepository.findByProductId(productId);
    }

    @Cacheable(value = "ratings2.cache")
    public List<Rating> fetch(int productId, LocalDate date) {
        return ratingRepository.findByProductId(productId);
    }
}
