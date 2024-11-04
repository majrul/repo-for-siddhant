package com.training.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Rating;
import com.training.service.RatingService;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rating/add")
    public String add(@RequestBody Rating rating) {
        ratingService.add(rating);
        return "Rating added!";
    }

    @GetMapping("/rating/{productId}")
    public List<Rating> get(@PathVariable int productId) {
        return ratingService.fetch(productId);
    }

    @GetMapping("/rating/{productId}/{date}")
    public List<Rating> get(@PathVariable int productId, @PathVariable LocalDate date) {
        return ratingService.fetch(productId, date);
    }
}
