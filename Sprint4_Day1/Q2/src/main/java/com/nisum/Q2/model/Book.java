package com.nisum.Q2.model;


import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String author;
    private double price;

    public Book(Long id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }


}

