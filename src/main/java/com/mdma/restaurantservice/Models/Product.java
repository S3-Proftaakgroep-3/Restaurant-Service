package com.mdma.restaurantservice.Models;

import com.mdma.restaurantservice.Enums.ProductSize;
import lombok.Data;

@Data
public class Product {

    private String name;
    private String description;
    private Double price;
    private ProductSize size;
    private String category;
    private Boolean active;

    public Product(String name, String description, Double price, ProductSize size, String category, Boolean active) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.category = category;
        this.active = active;
    }
}
