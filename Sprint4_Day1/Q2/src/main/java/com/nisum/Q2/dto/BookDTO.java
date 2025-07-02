package com.nisum.Q2.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @Positive
    private double price;


}

