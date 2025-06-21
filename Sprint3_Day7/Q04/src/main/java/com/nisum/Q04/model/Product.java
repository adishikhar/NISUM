package com.nisum.Q04.model;


import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private String category;


}

