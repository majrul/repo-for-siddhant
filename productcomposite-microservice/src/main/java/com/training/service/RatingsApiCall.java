package com.training.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.dto.Rating;

@FeignClient("ratings-microservice")
public interface RatingsApiCall {

    @GetMapping("/rating/{id}")
    public List<Rating> get(@PathVariable int id);

}
