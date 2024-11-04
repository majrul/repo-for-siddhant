package com.training.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {

    private int id;
    private String name;
    private double price;
    private int quantity;
    private String serviceUrl;

    private List<Rating> ratings;
}
