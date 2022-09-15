package com.dkharchenko_hillel.homework4.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private Double price;
    private Long shopId;
}
